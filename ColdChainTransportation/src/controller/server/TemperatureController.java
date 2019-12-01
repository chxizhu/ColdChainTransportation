package controller.server;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TTemperature;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ReturnData;
import business.dao.CarModelDAO;
import business.dao.TempModelDAO;
import business.impl.CarModelDAOImpl;
import business.impl.TempModelDAOImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/Temperature")
public class TemperatureController {
	/**
	 * Á≥ªÁªüÁôªÂΩïÊìç‰Ωú‰∏öÂä°ÊéßÂà∂Á±?
	 * @author select 
	 *
	 */  
		
		@RequestMapping(value = "/select")
	public void getuserrolemanagerlist(String str, int page, int limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
			
	    TempModelDAO adao = new TempModelDAOImpl();
		List<TTemperature> List = adao.seletTemperature(page, limit);
		
		int size = adao.getTemperatureAmount();
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
		 * @author select 
		 *
		 */  
			
			@RequestMapping(value = "/selectchart")
		public void getuserrolemanage(HttpServletRequest request, HttpServletResponse response,
				Model model) throws IOException {
				
		    TempModelDAO adao = new TempModelDAOImpl();
			List<TTemperature> List = adao.seletTemperature();
			
			int size = adao.getTemperatureAmount();
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
			
		@RequestMapping(value = "/delect")
		public void deletejudges(int tid, HttpServletRequest request,
				HttpServletResponse response, Model model) throws IOException {

			 TempModelDAO adao = new TempModelDAOImpl();
			 boolean num= adao.deleteUsers(tid); 

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
