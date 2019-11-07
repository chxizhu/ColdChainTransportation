package business.dao;
import model.TAdminUser;
import model.VAdminru;
import java.util.List;

public interface AdminUserModelDAO {
	/**
	 * ����û�
	 * @param TAdminUser �û�����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addUsers(TAdminUser user);
	/**
	 * ͨ��id����ɾ������Ա��ɫ
	 * @param int userid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteUsers(String userid);
	/**
	 *��ѯ;
	 */
	public List<VAdminru> seletUsers(int page,int limit);
}
