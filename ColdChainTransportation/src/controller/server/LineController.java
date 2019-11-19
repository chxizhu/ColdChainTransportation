package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TLine;
import model.VAdminru;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.ReturnData;
import business.dao.AdminUserModelDAO;
import business.dao.LineModelDAO;
import business.impl.AdminUserModelDAOImpl;
import business.impl.LineModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/Line")
public class LineController {
	/**
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String taskname, Boolean status,String startpoint, String endpoint,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		LineModelDAO pdao = new LineModelDAOImpl();
		
		TLine ts = new TLine();
		ts.setTaskname(taskname);
		ts.setStatus(status);
		ts.setStartpoint(startpoint);
		ts.setEndpoint(endpoint);


		int num = pdao.addLine(ts);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == 0) {
			td.code = ReturnData.SUCCESS;
			td.msg = "��ӳɹ�";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "���ʧ��";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
	
	/**
	 * 系统登录操作业务控制�?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		LineModelDAO adao = new LineModelDAOImpl();
		List<TLine> List = adao.seletLine(page, limit);
		
		int size = adao.getSystemLineAmount();
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "��ѯ�ɹ�";
			td.data = List;
			td.count = size;
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "��ѯʧ��";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();

	}
	
	/**
	 * ģ����ѯ��·
	 * @author mhselect
	 *
	 */
	@RequestMapping(value = "/mhselect")
	public void getuserrolemanager(String taskname,int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		Expression exp = new Expression();
		
		if (taskname != null && !taskname.equals("")) {
			exp.andLike("taskname", taskname, String.class);
		}
		
		LineModelDAO adao = new LineModelDAOImpl();
		List<TLine> List = adao.selectByLike(exp.toString(),page,limit);
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
	public void deletejudges(int lid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LineModelDAO adao = new LineModelDAOImpl();
		 boolean num= adao.deleteLine(lid); 

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
}
