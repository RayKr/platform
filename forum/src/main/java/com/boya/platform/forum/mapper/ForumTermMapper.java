package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.ForumTerm;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository("forumTermMapper")
public interface ForumTermMapper extends Mapper<ForumTerm> {
}