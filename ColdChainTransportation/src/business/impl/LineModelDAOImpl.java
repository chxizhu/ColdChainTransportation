package business.impl;

import java.util.List;

import model.TAdminUser;
import model.TLine;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.LineModelDAO;

public class LineModelDAOImpl implements LineModelDAO {
	private HibernateDAO bdao=null;
	
	public LineModelDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public int addLine(TLine line) {
		Object obj = bdao.insert(line);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteLine(int lid) {
		return bdao.delete(TLine.class, lid);
	}

	@Override
	public List<TLine> seletLine(int page, int limit) {
		String hql = "from TLine";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getSystemLineAmount() {
		String hql = "select count(*) from TLine";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TLine> selectByLike(String wherecondition, int page, int limit) {
		String hql = "from TLine ";
		if(wherecondition!=null && !wherecondition.equals("")){
			hql += wherecondition;
		}
		List list = bdao.selectByPage(hql, page, limit);
		return list;
	}

	@Override
	public List<TLine> seletLine() {
		String hql = "from TLine";
		return bdao.select(hql);
	}

}
