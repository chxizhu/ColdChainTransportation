package business.impl;

import java.util.List;

import model.TAdminRole;
import model.TAdminUser;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.RoleModelDAO;

public class RoleModelDAOImpl implements RoleModelDAO {
	
	private HibernateDAO bdao=null;
	
	public RoleModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}


	@Override
	public List<TAdminRole> seletRolelist() {
		String hql = "from TAdminRole";
		return bdao.select(hql);
	}

	@Override
	public int addrole(TAdminRole role) {
		Object obj = bdao.insert(role);
		if (obj != null)
			return 0;
		else
			return 1;	
	}


	@Override
	public boolean deleterole(int id) {
		return bdao.delete(TAdminRole.class, id);
	}


	@Override
	public List<TAdminRole> seletrole(int page, int limit) {
		String hql = "from TAdminRole";
		return bdao.selectByPage(hql, page, limit);
	}


	@Override
	public int getSystemRoleAmount() {
		String hql = "select count(*) from TAdminRole";
		return bdao.selectValue(hql);
	}

}
