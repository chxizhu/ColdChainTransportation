package business.dao;
import model.TAdminUser;
import model.VAdminru;
import java.util.List;

public interface AdminUserModelDAO {
	/**
	 * 添加用户
	 * @param TAdminUser 用户对象
	 * @return 成功返回0失败返回1
	 */
	public int addUsers(TAdminUser user);
	/**
	 * 通过id进行删除管理员角色
	 * @param int userid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleteUsers(String userid);
	/**
	 *查询;
	 */
	public List<VAdminru> seletUsers(int page,int limit);
}
