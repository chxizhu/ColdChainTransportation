package business.dao;
import java.util.List;
import model.TAdminRole;

public interface RoleModelDAO {
	/**
	 *角色选择
	 *下拉查询;
	 */
	public List<TAdminRole> seletRolelist();
}
