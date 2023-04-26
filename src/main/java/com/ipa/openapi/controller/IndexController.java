package com.ipa.openapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("")
    public String index() {
//        @AuthenticationPrincipal UserCustomDetails details   로그인 된 사용자 정보 가져옴
        return "index";
    }

    @GetMapping("/headSideBar")
    public String apisTest() {
        return "/fragment/headSideBar";
    }

    @GetMapping("/test")
    public String test() {
        return "tables";
    }

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "main page";
    }

    @GetMapping("/modal")
    public String modal() {
        return "modalTest";
    }

    @GetMapping("accountList")
    public String accountList() {
        return "accountList";
    }
    @GetMapping("requestPage")
    public String Authorization() {
        return "requestPage";
    }
    @GetMapping("authorization")
    public String authorization() {
        return "authorization";
    }

}