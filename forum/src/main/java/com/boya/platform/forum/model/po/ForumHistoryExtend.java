package com.boya.platform.forum.model.po;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/16 11:25
 */
public class ForumHistoryExtend extends ForumHistory {

    private String postTitle;

    private String postAuthorName;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostAuthorName() {
        return postAuthorName;
    }

    public void setPostAuthorName(String postAuthorName) {
        this.postAuthorName = postAuthorName;
    }
}
