package business.dao;
import java.util.List;

import model.TAdminRole;
import model.TLine;

public interface LineModelDAO {
	/**
	 * 添加路线
	 * @param TLine 路线对象
	 * @return 成功返回0失败返回1
	 */
	public int addLine(TLine line);
	/**
	 * 通过id进行删除管理员角色
	 * @param int lid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteLine(int lid);
	/**
	 *查询;
	 */
	public List<TLine> seletLine(int page,int limit);
	/**
	 *查询数量   amount;
	 */
	public int getSystemLineAmount();
	/**
	 * 添加线路
	 * @param TLine 线路对象
	 * @return 成功返回0失败返回1
	 */
	public List<TLine> selectByLike(String wherecondition,
			int page, int limit);
	
	/**
	 *角色选择
	 *下拉查询;
	 */
	public List<TLine> seletLine();
}
