package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumUserRelationship;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("forumUserRelationshipMapper")
public interface ForumUserRelationshipMapper extends Mapper<ForumUserRelationship> {
}