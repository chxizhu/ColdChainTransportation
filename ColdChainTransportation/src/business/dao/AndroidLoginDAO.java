package business.dao;

/*android studioʹ��*/

public interface AndroidLoginDAO {
	
	/**
	 * �û���¼ҵ�񷽷�
	 * @param userid �û���¼��
	 * @param password ��¼����
	 * @return VStudent ��ǰ��¼���û�����
	 */
	public boolean isUserLogin(String userid,String pwd);
	
	/**
	  * ���ص�¼��Ϣ
	  * @param userid
	  * @param pwd
	  * @return
	  */	
	 public String loginInfo(String userid,String pwd);

}
