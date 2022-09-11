package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    //GETメソッド
    @GetMapping("/login")
    public String getLoginInfo() {
        //login.htmlに画面遷移
        return "login/login";
    }
    
}
//    POSTメソッド
//    @PostMapping("/login")
//    public String postLoginInfo(Model model) {
//        return "login/login";
//    }
