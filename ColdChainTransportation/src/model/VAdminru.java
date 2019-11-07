package model;

/**
 * VAdminru entity. @author MyEclipse Persistence Tools
 */

public class VAdminru implements java.io.Serializable {

	// Fields

		private String name;
		private String sex;
		private String phone;
		private Integer roleid;
		private String userpwd;
		private String username;
		private String userid;

		// Constructors

		/** default constructor */
		public VAdminru() {
		}

		/** minimal constructor */
		public VAdminru(String userid) {
			this.userid = userid;
		}

		/** full constructor */
		public VAdminru(String name, String sex, String phone, Integer roleid,
				String userpwd, String username, String userid) {
			this.name = name;
			this.sex = sex;
			this.phone = phone;
			this.roleid = roleid;
			this.userpwd = userpwd;
			this.username = username;
			this.userid = userid;
		}

		// Property accessors

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return this.sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Integer getRoleid() {
			return this.roleid;
		}

		public void setRoleid(Integer roleid) {
			this.roleid = roleid;
		}

		public String getUserpwd() {
			return this.userpwd;
		}

		public void setUserpwd(String userpwd) {
			this.userpwd = userpwd;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserid() {
			return this.userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}
}