package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumTermRelationship;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository("forumTermrelationshipMapper")
public interface ForumTermRelationshipMapper extends Mapper<ForumTermRelationship> {
}