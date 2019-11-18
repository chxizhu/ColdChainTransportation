package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TUser;

public interface UserModelDAO {
	/**
	 *查询;
	 */
	public List<TUser> seletUsers(int page,int limit);
	/**
	 * 通过id进行删除管理员角色
	 * @param int userid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteUsers(String userid);
	/**
	 * 添加司机
	 * @param TUser 用户对象
	 * @return 成功返回0失败返回1
	 */
	public int addUsers(TUser user);
	/**
	 *查询数量;
	 */
	public int getSystemsijiAmount();
}
