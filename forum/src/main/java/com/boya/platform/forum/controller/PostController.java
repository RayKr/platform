package com.boya.platform.forum.controller;

import com.boya.platform.forum.model.dto.CommentDTO;
import com.boya.platform.forum.model.dto.PostDTO;
import com.boya.platform.forum.model.dto.PostDetailDTO;
import com.boya.platform.forum.model.dto.ResponseDTO;
import com.boya.platform.forum.model.po.ForumFavoriteExtend;
import com.boya.platform.forum.model.po.ForumHistoryExtend;
import com.boya.platform.forum.service.CommentService;
import com.boya.platform.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 帖子类相关信息路由
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 13:53
 */
@RestController
@RequestMapping(value = "/api/post")
public class PostController extends AbstractController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    /**
     * 获取用户发的帖子
     */
    @RequestMapping(value = "/list")
    public Object getPosts(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取分页
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.selectByUser(userId, pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 获取用户发的帖子
     */
    @RequestMapping(value = "/listext")
    public Object getPostsExt(@RequestBody Map map) {
        // 为了提供可查看他人信息的接口，提供user_id备用
        Long curUserId = getAimUserId(map);
        if (curUserId == null) {
            return res;
        }
        // 获取分页
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.selectByUser(curUserId, pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 提供一篇帖子的详细页数据
     * @param map 接收前端参数
     * @return Object
     */
    @RequestMapping(value = "/detail")
    public Object getPostDetail(@RequestBody Map map) {
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());

        // 记录用户浏览历史
        if (isLogin()) {
            postService.recordHistory(userId, postId);
        }
        // 增加一次阅读数
        postService.addReadCount(postId);
        // 获取该篇文章
        PostDTO postDTO = postService.selectByPostId(userId, postId);
        // 获取该篇文章下的评论
        List<CommentDTO> commentDTOS = commentService.selectByPostId(postId, pageNum, pageSize);

        PostDetailDTO detailDTO = new PostDetailDTO();
        detailDTO.setPost(postDTO);
        detailDTO.setComments(commentDTOS);

        // 复杂对象，单独赋值total为评论总记录数
        res.setTotal(commentDTOS);
        res.setData(detailDTO);
        return res;
    }

    /**
     * 主页所有帖子列表（除官方帖子）
     */
    @RequestMapping(value = "/mainlist")
    public Object getIndexPosts(@RequestBody Map map) {
        res = new ResponseDTO();
        // 获取分页
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.selectAll(pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 主页所有官方帖子列表
     */
    @RequestMapping(value = "/officiallist")
    public Object getGovIndexPosts(@RequestBody Map map) {
        res = new ResponseDTO();
        // 获取分页
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.selectAllOfficial(pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 主页所有帖子列表
     */
    @RequestMapping(value = "/search")
    public Object searchPost(@RequestBody Map map) {
        res = new ResponseDTO();
        // 获取分页和搜索条件
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        String keywords = map.get("keywords").toString();
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.searchByKeyWords(keywords, pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 主页所有帖子列表
     */
    @RequestMapping(value = "/followinglist")
    public Object getFollowingPosts(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取分页
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该用户发的帖子
        List<PostDTO> posts = postService.selectFollowingPosts(userId, pageNum, pageSize);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 主页所有帖子列表
     */
    @RequestMapping(value = "/send")
    public Object insertPost(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        String title = map.get("title").toString();
        String post = map.get("post").toString();

        // 发帖
        postService.insertPost(userId, title, post);
        // 封装json
        res.setMsg("发帖成功！");
        return res;
    }

    /**
     * 主页所有帖子列表
     */
    @RequestMapping(value = "/delete")
    public Object deletePost(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());

        // 发帖
        postService.deletePost(postId);
        // 封装json
        res.setMsg("删帖成功！");
        return res;
    }

    /**
     * 获取用户的帖子浏览历史
     */
    @RequestMapping(value = "/history")
    public Object getHistory() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 历史记录
        List<ForumHistoryExtend> history = postService.selectHistoryLatest(userId);
        res.setData(history);
        return res;
    }

    /**
     * 收藏
     */
    @RequestMapping(value = "/favorite")
    public Object favoritePost(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        // 收藏帖子
        try {
            postService.addFavoritePost(userId, postId);
            res.setMsg("帖子收藏成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    /**
     * 取消收藏
     */
    @RequestMapping(value = "/cancelfavorite")
    public Object cancelfavoritePost(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        // 收藏帖子
        try {
            postService.delFavoritePost(userId, postId);
            res.setMsg("取消收藏成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    /**
     * 点赞文章
     */
    @RequestMapping(value = "/like")
    public Object likePost(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        // 点赞帖子
        try {
            postService.addLikePost(userId, postId);
            res.setMsg("点赞成功！");
        } catch (Exception e) {
            res.setResult(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    /**
     * 获取用户的帖子浏览历史
     */
    @RequestMapping(value = "/favoritelist")
    public Object favoritePostList() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 收藏帖子
        List<ForumFavoriteExtend> posts = postService.selectFavoritePostList(userId);
        // 封装json
        res.setData(posts);
        return res;
    }

    /**
     * 获取用户的帖子浏览历史
     */
    @RequestMapping(value = "/likelist")
    public Object likePostList() {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 点赞帖子
        List<ForumFavoriteExtend> posts = postService.selectLikePostList(userId);
        // 封装json
        res.setData(posts);
        return res;
    }

}
