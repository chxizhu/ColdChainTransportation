package controller.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import business.dao.AndroidLoginDAO;
import business.impl.AndroidLoginDAOImpl;


/*android studio π”√*/

@Controller
@RequestMapping(value = "/chauffeur")
public class AndroidLoginController {
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(String userid,String pwd) {
		System.out.println(userid);
		AndroidLoginDAO adao = new AndroidLoginDAOImpl();
		return adao.loginInfo(userid, pwd);
	}

}
