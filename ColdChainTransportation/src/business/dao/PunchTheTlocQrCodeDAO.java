package business.dao;

import java.util.List;

import model.TPunchTheTloc;
import model.VAdminru;


public interface PunchTheTlocQrCodeDAO {
	
	/**
	 *查询线路打卡点;
	 */
	public List<TPunchTheTloc> seletPunchTheTlocQrCode(int page,int limit);
	/**
	 *查询线路打卡点数量;
	 */
	public int getPunchTheTlocQrCodeAmount();
	
	
	/**
	 *按条件查询线路打卡点;
	 */
	public List<TPunchTheTloc> seletPunchTheTlocQrCodeByLike(String wherecondition,int page, int limit);
	
	/**
	 *按条件查询线路打卡点数量;
	 */
	public int seletPunchTheTlocQrCodeByLikeAmount(String wherecondition);
	
	/**
	 * 通过id进行删除线路打卡点
	 * @param int userid
	 * @param
	 * @return 成功返回0 失败返回1
	 */
	public boolean deletePunchTheTlocQrCode(String pttid);

}
