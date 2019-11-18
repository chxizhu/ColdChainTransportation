package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminRole;
import model.TAdminUser;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.RoleModelDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.RoleModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/AdminRole")
public class RoleController {
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/xlselect")
	public void getpatientlist(
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		RoleModelDAO pdao = new RoleModelDAOImpl();
		List<TAdminRole> List = pdao.seletRolelist();
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
	
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		RoleModelDAO pdao = new RoleModelDAOImpl();
		List<TAdminRole> List = pdao.seletrole(page, limit);
		
		int size = pdao.getSystemRoleAmount();
		
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
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String name, String description,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		RoleModelDAO pdao = new RoleModelDAOImpl();
		
		TAdminRole ts = new TAdminRole();
		ts.setName(name);
		ts.setDescription(description);
		ts.setParentid(0);
		ts.setDeepth(0);

		int num = pdao.addrole(ts);
		
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
	
	@RequestMapping(value = "/delect")
	public void deletejudges(int id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		 RoleModelDAO pdao = new RoleModelDAOImpl();
		 boolean num= pdao.deleterole(id); 

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
