package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminUser;
import model.TUser;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.UserModelDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.UserModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/User")
public class UserController {
	/**
	 * 系统登录操作业务控制�?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		UserModelDAO adao = new UserModelDAOImpl();
		List<TUser> List = adao.seletUsers(page, limit);
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "��ѯ�ɹ�";
			td.data = List;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "��ѯʧ��";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	@RequestMapping(value = "/delect")
	public void deletejudges(String userid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		UserModelDAO adao = new UserModelDAOImpl();
		 boolean num= adao.deleteUsers(userid); 

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == true) {
			td.code = ReturnData.SUCCESS;
			td.msg = "ɾ���ɹ�";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "ɾ��ʧ�ܣ�������";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
	/**
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String userid, String userName,String pwd, int adminrole,
			String tel, String sex,Boolean status,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		UserModelDAO adao = new UserModelDAOImpl();
		
		TUser ts = new TUser();
		ts.setUserid(userid);
		ts.setUserName(userName);
		ts.setSex(sex);
		ts.setPwd(pwd);
		ts.setTel(tel);
		ts.setStatus(status);
		
		int num = adao.addUsers(ts);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == 0) {
			td.code = ReturnData.SUCCESS;
			td.msg = "���ӳɹ�";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "����ʧ��";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
}