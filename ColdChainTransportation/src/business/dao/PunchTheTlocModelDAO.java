package business.dao;
import model.TPunchTheTloc;

public interface PunchTheTlocModelDAO {
	/**
	 * ��Ӵ򿨵�
	 * @param TPunchTheTloc ·�ߴ򿨵�
	 * @return �ɹ�����0ʧ�ܷ���1
	 */
	public int addLine(TPunchTheTloc tlc);
}
