package com.zml.service;


import com.zml.model.Admin;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/30
 * Time: 9:57
 */
public interface IAdminService {
    Admin login(String username, String password);

    Admin regist(String username, String password);

    void changePwd(Admin admin);
}
