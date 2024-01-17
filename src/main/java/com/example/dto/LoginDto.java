package com.example.dto;

import java.time.LocalDate;

public class LoginDto {

		private Long roleid;
		private String roleName;
		private String permissions;
		private Long userid;
		private String name;
		private LocalDate birthday;
		
		
		
		public LoginDto(Long roleid, String roleName, String permissions, Long userid, String name,
				LocalDate birthday) {
			super();
			this.roleid = roleid;
			this.roleName = roleName;
			this.permissions = permissions;
			this.userid = userid;
			this.name = name;
			this.birthday = birthday;
		}



		public Long getRoleid() {
			return roleid;
		}



		public void setRoleid(Long roleid) {
			this.roleid = roleid;
		}



		public String getRoleName() {
			return roleName;
		}



		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}



		public String getPermissions() {
			return permissions;
		}



		public void setPermissions(String permissions) {
			this.permissions = permissions;
		}



		public Long getUserid() {
			return userid;
		}



		public void setUserid(Long userid) {
			this.userid = userid;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public LocalDate getBirthday() {
			return birthday;
		}



		public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
		}
		
		
		
}