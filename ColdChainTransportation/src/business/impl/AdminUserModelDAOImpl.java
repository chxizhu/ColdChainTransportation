package business.impl;

import java.util.List;

import model.TAdminUser;
import model.VAdminru;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.AdminUserModelDAO;

public class AdminUserModelDAOImpl implements AdminUserModelDAO {
	private HibernateDAO bdao=null;
	
	public AdminUserModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public int addUsers(TAdminUser user) {
		Object obj = bdao.insert(user);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteUsers(String userid) {
		return bdao.delete(TAdminUser.class, userid);
	}

	@Override
	public List<VAdminru> seletUsers(int page, int limit) {
		String hql = "from VAdminru";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getSystemUserAmount() {
		String hql = "select count(*) from VAdminru";
		return bdao.selectValue(hql);
	}

	@Override
	public List<VAdminru> selectByLike(String wherecondition, int page,
			int limit) {
		String hql = "from VAdminru ";
		if(wherecondition!=null && !wherecondition.equals("")){
			hql += wherecondition;
		}
		List list = bdao.selectByPage(hql, page, limit);
		return list;
	}

}
