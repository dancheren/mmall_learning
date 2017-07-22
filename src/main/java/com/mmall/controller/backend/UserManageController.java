package com.mmall.controller.backend;


import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 76911 on 2017/7/12.
 */

@RequestMapping("/manage/user/")
@Controller
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="/login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){   //如果该请求是成功的，已经确立会话
            User user = response.getData();
            if(user.getRole() == Const.Roles.ROLE_ADMIN){
                session.setAttribute(Const.CURENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("您不是管理员,无法登陆");
            }
        }
        return response;
    }
}
