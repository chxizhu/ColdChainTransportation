package business.dao;
import java.util.List;

import model.TAdminRole;
import model.TLine;

public interface LineModelDAO {
	/**
	 * ���·��
	 * @param TLine ·�߶���
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addLine(TLine line);
	/**
	 * ͨ��id����ɾ������Ա��ɫ
	 * @param int lid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deleteLine(int lid);
	/**
	 *��ѯ;
	 */
	public List<TLine> seletLine(int page,int limit);
	/**
	 *��ѯ����   amount;
	 */
	public int getSystemLineAmount();
	/**
	 * �����·
	 * @param TLine ��·����
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public List<TLine> selectByLike(String wherecondition,
			int page, int limit);
	
	/**
	 *��ɫѡ��
	 *������ѯ;
	 */
	public List<TLine> seletLine();
}
