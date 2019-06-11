package com.example.demo3;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails extends Serializable {
	// 封裝了許可權資訊
	Collection<? extends GrantedAuthority> getAuthorities();
	// 密碼資訊
	String getPassword();
	// 登入使用者名稱
	String getUsername();
	// 帳戶是否過期
	boolean isAccountNonExpired();
	// 帳戶是否被凍結
	boolean isAccountNonLocked();
	// 帳戶密碼是否過期，一般有的密碼要求性高的系統會使用到，比較每隔一段時間就要求使用者重置密碼
	boolean isCredentialsNonExpired();
	// 帳號是否可用
	boolean isEnabled();
	}