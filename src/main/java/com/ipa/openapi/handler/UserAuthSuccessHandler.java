package com.ipa.openapi.handler;

import com.ipa.openapi.config.auth.UserCustomDetails;
import com.ipa.openapi.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class UserAuthSuccessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        System.out.println("success handler in");
        UserDTO userDTO = ((UserCustomDetails) authentication.getPrincipal()).getUserDTO();
        System.out.println(userDTO);
        userDTO.setPassword(null);

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("logIn", userDTO);

        httpServletResponse.sendRedirect("/main");
        System.out.println("success handler out");
    }
}
