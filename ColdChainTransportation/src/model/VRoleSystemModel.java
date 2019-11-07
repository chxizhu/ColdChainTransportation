package model;

import java.sql.Timestamp;



/**
 * VRoleSystemModel entity. @author MyEclipse Persistence Tools
 */

public class VRoleSystemModel  implements java.io.Serializable {


	// Fields    

    private Integer id;
    private Integer roleid;
    private Integer sysid;
    private String isedit;
    private Timestamp createdate;
    private String name;
    private String chinesename;
    private String navurl;
    private Integer accesslevel;
    private Integer deepth;
    private Integer parentid;
    private Integer displayorder;
    private String imageurl;
    private String value;
    private String systemname;
    private Boolean isdelete;
    private String rolename;


   // Constructors

   /** default constructor */
   public VRoleSystemModel() {
   }

	/** minimal constructor */
   public VRoleSystemModel(Integer id) {
       this.id = id;
   }
   
   /** full constructor */
   public VRoleSystemModel(Integer id, Integer roleid, Integer sysid, String isedit, Timestamp createdate, String name, String chinesename, String navurl, Integer accesslevel, Integer deepth, Integer parentid, Integer displayorder, String imageurl, String value, String systemname, Boolean isdelete, String rolename) {
       this.id = id;
       this.roleid = roleid;
       this.sysid = sysid;
       this.isedit = isedit;
       this.createdate = createdate;
       this.name = name;
       this.chinesename = chinesename;
       this.navurl = navurl;
       this.accesslevel = accesslevel;
       this.deepth = deepth;
       this.parentid = parentid;
       this.displayorder = displayorder;
       this.imageurl = imageurl;
       this.value = value;
       this.systemname = systemname;
       this.isdelete = isdelete;
       this.rolename = rolename;
   }

  
   // Property accessors

   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   public Integer getRoleid() {
       return this.roleid;
   }
   
   public void setRoleid(Integer roleid) {
       this.roleid = roleid;
   }

   public Integer getSysid() {
       return this.sysid;
   }
   
   public void setSysid(Integer sysid) {
       this.sysid = sysid;
   }

   public String getIsedit() {
       return this.isedit;
   }
   
   public void setIsedit(String isedit) {
       this.isedit = isedit;
   }

   public Timestamp getCreatedate() {
       return this.createdate;
   }
   
   public void setCreatedate(Timestamp createdate) {
       this.createdate = createdate;
   }

   public String getName() {
       return this.name;
   }
   
   public void setName(String name) {
       this.name = name;
   }

   public String getChinesename() {
       return this.chinesename;
   }
   
   public void setChinesename(String chinesename) {
       this.chinesename = chinesename;
   }

   public String getNavurl() {
       return this.navurl;
   }
   
   public void setNavurl(String navurl) {
       this.navurl = navurl;
   }

   public Integer getAccesslevel() {
       return this.accesslevel;
   }
   
   public void setAccesslevel(Integer accesslevel) {
       this.accesslevel = accesslevel;
   }

   public Integer getDeepth() {
       return this.deepth;
   }
   
   public void setDeepth(Integer deepth) {
       this.deepth = deepth;
   }

   public Integer getParentid() {
       return this.parentid;
   }
   
   public void setParentid(Integer parentid) {
       this.parentid = parentid;
   }

   public Integer getDisplayorder() {
       return this.displayorder;
   }
   
   public void setDisplayorder(Integer displayorder) {
       this.displayorder = displayorder;
   }

   public String getImageurl() {
       return this.imageurl;
   }
   
   public void setImageurl(String imageurl) {
       this.imageurl = imageurl;
   }

   public String getValue() {
       return this.value;
   }
   
   public void setValue(String value) {
       this.value = value;
   }

   public String getSystemname() {
       return this.systemname;
   }
   
   public void setSystemname(String systemname) {
       this.systemname = systemname;
   }

   public Boolean getIsdelete() {
       return this.isdelete;
   }
   
   public void setIsdelete(Boolean isdelete) {
       this.isdelete = isdelete;
   }

   public String getRolename() {
       return this.rolename;
   }
   
   public void setRolename(String rolename) {
       this.rolename = rolename;
   }

}