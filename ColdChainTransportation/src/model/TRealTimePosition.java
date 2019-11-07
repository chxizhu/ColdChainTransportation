package model;

/**
 * TRealTimePosition entity. @author MyEclipse Persistence Tools
 */

public class TRealTimePosition implements java.io.Serializable {

	// Fields

	private Integer rtpid;
	private String xcoordinate;
	private String ycoordinate;
	private Integer sort;
	private Integer laid;

	// Constructors

	/** default constructor */
	public TRealTimePosition() {
	}

	/** full constructor */
	public TRealTimePosition(String xcoordinate, String ycoordinate,
			Integer sort, Integer laid) {
		this.xcoordinate = xcoordinate;
		this.ycoordinate = ycoordinate;
		this.sort = sort;
		this.laid = laid;
	}

	// Property accessors

	public Integer getRtpid() {
		return this.rtpid;
	}

	public void setRtpid(Integer rtpid) {
		this.rtpid = rtpid;
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

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLaid() {
		return this.laid;
	}

	public void setLaid(Integer laid) {
		this.laid = laid;
	}

}