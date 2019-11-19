package business.impl;

import java.util.List;
import model.TLineArrange;
import business.basic.HibernateDAO;
import business.basic.HibernateDAOimpl;
import business.dao.LineArrangeDAO;

public class LineArrangeDAOImpl implements LineArrangeDAO {
	private HibernateDAO bdao=null;
	
	public LineArrangeDAOImpl() {
		bdao = new HibernateDAOimpl();
	}

	@Override
	public int addLineArrange(TLineArrange line) {
		Object obj = bdao.insert(line);
		if (obj != null)
			return 0;
		else
			return 1;	
	}

	@Override
	public boolean deleteLineArrange(int laid) {
		return bdao.delete(TLineArrange.class, laid);
	}

	@Override
	public List<TLineArrange> seletLineArrange(int page, int limit) {
		String hql = "from TLineArrange";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getSystemLineArrangeAmount() {
		String hql = "select count(*) from TLineArrange";
		return bdao.selectValue(hql);
	}

	@Override
	public List<TLineArrange> selectByLike(String wherecondition, int page,
			int limit) {
		String hql = "from TLineArrange ";
		if(wherecondition!=null && !wherecondition.equals("")){
			hql += wherecondition;
		}
		List list = bdao.selectByPage(hql, page, limit);
		return list;
	}

}
