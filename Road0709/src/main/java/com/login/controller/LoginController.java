package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    //GETメソッド
    @GetMapping("/login")
    public String getLoginInfo() {
        //login.htmlに画面遷移
        return "login";
    }
    /*@GetMapping("/")
    public String topPage() {
        //serch&list.htmlに画面遷移
        return "html/serch&list";
    }*/
    
    
    //POSTメソッド
    //@PostMapping("/logout")
    //public String postLogoutInfo() {
    //    return "redirect:login";
    //    }
}