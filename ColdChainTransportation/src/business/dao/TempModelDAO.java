package business.dao;
import java.util.List;

import model.TTemperature;

public interface TempModelDAO {
	/**
	 * ����¶�
	 * @param TTemperature �¶ȶ���
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addTemperature(TTemperature team);
	/**
	 *��ѯ;
	 */
	public List<TTemperature> seletTemperature(int page,int limit);
	/**
	 *��ѯ;
	 */
	public List<TTemperature> seletTemperature();
	/**
	 *��ѯ����;
	 */
	public int getTemperatureAmount();
	/**
	 * ͨ��id����ɾ���¶�
	 * @param int tid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteUsers(int tid);
}
