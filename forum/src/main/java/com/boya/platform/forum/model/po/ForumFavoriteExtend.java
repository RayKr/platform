package com.boya.platform.forum.model.po;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/16 18:51
 */
public class ForumFavoriteExtend extends ForumFavorite {

    private String postTitle;

    private String postAuthorName;

    private String postAuthorPortrait;

    private Long likeCount;

    private Long readCount;

    public Long getReadCount() {
        return readCount;
    }

    public Long getLikeCount() {

        return likeCount;
    }

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

    public String getPostAuthorPortrait() {
        return postAuthorPortrait;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public void setPostAuthorPortrait(String postAuthorPortrait) {

        this.postAuthorPortrait = postAuthorPortrait;
    }
}
