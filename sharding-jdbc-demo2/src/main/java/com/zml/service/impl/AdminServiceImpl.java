package com.zml.service.impl;

import com.zml.mapper.AdminMapper;
import com.zml.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
