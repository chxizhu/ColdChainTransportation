package business.dao;

import java.util.List;

/*android studio使用*/

public interface AndroidLoginDAO {
	
	/**
	 * 用户登录业务方法
	 * @param userid 用户登录名
	 * @param password 登录密码
	 * @return VStudent 当前登录的用户对象
	 */
	public boolean isUserLogin(String userid,String pwd);
	
	/**
	  * 返回登录信息
	  * @param userid
	  * @param pwd
	  * @return
	  */	
	 public String loginInfo(String userid,String pwd);
	 
	 
	 /**
	  * 查询司机信息
	  * @param userid
	  * @return
	  */	
		public List getUserinfo(String userid);
	 
		 /**
		  * 查询司机信息转换成JSON
		  * @param userid
		  * @return
		  */	
	 public String getUserinfoToJson(String userid);
	 

}
