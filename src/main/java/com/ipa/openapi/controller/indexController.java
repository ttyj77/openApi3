package com.ipa.openapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
//        @AuthenticationPrincipal UserCustomDetails details   로그인 된 사용자 정보 가져옴
        return "index";
    }

    @GetMapping("/table")
    public String table() {
        return "tables";
    }

    @GetMapping("/apis")
    public String apis() {
        return "apis";
    }


    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "main page";
    }


}
