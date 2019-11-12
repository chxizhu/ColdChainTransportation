package controller.server;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.UserLoginDAO;
import business.impl.UserLoginDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/Admin")
public class LoginController {
	/**
	 * 登录
	 * @author select
	 *
	 */
	@RequestMapping(value = "AdminLogin")
	public void getlogin(String userid,String userpwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		UserLoginDAO ado = new UserLoginDAOImpl();
		VAdminru user = ado.chaxunadmini(userid, userpwd);
		// 閸ョ偘绱秊son鐎涙顑佹稉锟�		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			td.code = ReturnData.SUCCESS;
			td.msg = "成功";
			td.data = null;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "失败";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
}
