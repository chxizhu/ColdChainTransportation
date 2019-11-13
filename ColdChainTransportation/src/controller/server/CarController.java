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
@RequestMapping(value = "/Car")
public class CarController {
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select
	 *
	 */
	@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		CarModelDAO adao = new CarModelDAOImpl();
		List<TCar> List = adao.seletCar(page, limit);
		// ªÿ¥´json◊÷∑˚¥Æ
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ReturnData td = new ReturnData();
		if (List != null) {
			td.code = ReturnData.SUCCESS;
			td.msg = "≤È—Ø≥…π¶";
			td.data = List;
			td.count = 5;
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
	public void getuserrolemanager(String carnum, String status,String fanstatuds,
			int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		Expression exp = new Expression();
		
		if (carnum != null && !carnum.equals("")) {
			exp.andLike("carnum", carnum, String.class);
		}
		System.out.println(carnum);
		if (status != null && !status.equals("")) {
			exp.andLike("status", status, String.class);
		}
		System.out.println(status);
		if (fanstatuds != null && !fanstatuds.equals("")) {
			exp.andLike("fanstatuds", fanstatuds, String.class);
		}
		
		CarModelDAO adao = new CarModelDAOImpl();
		List<TCar> List = adao.selectByLike(exp.toString(),page,limit);
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
	public void deletejudges(int carid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		CarModelDAO adao = new CarModelDAOImpl();
		 boolean num= adao.deleteCar(carid); 

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
	public void addJudges(String carnum, Boolean fanstatuds,Boolean status,
			String remarks,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		
		CarModelDAO adao = new CarModelDAOImpl();
		
		TCar ts = new TCar();
		ts.setCarnum(carnum);
		ts.setFanstatuds(fanstatuds);
		ts.setRemarks(remarks);
		ts.setStatus(status);

		int num = adao.addCar(ts);
		
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
