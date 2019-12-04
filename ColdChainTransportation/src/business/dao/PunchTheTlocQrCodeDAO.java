package business.dao;

import java.util.List;

import model.TPunchTheTloc;
import model.VAdminru;


public interface PunchTheTlocQrCodeDAO {
	
	/**
	 *��ѯ��·�򿨵�;
	 */
	public List<TPunchTheTloc> seletPunchTheTlocQrCode(int page,int limit);
	/**
	 *��ѯ��·�򿨵�����;
	 */
	public int getPunchTheTlocQrCodeAmount();
	
	
	/**
	 *��������ѯ��·�򿨵�;
	 */
	public List<TPunchTheTloc> seletPunchTheTlocQrCodeByLike(String wherecondition,int page, int limit);
	
	/**
	 *��������ѯ��·�򿨵�����;
	 */
	public int seletPunchTheTlocQrCodeByLikeAmount(String wherecondition);
	
	/**
	 * ͨ��id����ɾ����·�򿨵�
	 * @param int userid
	 * @param
	 * @return �ɹ�����0 ʧ�ܷ���1
	 */
	public boolean deletePunchTheTlocQrCode(String pttid);

}
