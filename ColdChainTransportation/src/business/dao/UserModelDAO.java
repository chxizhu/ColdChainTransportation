package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TUser;

public interface UserModelDAO {
	/**
	 *��ѯ;
	 */
	public List<TUser> seletUsers(int page,int limit);
	/**
	 * ͨ��id����ɾ������Ա��ɫ
	 * @param int userid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteUsers(String userid);
	/**
	 * ���˾��
	 * @param TUser �û�����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addUsers(TUser user);
	/**
	 *��ѯ����;
	 */
	public int getSystemsijiAmount();
}
