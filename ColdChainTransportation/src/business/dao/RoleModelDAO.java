package business.dao;
import java.util.List;

import model.TAdminRole;
import model.TAdminUser;
import model.VAdminru;

public interface RoleModelDAO {
	/**
	 *��ɫѡ��
	 *������ѯ;
	 */
	public List<TAdminRole> seletRolelist();
	/**
	 * ��ӽ�ɫ
	 * @param TAdminRole 
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addrole(TAdminRole role);
	/**
	 * ͨ��id����ɾ����ɫ
	 * @param int roleid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleterole(int id);
	/**
	 *��ѯ;
	 */
	public List<TAdminRole> seletrole(int page,int limit);
	/**
	 *��ѯ����;
	 */
	public int getSystemRoleAmount();
}
