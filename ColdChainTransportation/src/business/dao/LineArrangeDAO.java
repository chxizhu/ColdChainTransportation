package business.dao;

import java.util.List;

import model.TLineArrange;
import model.VAdminru;

public interface LineArrangeDAO {
	/**
	 * 添加线路安排
	 * @param TLineArrange 线路安排对象
	 * @return 成功返回0失败返回1
	 */
	public int addLineArrange(TLineArrange line);
	/**
	 * 通过id进行删除线路安排
	 * @param int laid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteLineArrange(int laid);
	/**
	 *查询;
	 */
	public List<TLineArrange> seletLineArrange(int page,int limit);
	/**
	 *查询数量;
	 */
	public int getSystemLineArrangeAmount();
	/**
	 * 模糊查询
	 * @param TLineArrange 线路对象
	 * @return 成功返回0失败返回1
	 */
	public List<TLineArrange> selectByLike(String wherecondition,
			int page, int limit);
}
