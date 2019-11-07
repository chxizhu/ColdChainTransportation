package model;

/**
 * TCar entity. @author MyEclipse Persistence Tools
 */

public class TCar implements java.io.Serializable {

	// Fields

	private Integer carid;
	private String carnum;
	private Boolean status;
	private Boolean fanstatuds;
	private String remarks;

	// Constructors

	/** default constructor */
	public TCar() {
	}

	/** full constructor */
	public TCar(String carnum, Boolean status, Boolean fanstatuds,
			String remarks) {
		this.carnum = carnum;
		this.status = status;
		this.fanstatuds = fanstatuds;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public String getCarnum() {
		return this.carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getFanstatuds() {
		return this.fanstatuds;
	}

	public void setFanstatuds(Boolean fanstatuds) {
		this.fanstatuds = fanstatuds;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}