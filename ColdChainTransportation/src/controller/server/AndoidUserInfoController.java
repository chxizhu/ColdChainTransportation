package controller.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import business.dao.AndroidLoginDAO;
import business.impl.AndroidLoginDAOImpl;



/*android studio π”√*/

@Controller
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8")
public class AndoidUserInfoController {
	
	AndroidLoginDAOImpl adao = new AndroidLoginDAOImpl();
	

	@RequestMapping(value="/getuserinfo")
	@ResponseBody
	public String getuserinfo(String userid) {
		return adao.getUserinfoToJson(userid);
	}

}
