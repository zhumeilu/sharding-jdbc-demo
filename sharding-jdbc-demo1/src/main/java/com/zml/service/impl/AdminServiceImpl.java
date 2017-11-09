package com.zml.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.zml.mapper.AdminMapper;
import com.zml.model.Admin;
import com.zml.service.IAdminService;
import com.zml.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/30
 * Time: 9:58
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String username, String password) {

        EntityWrapper<Admin> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("username",username);
        entityWrapper.eq("password", MD5Util.MD5(password));
        List<Admin> admins = adminMapper.selectList(entityWrapper);
        if(admins!=null&&admins.size()==1){
            return admins.get(0);
        }
        return null;
    }

    @Override
    public Admin regist(String username, String password) {
        Admin admin  = new Admin();
        admin.setUsername(username);
        adminMapper.insert(admin);
        return admin;
    }

    @Override
    public void changePwd(Admin admin) {
        adminMapper.updateById(admin);
    }
}
