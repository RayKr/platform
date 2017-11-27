package com.boya.platform.forum.mapper;

import com.boya.platform.forum.model.po.SysEnumDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("sysEnumDetailMapper")
public interface SysEnumDetailMapper extends Mapper<SysEnumDetail> {

    List<SysEnumDetail> selectByType(@Param("type") String type);
}