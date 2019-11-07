package model;

/**
 * TDutyArrange entity. @author MyEclipse Persistence Tools
 */

public class TDutyArrange implements java.io.Serializable {

	// Fields

	private Integer daid;
	private String userid;
	private Integer carid;

	// Constructors

	/** default constructor */
	public TDutyArrange() {
	}

	/** full constructor */
	public TDutyArrange(String userid, Integer carid) {
		this.userid = userid;
		this.carid = carid;
	}

	// Property accessors

	public Integer getDaid() {
		return this.daid;
	}

	public void setDaid(Integer daid) {
		this.daid = daid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

}