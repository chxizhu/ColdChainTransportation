package business.impl;

import java.util.List;

import model.TAdminUser;
import model.TCar;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.CarModelDAO;

public class CarModelDAOImpl implements CarModelDAO {
	private HibernateDAO bdao=null;
	
	public CarModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public List<TCar> seletCar(int page, int limit) {
		String hql = "from TCar";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public boolean deleteCar(int carid) {
		return bdao.delete(TCar.class, carid);
	}

	@Override
	public int addCar(TCar user) {
		Object obj = bdao.insert(user);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

}
