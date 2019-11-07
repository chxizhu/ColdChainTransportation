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
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableDataJSON td = new LayuiTableDataJSON();
		if(list!=null){
			td.code = LayuiTableDataJSON.FLAG_SUCC;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
		}else{
			td.code = LayuiTableDataJSON.FLAG_FAIL;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		//{"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();

	}
	/**
	 * 实现根据session中保存的登录用户的roleid返回所有菜单列表的请求  
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
		
		//回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiTableDataJSON td = new LayuiTableDataJSON();
		if(list!=null){
			td.code = LayuiTableDataJSON.FLAG_SUCC;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
			System.out.println(JSON.toJSON(list));
		}else{
			td.code = LayuiTableDataJSON.FLAG_FAIL;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		//{"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}
}