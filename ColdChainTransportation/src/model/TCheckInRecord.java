package model;

import java.sql.Timestamp;

/**
 * TCheckInRecord entity. @author MyEclipse Persistence Tools
 */

public class TCheckInRecord implements java.io.Serializable {

	// Fields

	private Integer cirid;
	private Integer linepid;
	private String xcoordinate;
	private String ycoordinate;
	private Integer daid;
	private Timestamp clocktime;

	// Constructors

	/** default constructor */
	public TCheckInRecord() {
	}

	/** full constructor */
	public TCheckInRecord(Integer linepid, String xcoordinate,
			String ycoordinate, Integer daid, Timestamp clocktime) {
		this.linepid = linepid;
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.daid = daid;
		this.clocktime = clocktime;
	}

	// Property accessors

	public Integer getCirid() {
		return this.cirid;
	}

	public void setCirid(Integer cirid) {
		this.cirid = cirid;
	}

	public Integer getLinepid() {
		return this.linepid;
	}

	public void setLinepid(Integer linepid) {
		this.linepid = linepid;
	}

	public String getXcoordinate() {
		return this.xcoordinate;
	}

	public void setXcoordinate(String xcoordinate) {
		this.xcoordinate = xcoordinate;
	}

	public String getYcoordinate() {
		return this.ycoordinate;
	}

	public void setYcoordinate(String ycoordinate) {
		this.ycoordinate = ycoordinate;
	}

	public Integer getDaid() {
		return this.daid;
	}

	public void setDaid(Integer daid) {
		this.daid = daid;
	}

	public Timestamp getClocktime() {
		return this.clocktime;
	}

	public void setClocktime(Timestamp clocktime) {
		this.clocktime = clocktime;
	}

}