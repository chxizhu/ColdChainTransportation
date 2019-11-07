package model;

/**
 * TTemperature entity. @author MyEclipse Persistence Tools
 */

public class TTemperature implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String realtimet;
	private Integer sort;

	// Constructors

	/** default constructor */
	public TTemperature() {
	}

	/** full constructor */
	public TTemperature(String realtimet, Integer sort) {
		this.realtimet = realtimet;
		this.sort = sort;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getRealtimet() {
		return this.realtimet;
	}

	public void setRealtimet(String realtimet) {
		this.realtimet = realtimet;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}