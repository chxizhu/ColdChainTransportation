package business.impl;

import java.util.List;

import model.TPunchTheTloc;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.PunchTheTlocQrCodeDAO;

public class PunchTheTlocQrCodeDAOImpl implements PunchTheTlocQrCodeDAO {
	
private HibernateDAO bdao=null;
	
	public PunchTheTlocQrCodeDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public List<TPunchTheTloc> seletPunchTheTlocQrCode(int page, int limit) {
		String hql = "from TPunchTheTloc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getPunchTheTlocQrCodeAmount() {
		String hql = "select count(*) from TPunchTheTloc";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TPunchTheTloc> seletPunchTheTlocQrCodeByLike(
			String wherecondition, int page, int limit) {

		String hql = "from TPunchTheTloc ";
		if(wherecondition!=null && !wherecondition.equals("")){
			hql += wherecondition;
		}
		List list = bdao.selectByPage(hql, page, limit);
		return list;
		
	}

	@Override
	public int seletPunchTheTlocQrCodeByLikeAmount(String wherecondition) {
		String hql = "select count(*) from TPunchTheTloc ";
		if(wherecondition!=null && !wherecondition.equals("")){
			hql += wherecondition;
		}
		return bdao.selectValue(hql);
	}

	@Override
	public boolean deletePunchTheTlocQrCode(int pttid) {
		return bdao.delete(TPunchTheTloc.class, pttid);
	}

}
