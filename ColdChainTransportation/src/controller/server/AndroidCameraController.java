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


/*android studioʹ��*/

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
			   laydata.msg = "ͼƬת���ɹ�";
			  } else {
			   laydata.code = LayuiData.ERRR;
			   laydata.msg = "ͼƬת��ʧ��";
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

	// ͼƬת����base64�ַ���
		 public static String GetImageStr(String path) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
		  String imgFile = path;// �������ͼƬ
		  InputStream in = null;
		  byte[] data = null;
		  // ��ȡͼƬ�ֽ�����
		  try {
		   in = new FileInputStream(imgFile);
		   data = new byte[in.available()];
		   in.read(data);
		   in.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  // ���ֽ�����Base64����
		  BASE64Encoder encoder = new BASE64Encoder();
		  return encoder.encode(data);// ����Base64��������ֽ������ַ���
		 }

		 // base64�ַ���ת����ͼƬ
		 public static boolean GenerateImage(String imgStr) {
		  System.out.print("�Ѿ��յ��˰��ֽ���ת��ΪͼƬ�ķ���");
		  // ���ֽ������ַ�������Base64���벢����ͼƬ
		  if (imgStr == null) // ͼ������Ϊ��
		   return false;

		  BASE64Decoder decoder = new BASE64Decoder();
		  try {
		   // Base64����
		   byte[] b = decoder.decodeBuffer(imgStr);
		   for (int i = 0; i < b.length; ++i) {
		    if (b[i] < 0) {// �����쳣����
		     b[i] += 256;
		    }
		   }
		   SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//
		   // �������ڸ�ʽ
		   System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		   // ����jpegͼƬ
		   String imagePath = "e:";
		   // System.currentTimeMillis()
/*		   String imgFilePath = "E:\\GITSERVER\\ColdChainTransportationGIT\\ColdChainTransportation\\ColdChainTransportation\\WebRoot\\AndroidImages\\"	*/	
		   String imgFilePath = "../AndroidImages\\"
				   
		     + df.format(new Date()) + ".jpg";// �����ɵ�ͼƬ
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
