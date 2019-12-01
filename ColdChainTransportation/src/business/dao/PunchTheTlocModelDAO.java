package business.dao;
import model.TPunchTheTloc;

public interface PunchTheTlocModelDAO {
	/**
	 * 添加打卡点
	 * @param TPunchTheTloc 路线打卡点
	 * @return 成功返回0失败返回1
	 */
	public int addLine(TPunchTheTloc tlc);
}
