package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminUser;
import model.TCar;
import model.TUser;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.CarModelDAO;
import business.dao.UserModelDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.CarModelDAOImpl;
import business.impl.UserModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/User")
public class UserController {
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		UserModelDAO adao = new UserModelDAOImpl();
		List<TUser> List = adao.seletUsers(page, limit);
		
		int size = adao.getSystemsijiAmount();
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
	public void getuserrolemanager(String username, String status,String sex,
			int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		Expression exp = new Expression();
		
		if (username != null && !username.equals("")) {
			exp.andLike("userName", username, String.class);
		}
		
		if (status != null && !status.equals("")) {
			exp.andLike("status", status, String.class);
		}
		
		if (sex != null && !sex.equals("")) {
			exp.andLike("sex", sex, String.class);
		}
		
		UserModelDAO adao = new UserModelDAOImpl();
		List<TUser> List = adao.selectByLike(exp.toString(),page,limit);
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

		UserModelDAO adao = new UserModelDAOImpl();
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
	
	/**
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String userid, String username,String pwd,
			String tel, String sex,Boolean status,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		UserModelDAO adao = new UserModelDAOImpl();
		
		TUser ts = new TUser();
		ts.setUserid(userid);
		ts.setUserName(username);
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
			td.msg = "ÃÌº”≥…π¶";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "ÃÌº” ß∞‹";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
}
