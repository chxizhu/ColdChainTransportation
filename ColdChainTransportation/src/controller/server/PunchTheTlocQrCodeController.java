package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TPunchTheTloc;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.PunchTheTlocModelDAO;
import business.dao.PunchTheTlocQrCodeDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.PunchTheTlocQrCodeDAOImpl;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping(value = "/punchTheTlocQrCode")
public class PunchTheTlocQrCodeController {

	/**
	 * 查询所有打卡点
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		PunchTheTlocQrCodeDAO pdao = new PunchTheTlocQrCodeDAOImpl();
		List<TPunchTheTloc> list = pdao.seletPunchTheTlocQrCode(page, limit);

		int size = pdao.getPunchTheTlocQrCodeAmount();
		
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (list != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "查询成功";
			td.data = list;
			td.count = size;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	
	/**
	 * 按条件查询所有打卡点
	 * @author mhselect
	 *
	 */
	@RequestMapping(value = "/mhselect")
	public void getuserrolemanager(String sitename, String lid,String role,
			int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		Expression exp = new Expression();
		
		if (sitename != null && !sitename.equals("")) {
			exp.andLike("sitename", sitename, String.class);
		}
		if (lid != null && !lid.equals("")) {
			exp.andLike("lid", lid, String.class);
		}
		
		PunchTheTlocQrCodeDAO pdao = new PunchTheTlocQrCodeDAOImpl();
		List<TPunchTheTloc> List = pdao.seletPunchTheTlocQrCodeByLike(exp.toString(),page,limit);
		int size = pdao.seletPunchTheTlocQrCodeByLikeAmount(exp.toString());
		
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "查询成功";
			td.data = List;
			td.count = size;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	
	@RequestMapping(value = "/delect")
	public void deletejudges(int pttid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		PunchTheTlocQrCodeDAO pdao = new PunchTheTlocQrCodeDAOImpl();
		 boolean num= pdao.deletePunchTheTlocQrCode(pttid);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == true) {
			td.code = ReturnData.SUCCESS;
			td.msg = "删除成功";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "删除失败，请重试";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
}
