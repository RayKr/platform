package com.boya.platform.forum.controller;

import com.boya.platform.forum.model.dto.CommentDTO;
import com.boya.platform.forum.model.dto.ResponseDTO;
import com.boya.platform.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 回帖相关的业务路由
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/13 19:48
 */
@RestController
@RequestMapping(value = "/api/comment")
public class CommentController extends AbstractController {

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
        List<CommentDTO> comments = commentService.selectByUserId(userId, pageNum, pageSize);
        // 封装json
        res.setData(comments);
        return res;
    }

    /**
     * 获取一篇文章下更多评论
     * @param map
     * @return
     */
    @RequestMapping(value = "/more")
    public Object getCommentsByPost(@RequestBody Map map) {
        res = new ResponseDTO();
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        int pageNum = Integer.parseInt(map.get("pagenum").toString());
        int pageSize = Integer.parseInt(map.get("pagesize").toString());
        // 获取该文章下的评论
        List<CommentDTO> comments = commentService.selectByPostId(postId, pageNum, pageSize);
        // 封装json
        res.setData(comments);
        return res;
    }

    /**
     * 回帖
     * @param map
     * @return
     */
    @RequestMapping(value = "/send")
    public Object sendComment(@RequestBody Map map) {
        // 验证用户登录状态
        if (!checkUserStatus()) {
            return res;
        }
        // 获取参数
        Long postId = Long.parseLong(map.get("post_id").toString());
        String comment = map.get("comment").toString();
        // 插入评论
        commentService.recordComment(userId, postId, comment);

        res.setMsg("评论成功！");
        return res;
    }

}
