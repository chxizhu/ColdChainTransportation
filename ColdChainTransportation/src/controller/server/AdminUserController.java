package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminUser;
import model.TCar;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.CarModelDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.CarModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/AdminUser")
public class AdminUserController {

	/**
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String userid, String username,String userpwd, int adminrole,
			String phone, String sex,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		AdminUserModelDAO pdao = new AdminUserModelDAOImpl();
		
		TAdminUser ts = new TAdminUser();
		ts.setUserid(userid);
		ts.setUsername(username);
		ts.setUserpwd(userpwd);
		ts.setPhone(phone);
		ts.setRoleid(adminrole);
		ts.setSex(sex);

		int num = pdao.addUsers(ts);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == 0) {
			td.code = ReturnData.SUCCESS;
			td.msg = "ÃÌº”≥…π¶";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "ÃÌº” ß∞‹";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
	
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		AdminUserModelDAO adao = new AdminUserModelDAOImpl();
		List<VAdminru> List = adao.seletUsers(page, limit);
		
		int size = adao.getSystemUserAmount();
		// ªÿ¥´json◊÷∑˚¥Æ
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "≤È—Ø≥…π¶";
			td.data = List;
			td.count = size;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "≤È—Ø ß∞‹";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author mhselect
	 *
	 */
	@RequestMapping(value = "/mhselect")
	public void getuserrolemanager(String name, String sex,String role,
			int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		Expression exp = new Expression();
		
		if (name != null && !name.equals("")) {
			exp.andLike("username", name, String.class);
		}
		if (sex != null && !sex.equals("")) {
			exp.andLike("sex", sex, String.class);
		}
		if (role != null && !role.equals("")) {
			exp.andLike("name", role, String.class);
		}
		
		AdminUserModelDAO adao = new AdminUserModelDAOImpl();
		List<VAdminru> List = adao.selectByLike(exp.toString(),page,limit);
		// ªÿ¥´json◊÷∑˚¥Æ
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "≤È—Ø≥…π¶";
			td.data = List;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "≤È—Ø ß∞‹";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	
	@RequestMapping(value = "/delect")
	public void deletejudges(String userid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		AdminUserModelDAO adao = new AdminUserModelDAOImpl();
		 boolean num= adao.deleteUsers(userid); 

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == true) {
			td.code = ReturnData.SUCCESS;
			td.msg = "…æ≥˝≥…π¶";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "…æ≥˝ ß∞‹£¨«Î÷ÿ ‘";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
}
