package controller.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import util.LayuiData;


/*android studio使用*/

@Controller
@RequestMapping(value = "/upload")
public class AndroidCameraController {
	
	@RequestMapping(value = "/uploadpictures")
	@ResponseBody
	public void test(String ext, String file, String data,
			   HttpServletRequest request, HttpServletResponse response,
			   Model model) {
			  response.setCharacterEncoding("utf-8");
			  response.setContentType("application/json");
			  LayuiData laydata = new LayuiData();
			  boolean result = GenerateImage(data);
			  if (result) {
			   laydata.code = LayuiData.SUCCESS;
			   laydata.msg = "图片转换成功";
			  } else {
			   laydata.code = LayuiData.ERRR;
			   laydata.msg = "图片转换失败";
			  }
			  Writer out;
			  try {
			   out = response.getWriter();
			   out.write(JSON.toJSONString(laydata));
			   out.flush();
			   out.close();
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }

	// 图片转化成base64字符串
		 public static String GetImageStr(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		  String imgFile = path;// 待处理的图片
		  InputStream in = null;
		  byte[] data = null;
		  // 读取图片字节数组
		  try {
		   in = new FileInputStream(imgFile);
		   data = new byte[in.available()];
		   in.read(data);
		   in.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  // 对字节数组Base64编码
		  BASE64Encoder encoder = new BASE64Encoder();
		  return encoder.encode(data);// 返回Base64编码过的字节数组字符串
		 }

		 // base64字符串转化成图片
		 public static boolean GenerateImage(String imgStr) {
		  System.out.print("已经收到了把字节码转化为图片的方法");
		  // 对字节数组字符串进行Base64解码并生成图片
		  if (imgStr == null) // 图像数据为空
		   return false;

		  BASE64Decoder decoder = new BASE64Decoder();
		  try {
		   // Base64解码
		   byte[] b = decoder.decodeBuffer(imgStr);
		   for (int i = 0; i < b.length; ++i) {
		    if (b[i] < 0) {// 调整异常数据
		     b[i] += 256;
		    }
		   }
		   SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//
		   // 设置日期格式
		   System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		   // 生成jpeg图片
		   String imagePath = "e:";
		   // System.currentTimeMillis()
/*		   String imgFilePath = "E:\\GITSERVER\\ColdChainTransportationGIT\\ColdChainTransportation\\ColdChainTransportation\\WebRoot\\AndroidImages\\"	*/	
		   String imgFilePath = "../AndroidImages\\"
				   
		     + df.format(new Date()) + ".jpg";// 新生成的图片
		   OutputStream out = new FileOutputStream(imgFilePath);

		   out.write(b);
		   out.flush();
		   out.close();
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
		 }
	
}
