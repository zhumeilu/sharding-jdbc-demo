package com.zml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/9
 * Time: 15:46
 */
@Controller
public class AdminController {

    @RequestMapping("/index")
    @ResponseBody
    public Object index(){
        return "hello";
    }
}
