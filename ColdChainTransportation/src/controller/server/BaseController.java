package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import util.ReturnData;
import com.alibaba.fastjson.JSON;

@Controller
public class BaseController implements HttpSessionListener{

	public static final Map<String, String> USER_SESSIONID = new HashMap<String, String>();//key涓簎serid,value涓簊ession.getid()
	public static final Map<String, String> SESSIONID_USER = new HashMap<String, String>();//key涓簊ession.getid(),value涓簎serid
	static boolean loginstate = false;
	protected PrintWriter out;
	protected ReturnData dt=null;
	protected HttpSession session;

	/**
	 * 鍒濆璋冪敤锛堝鐞嗗櫒鏂规硶鎵ц涔嬪墠鎵ц锛�
	 * @param response
	 * @param request
	 */
	@ModelAttribute
	public void init(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		dt = new ReturnData();
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("XDomainRequestAllowed","1");
		session = request.getSession();
        System.out.println("************"+session.getId());
	}

	/**
	 * 鍏抽棴out锛圥rintWriter锛�
	 */
	public void closeout(){
		out.write(JSON.toJSONString(dt));
		out.flush();
		out.close();
	}

	/*鐧诲綍*/
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		String sessionId = se.getSession().getId();
		System.out.println("*************鍚姩");
	}

	/*鐧诲綍*/
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("*************閿�瘉");
		String sessionId = se.getSession().getId();
		//鏍规嵁sessionid 鑾峰彇 userid
		String userid = SESSIONID_USER.get(sessionId);
		//鏍规嵁userid绉婚櫎USER_SESSIONID涓殑淇℃伅
		USER_SESSIONID.remove(userid);
		//鏍规嵁sessionid绉婚櫎SESSIONID_USER涓殑淇℃伅
		SESSIONID_USER.remove(sessionId);
	}
}
