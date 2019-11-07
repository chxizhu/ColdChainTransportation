package model;

/**
 * TAbnormalRR entity. @author MyEclipse Persistence Tools
 */

public class TAbnormalRR implements java.io.Serializable {

	// Fields

	private Integer alid;
	private Integer arid;
	private Integer lrid;

	// Constructors

	/** default constructor */
	public TAbnormalRR() {
	}

	/** full constructor */
	public TAbnormalRR(Integer arid, Integer lrid) {
		this.arid = arid;
		this.lrid = lrid;
	}

	// Property accessors

	public Integer getAlid() {
		return this.alid;
	}

	public void setAlid(Integer alid) {
		this.alid = alid;
	}

	public Integer getArid() {
		return this.arid;
	}

	public void setArid(Integer arid) {
		this.arid = arid;
	}

	public Integer getLrid() {
		return this.lrid;
	}

	public void setLrid(Integer lrid) {
		this.lrid = lrid;
	}

}