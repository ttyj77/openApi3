package com.ipa.openapi.config;

import com.ipa.openapi.handler.UserAuthFailHandler;
import com.ipa.openapi.handler.UserAuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
// secured Annotation 활성화 / preAuthorize Annotation 활성화
// 일반 메소드에 @Secured("ROLE_ADMIN") 단독 설정 가능 => 신버전
// 일반 메소드에 @PreAuthorize("hasRole('ROLE_USER') or "hasRole('ROLE_ADMIN)") 다중 설정 가능 => 구버전
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationSuccessHandler userAuthSuccessHandler() {
        return new UserAuthSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler userAuthFailureHandler() {
        return new UserAuthFailHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/", "/error/*", "/login.html", "/login_proc", "/user/login", "/user/register").permitAll() // 설정된 url은 인증되지 않더라도 누구든 접근 가능
//                .anyRequest().authenticated()// 위 페이지 외 인증이 되어야 접근가능(ROLE에 상관없이)
                .requestMatchers("/main").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/").loginPage("/user/login")  // 접근이 차단된 페이지 클릭시 이동할 url
                .loginProcessingUrl("/login-proc") // 로그인시 맵핑되는 url
                .usernameParameter("username")      // view form 태그 내에 로그인 할 id 에 맵핑되는 name ( form 의 name )
                .passwordParameter("password")      // view form 태그 내에 로그인 할 password 에 맵핑되는 name ( form 의 name )
                .successHandler(userAuthSuccessHandler()) // 로그인 성공시 실행되는 메소드
                .failureHandler(userAuthFailureHandler()) // 로그인 실패시 실행되는 메소드
                .permitAll()
                .and()
                .logout() // 로그아웃 설정
                .logoutUrl("/user/logout") // 로그아웃시 맵핑되는 url
                .logoutSuccessUrl("/") // 로그아웃 성공시 리다이렉트 주소
                .invalidateHttpSession(true); // 세션 clear
        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/css/**","/scss/**","/vendor/**");
    }

}
