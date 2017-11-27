package com.boya.platform.marineonline.controller;

import com.boya.platform.marineonline.model.dto.ResponseDTO;
import com.boya.platform.marineonline.model.po.BypStageUserInfo;
import com.boya.platform.marineonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/27 13:49
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/info/stageuser")
    public ResponseDTO getStageUserInfo(@RequestParam("loginName") String loginName,
                                        @RequestParam("password") String password) {
        // 查询用户
        BypStageUserInfo bypStageUserInfo = userService.selectStageUser(loginName, password);

        // 返回json
        ResponseDTO res = new ResponseDTO();
        if (bypStageUserInfo != null) {
            res.setResult(true);
            res.setData(bypStageUserInfo);
        } else {
            res.setResult(false);
            res.setMsg("用户名或密码错误！");
        }
        return res;
    }


}
