package model;

/**
 * TAdminUser entity. @author MyEclipse Persistence Tools
 */

public class TAdminUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private String userpwd;
	private Integer roleid;
	private String phone;
	private String sex;

	// Constructors

	/** default constructor */
	public TAdminUser() {
	}

	/** minimal constructor */
	public TAdminUser(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public TAdminUser(String userid, String username, String userpwd,
			Integer roleid, String phone, String sex) {
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.roleid = roleid;
		this.phone = phone;
		this.sex = sex;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}