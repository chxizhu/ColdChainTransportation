package business.dao;
import java.util.List;

import model.TAdminRole;
import model.TAdminUser;
import model.VAdminru;

public interface RoleModelDAO {
	/**
	 *角色选择
	 *下拉查询;
	 */
	public List<TAdminRole> seletRolelist();
	/**
	 * 添加角色
	 * @param TAdminRole 
	 * @return 成功返回0失败返回1
	 */
	public int addrole(TAdminRole role);
	/**
	 * 通过id进行删除角色
	 * @param int roleid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deleterole(int id);
	/**
	 *查询;
	 */
	public List<TAdminRole> seletrole(int page,int limit);
	/**
	 *查询数量;
	 */
	public int getSystemRoleAmount();
}
