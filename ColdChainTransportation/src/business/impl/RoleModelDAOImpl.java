package business.impl;

import java.util.List;

import model.TAdminRole;
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

}
