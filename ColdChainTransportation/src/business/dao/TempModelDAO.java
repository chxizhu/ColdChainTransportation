package business.dao;
import java.util.List;

import model.TTemperature;

public interface TempModelDAO {
	/**
	 * 添加温度
	 * @param TTemperature 温度对象
	 * @return 成功返回0失败返回1
	 */
	public int addTemperature(TTemperature team);
	/**
	 *查询;
	 */
	public List<TTemperature> seletTemperature(int page,int limit);
	/**
	 *查询;
	 */
	public List<TTemperature> seletTemperature();
	/**
	 *查询数量;
	 */
	public int getTemperatureAmount();
	/**
	 * 通过id进行删除温度
	 * @param int tid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteUsers(int tid);
}
