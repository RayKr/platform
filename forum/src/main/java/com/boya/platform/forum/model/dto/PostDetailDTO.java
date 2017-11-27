package com.boya.platform.forum.model.dto;

import java.util.List;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/14 10:55
 */
public class PostDetailDTO {

    private PostDTO post;

    private List<CommentDTO> comments;

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
