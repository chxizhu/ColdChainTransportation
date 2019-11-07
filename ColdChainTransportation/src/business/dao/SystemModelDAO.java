package business.dao;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

public interface SystemModelDAO {
	/**
	 * ��ȡ��վ���еĲ˵����б�
	 * @return
	 */
	public List<TSystemModel> getTSystemModelList();	
	/**
	 * ���ս�ɫѡ���ȡ��Ӧ�Ĳ˵����б�
	 * @param roleid
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSystemModel> getSystemModelByRole(int roleid); 
}
