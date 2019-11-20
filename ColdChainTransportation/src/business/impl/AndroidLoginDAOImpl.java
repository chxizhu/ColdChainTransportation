package business.impl;

import java.util.List;

import model.LoginAndroid;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.basic.JacksonUtil;
import business.dao.AndroidLoginDAO;

/*android studioÊ¹ÓÃ*/

public class AndroidLoginDAOImpl implements AndroidLoginDAO {
	
private HibernateDAO bado = null;
	
 LoginAndroid login=new LoginAndroid();
	
	public AndroidLoginDAOImpl() {
		this.bado = new HibernateDAOimpl();
		
	}

	@Override
	public boolean isUserLogin(String userid, String pwd) {
		String hql = " from TUser where userid = ? and pwd = ?";		
		Object[] para = {userid, pwd };
		List list = bado.select(hql, para);
		if (list.size() > 0) {
			return true;
		}
		else {
			return false;
		}		
	}

	@Override
	public String loginInfo(String userid, String pwd) {
		 login.setUserid(userid);
		  login.setSuccess(isUserLogin(userid,pwd));
		  return JacksonUtil.beanToJson(login);
	}

}
