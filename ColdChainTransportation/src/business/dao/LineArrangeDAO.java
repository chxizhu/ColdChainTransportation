package business.dao;

import java.util.List;

import model.TLineArrange;
import model.VAdminru;

public interface LineArrangeDAO {
	/**
	 * �����·����
	 * @param TLineArrange ��·���Ŷ���
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addLineArrange(TLineArrange line);
	/**
	 * ͨ��id����ɾ����·����
	 * @param int laid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteLineArrange(int laid);
	/**
	 *��ѯ;
	 */
	public List<TLineArrange> seletLineArrange(int page,int limit);
	/**
	 *��ѯ����;
	 */
	public int getSystemLineArrangeAmount();
	/**
	 * ģ����ѯ
	 * @param TLineArrange ��·����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public List<TLineArrange> selectByLike(String wherecondition,
			int page, int limit);
}
