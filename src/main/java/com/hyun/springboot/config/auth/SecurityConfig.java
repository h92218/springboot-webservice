package com.hyun.springboot.config.auth;

import com.hyun.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable().headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests().antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll() //전체 열람 권한
                                            .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER권한을 가진 사람만 가능
                                            .anyRequest().authenticated() //나머지 URL은 모두 인증된 사용자에게 허용
                .and().logout().logoutSuccessUrl("/") //로그아웃 성공시 / 로 이동
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
                    //로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
    }
}
