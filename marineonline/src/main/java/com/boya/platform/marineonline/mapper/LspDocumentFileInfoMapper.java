package com.boya.platform.marineonline.mapper;

import com.boya.platform.marineonline.model.po.LspDocumentFileInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LspDocumentFileInfoMapper extends Mapper<LspDocumentFileInfo> {

    /**
     * 获取用户头像
     * @param docId
     * @return
     */
    String selectUrlByDocId(@Param("docId") int docId);

}