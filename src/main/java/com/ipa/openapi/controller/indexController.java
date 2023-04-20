package com.ipa.openapi.controller;

import com.ipa.openapi.config.auth.UserCustomDetails;
import com.ipa.openapi.model.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "main page";
    }

    @GetMapping("/providerTable")
    public String table() {

        return "providerTable";
    }

    @GetMapping("/modal")
    public String modal(){
        return "modalTest";
    }


}
