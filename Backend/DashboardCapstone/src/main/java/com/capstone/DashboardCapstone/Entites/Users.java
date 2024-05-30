package com.capstone.DashboardCapstone.Entites;

import com.capstone.DashboardCapstone.Entites.Enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private Long userId;
	private String userName;
	private String pwd;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
}
