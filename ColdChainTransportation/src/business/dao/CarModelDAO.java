package business.dao;

import java.util.List;

import model.TAdminUser;
import model.TCar;

public interface CarModelDAO {
	/**
	 *��ѯ;
	 */
	public List<TCar> seletCar(int page,int limit);
	/**
	 * ͨ��id����ɾ������
	 * @param int carid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteCar(int carid);
	/**
	 * ��ӳ���
	 * @param TCar �û�����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addCar(TCar user);
	/**
	 * ��ӳ���
	 * @param TCar �û�����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public List<TCar> selectByLike(String wherecondition,
			int page, int limit);
	/**
	 *��ѯ����;
	 */
	public int getSystemCarAmount();
}
