package business.impl;

import java.util.List;

import model.TAdminUser;
import model.VAdminru;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.UserLoginDAO;

public class UserLoginDAOImpl implements UserLoginDAO {
	private HibernateDAO bdao=null;
	
	
	public UserLoginDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public VAdminru chaxunadmini(String userid, String userpwd) {
		String hql = "from VAdminru where userid = ? and userpwd = ?";
		Object[] para = {userid,userpwd};
		List list = bdao.select(hql, para);
		if(list.size()>0)
		{
			return (VAdminru)list.get(0);
		}
		else
		{
			return null;
		}
	}

}
