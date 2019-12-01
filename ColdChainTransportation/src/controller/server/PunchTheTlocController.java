package controller.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCar;
import model.TPunchTheTloc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.CarModelDAO;
import business.dao.PunchTheTlocModelDAO;
import business.impl.CarModelDAOImpl;
import business.impl.PunchTheTlocModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/TPunchTheTloc")
public class PunchTheTlocController {
	/**
	 *
	 * @author add
	 *
	 */
	@RequestMapping(value = "/add")
	public void addJudges(String name, String lng,String lat,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		PunchTheTlocModelDAO adao = new PunchTheTlocModelDAOImpl();
		
		TPunchTheTloc ts = new TPunchTheTloc();
		ts.setLid(1);
		ts.setSitename(name);
		ts.setXcoordinate(lng);
		ts.setYcoordinate(lat);	

		int num = adao.addLine(ts);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (num == 0) {
			td.code = ReturnData.SUCCESS;
			td.msg = "添加成功";
		} else {
			td.code = ReturnData.ERROR;
			td.msg = "添加失败";
		}
		out.write(JSON.toJSONString(td));
		out.flush();
		out.close();
	}
}
