package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TAdminRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ReturnData;
import business.dao.RoleModelDAO;
import business.impl.RoleModelDAOImpl;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/AdminRole")
public class RoleController {
	/**
	 * 系统登录操作业务控制�?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/xlselect")
	public void getpatientlist(
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		RoleModelDAO pdao = new RoleModelDAOImpl();
		List<TAdminRole> List = pdao.seletRolelist();
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
}
