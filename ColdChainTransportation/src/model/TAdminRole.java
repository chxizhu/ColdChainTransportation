package model;



/**
 * TAdminRole entity. @author MyEclipse Persistence Tools
 */

public class TAdminRole  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String description;
     private Integer deepth;
     private Integer parentid;


    // Constructors

    /** default constructor */
    public TAdminRole() {
    }

    
    /** full constructor */
    public TAdminRole(String name, String description, Integer deepth, Integer parentid) {
        this.name = name;
        this.description = description;
        this.deepth = deepth;
        this.parentid = parentid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
   








}