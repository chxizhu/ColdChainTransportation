package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiTableDataJSON;
import util.ResponseJSON;
import business.dao.SystemModelDAO;
import business.impl.SystemModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value="/systemmodel")
public class SystemModelController {
	
	@RequestMapping(value="/getsystemmodellist") 
	public void getGetSystemModelList(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{

		
		//System.out.println(wherecondition);
		SystemModelDAO smdao = new SystemModelDAOImpl();
		List list = smdao.getTSystemModelList();
		//�ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableDataJSON td = new LayuiTableDataJSON();
		if(list!=null){
			td.code = LayuiTableDataJSON.FLAG_SUCC;
			td.count = list.size();
			td.msg = "��ѯ�ɹ��������" + td.count + "����¼";
			td.data = list;
		}else{
			td.code = LayuiTableDataJSON.FLAG_FAIL;
			td.msg = "��ѯʧ��";
		}
		out.write(JSON.toJSONString(td));
		//{"code":10001,"msg":"ִ�гɹ�","result1":"......."}
		out.flush();
		out.close();

	}
	/**
	 * ʵ�ָ���session�б���ĵ�¼�û���roleid�������в˵��б������  
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/getsystemmodelbyrole")
	public void getRoleSystemModelList(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException{
		 
		HttpSession session = request.getSession();
		TAdminUser loginUser = (TAdminUser)session.getAttribute("loginUser");
		
		SystemModelDAO smdao = new SystemModelDAOImpl();
		List list = smdao.getSystemModelByRole(loginUser.getRoleid());
		ResponseJSON rj = new ResponseJSON();
		
		//�ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableDataJSON td = new LayuiTableDataJSON();
		if(list!=null){
			td.code = LayuiTableDataJSON.FLAG_SUCC;
			td.count = list.size();
			td.msg = "��ѯ�ɹ��������" + td.count + "����¼";
			td.data = list;
			System.out.println(JSON.toJSON(list));
		}else{
			td.code = LayuiTableDataJSON.FLAG_FAIL;
			td.msg = "��ѯʧ��";
		}
		out.write(JSON.toJSONString(td));
		//{"code":10001,"msg":"ִ�гɹ�","result1":"......."}
		out.flush();
		out.close();
	}
}