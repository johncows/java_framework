package com.kk.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        为页面配置拦截规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
//        开启页面登录
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userlogin");
//        开启注销
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remmber");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP2").and()
                .withUser("lisi").password("123456").roles("VIP1", "VIP3").and()
                .withUser("wangwu").password("123456").roles("VIP2", "VIP3");
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
