package business.impl;

import java.util.List;

import model.TAdminUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.UserLoginDAO;

public class UserLoginDAOImpl implements UserLoginDAO {
	private HibernateDAO bdao=null;
	
	
	public UserLoginDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public TAdminUser chaxunadmini(String userid, String userpwd) {
		String hql = "from TAdminUser where userid = ? and userpwd = ?";
		Object[] para = {userid,userpwd};
		List list = bdao.select(hql, para);
		if(list.size()>0)
		{
			return (TAdminUser)list.get(0);
		}
		else
		{
			return null;
		}
	}

}
