package business.impl;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.SystemModelDAO;


public class SystemModelDAOImpl implements SystemModelDAO {
	private HibernateDAO bdao=null;
	
	
	public SystemModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}


	@Override
	public List<TSystemModel> getTSystemModelList() {
		String hql = "from TSystemModel order by parentid,displayorder asc";
		return bdao.select(hql);
	}


	@Override
	public List<VRoleSystemModel> getSystemModelByRole(int roleid) {
		String hql = "from VRoleSystemModel where roleid = ? order by displayorder,deepth asc";
		Object[] param = {roleid};
		List list =  bdao.select(hql,param);
		return list;
	}

}
