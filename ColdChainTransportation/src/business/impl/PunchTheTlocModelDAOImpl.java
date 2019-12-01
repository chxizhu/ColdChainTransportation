package business.impl;

import model.TPunchTheTloc;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.PunchTheTlocModelDAO;

public class PunchTheTlocModelDAOImpl implements PunchTheTlocModelDAO {
	private HibernateDAO bdao=null;
	
	
	public PunchTheTlocModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}


	@Override
	public int addLine(TPunchTheTloc tlc) {
		Object obj = bdao.insert(tlc);
		System.out.println(tlc.getXcoordinate());
		if (obj != null)
			return 0;
		else
			return 1;
	}

}
