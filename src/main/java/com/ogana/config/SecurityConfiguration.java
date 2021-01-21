package com.ogana.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/boc/password-change").permitAll()
                .mvcMatchers("/boc/main").permitAll() // todo 지우기
                .mvcMatchers("/boc/face-section").permitAll() // todo 지우기
                .mvcMatchers("/boc/face-section-detail").permitAll() // todo 지우기
                .antMatchers("/h2-console/*").permitAll() // todo 지우기
//                .mvcMatchers("/boc/**").authenticated()
                .anyRequest().permitAll();
        
        http.headers().frameOptions().disable(); // todo 지우기
        
        http.formLogin()
                .loginPage("/boc/login").permitAll()
                .defaultSuccessUrl("/boc/main");

        http.logout()
                .logoutSuccessUrl("/boc/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/boc/css/**")
                .mvcMatchers("/node_modules/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
