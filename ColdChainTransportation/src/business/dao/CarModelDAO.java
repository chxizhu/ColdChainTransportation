package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TCar;

public interface CarModelDAO {
	/**
	 *查询;
	 */
	public List<TCar> seletCar(int page,int limit);
	/**
	 * 通过id进行删除车辆
	 * @param int carid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteCar(int carid);
	/**
	 * 添加车辆
	 * @param TCar 用户对象
	 * @return 成功返回0失败返回1
	 */
	public int addCar(TCar user);
	/**
	 * 添加车辆
	 * @param TCar 用户对象
	 * @return 成功返回0失败返回1
	 */
	public List<TCar> selectByLike(String wherecondition,
			int page, int limit);
	/**
	 *查询数量;
	 */
	public int getSystemCarAmount();
}
