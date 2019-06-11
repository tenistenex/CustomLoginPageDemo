package com.example.demo3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()          // 定義當需要使用者登入時候，轉到的登入頁面。
		.loginPage("/login")      // 設定登入頁面
		.loginProcessingUrl("/user/login") // 自定義的登入介面
		.failureForwardUrl("/error")
		.and()
		.authorizeRequests()    // 定義哪些URL需要被保護、哪些不需要被保護
		.antMatchers("/login").permitAll()   // 設定所有人都可以訪問登入頁面
		.anyRequest()        // 任何請求,登入後可以訪問
		.authenticated()
		.and()
		.csrf().disable();     // 關閉csrf防護
	}

	
/*	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     
	     auth.inMemoryAuthentication()
	                .withUser("user").password("{noop}123").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}456").roles("ADMIN");
	    }*/
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	  }
}
