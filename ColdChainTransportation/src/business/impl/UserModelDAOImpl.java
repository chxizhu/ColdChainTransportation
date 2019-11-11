package business.impl;

import java.util.List;

import model.TAdminUser;
import model.TUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.UserModelDAO;

public class UserModelDAOImpl implements UserModelDAO {
	private HibernateDAO bdao=null;

	public UserModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public List<TUser> seletUsers(int page, int limit) {
		String hql = "from TUser";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public boolean deleteUsers(String userid) {
		return bdao.delete(TUser.class, userid);
	}

	@Override
	public int addUsers(TUser user) {
		Object obj = bdao.insert(user);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

}
