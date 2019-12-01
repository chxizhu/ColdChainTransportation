package business.impl;

import java.util.List;

import model.TAdminUser;
import model.TTemperature;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.TempModelDAO;

public class TempModelDAOImpl implements TempModelDAO {
	private HibernateDAO bdao=null;
	
	public TempModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}
	
	@Override
	public int addTemperature(TTemperature team) {
		Object obj = bdao.insert(team);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public List<TTemperature> seletTemperature(int page, int limit) {
		String hql = "from TTemperature";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getTemperatureAmount() {
		String hql = "select count(*) from TTemperature";
		return bdao.selectValue(hql);
	}

	@Override
	public boolean deleteUsers(int tid) {
		return bdao.delete(TTemperature.class, tid);
	}

	@Override
	public List<TTemperature> seletTemperature() {
		String hql = "from TTemperature";
		return bdao.select(hql);
	}

}
