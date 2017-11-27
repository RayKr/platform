package com.boya.platform.forum.service;

import com.boya.platform.forum.mapper.SysEnumDetailMapper;
import com.boya.platform.forum.mapper.SysEnumMainMapper;
import com.boya.platform.forum.model.po.SysEnumDetail;
import com.boya.platform.forum.model.po.SysEnumMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 枚举工具类
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/9 18:38
 */
@Service
public class EnumType {

    /**
     * 用于存储所有枚举的MAP集合
     */
    private static Map<String, Map> typeMap;

    @Autowired
    private SysEnumMainMapper sysEnumMainMapper;

    @Autowired
    private SysEnumDetailMapper sysEnumDetailMapper;

    /**
     * 声明一个该工具类的静态的内部对象
     */
    private static EnumType enumType;

    /**
     * 使用注解@PostConstruct把需要使用的service加载到上面定义的静态内部对象中
     */
    @PostConstruct
    public void init() {
        enumType = this;
        enumType.sysEnumMainMapper = this.sysEnumMainMapper;
        enumType.sysEnumDetailMapper = this.sysEnumDetailMapper;
    }

    /**
     * 根据枚举值获取对应的显示名称
     * @param type 枚举类型
     * @param value 枚举值 int类型
     * @return
     */
    public static String get(String type,int value) {
        if (typeMap == null || typeMap.isEmpty()) {
            EnumType.getTypeMap();
        }
        Map<String, String> map = typeMap.get(type);
        return map.get(value);
    }

    /**
     * 为枚举的修改提供刷新方法
     */
    public static void reload() {
        typeMap.clear();
        EnumType.getTypeMap();
    }

    /**
     * 获取所有类型枚举
     * @return map
     */
    private static Map<String, Map> getTypeMap() {

        String type;
        Integer value;
        String name;
        Map<Integer, String> enuMap;
        typeMap = new HashMap<>();

        List<SysEnumMain> types = enumType.sysEnumMainMapper.selectAll();
        for (SysEnumMain t : types) {
            // 此处需重新创建实例，而不能用enuMap.clear()
            enuMap = new HashMap<>();
            // 获取类型
            SysEnumMain enu = t;
            type = enu.getEnumType();
            // 根据类型获取该类型所有枚举
            List<SysEnumDetail> enumDetails = enumType.sysEnumDetailMapper.selectByType(type);
            for (SysEnumDetail enumDetail : enumDetails) {
                value = enumDetail.getEnumValue().intValue();
                name = enumDetail.getEnumName();
                // 将枚举值-名对放入map
                enuMap.put(value, name);
            }
            // 将枚举放入类型map
            typeMap.put(type, enuMap);
        }

        return typeMap;
    }

}
