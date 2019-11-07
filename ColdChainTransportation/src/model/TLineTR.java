package model;

/**
 * TLineTR entity. @author MyEclipse Persistence Tools
 */

public class TLineTR implements java.io.Serializable {

	// Fields

	private Integer ltrid;
	private Integer tid;
	private Integer lid;

	// Constructors

	/** default constructor */
	public TLineTR() {
	}

	/** full constructor */
	public TLineTR(Integer tid, Integer lid) {
		this.tid = tid;
		this.lid = lid;
	}

	// Property accessors

	public Integer getLtrid() {
		return this.ltrid;
	}

	public void setLtrid(Integer ltrid) {
		this.ltrid = ltrid;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

}