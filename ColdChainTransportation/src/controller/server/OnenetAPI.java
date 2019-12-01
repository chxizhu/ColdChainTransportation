package controller.server;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import business.dao.TempModelDAO;
import business.impl.TempModelDAOImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;																																								
import model.TTemperature;


/**
 * 启动服务器以后调用方法
 *
 * @author lixu
 *
 *
 */
public class OnenetAPI implements ServletContextListener {

    private static String date;
    private static String temp;
    /**
     * 启动服务器以后不断调用
     *
     * @author lixu
     *
     *
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }
    /**
     * 间隔循环调用
     *
     * @author lixu
     *
     *
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Boolean result = false;
        int count = 0;
        while(!result) {
            try {
                Thread.sleep(1 * 10000); //设置间隔的时间
                count ++ ;
                gettemp();//GET获取方法
                addtemp();//添加方法
                System.out.println(date);
                System.out.println(temp);
                if (count == 100) {//循环次数
                    result = true;
                    break ;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
        // System.out.println(OneNetAPI.getDataStreams("10000", "apikey" , "userCount"));
    }
    /**
     * 添加数据库方法调用
     *
     * @author lixu
     *
     *
     */
    public static void addtemp() {
    	TempModelDAO tmdao = new TempModelDAOImpl();
    	TTemperature tm = new TTemperature();
    	tm.setRealtimet(temp);
    	tm.setNowtime(date);
        tm.setSort(1);
        tmdao.addTemperature(tm);
    }
    /**
     * GIT获取数据方法调用
     *
     * @author lixu
     *
     *
     */
    public static void gettemp() {
        BufferedReader br = null;
        JSONObject json = null;
        String str = "";
        String deviceId = "572342878";
        String apiKey = "xv3gNLM=o4CVWrn4eTLMnb7831k=";
        String datastreamId = "temp";
        try {
            String url = "http://api.heclouds.com/devices/" + deviceId
                    + "/datastreams?datastream_id=" + datastreamId;
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("api-key", apiKey);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream is = connection.getInputStream();
            //构造一个字符流缓存
            br = new BufferedReader(new InputStreamReader(is));
            str = br.readLine();
            str = new String(str.getBytes(), "UTF-8");
            json = JSONObject.parseObject(str);
            JSONArray array = json.getJSONArray("data");
            JSONObject o = array.getJSONObject(1);
            date = (String) o.get("update_at");
            temp = (String) o.get("current_value");
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！ ");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                System.out.println("IO close error !");
            }
        }
    }
//    /**
//     * 获取数据流
//     *
//     * @param deviceId：设备ID
//     * @param apiKey
//     * @param datastreamId：数据流ID
//     * @return
//     */
//    @RequestMapping(value="getDataStreams")
//    public  void getDataStreams(String deviceId, String apiKey,String datastreamId,HttpServletRequest request,
//                                HttpServletResponse response,
//                                Model model)throws IOException{
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        LayuiTableData td = new LayuiTableData();
//        BufferedReader br =null;
//        JSONObject json = null;
//        String str = "";
//        deviceId = "567351233";
//        apiKey = "R0sktW8=iDGbezEIxe8rlM9JZ1g=";
//        datastreamId ="temp";
//        try {
//            String url = "http://api.heclouds.com/devices/" + deviceId
//                    + "/datastreams?datastream_id=" + datastreamId ;
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("api-key", apiKey);
//            // 建立实际的连接
//            connection.connect();
//            // 定义 BufferedReader输入流来读取URL的响应
//            InputStream is = connection.getInputStream();
//            //构造一个字符流缓存
//            br = new BufferedReader(new InputStreamReader(is));
//            str = br.readLine();
//            str = new String(str.getBytes(),"UTF-8");
//            json = JSONObject.parseObject(str);
//            JSONArray array = json.getJSONArray("data");
//            for(int i = 0;i <= array.size();i++) {
//                JSONObject o = array.getJSONObject(i);
//                String date = (String) o.get("update_at");
//                Integer temp = (Integer) o.get("current_value");
//                System.out.println(date);
//            }
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！ ");
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输入流
//        finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (Exception e2) {
//                System.out.println("IO close error !");
//            }
//        }
//        if (json!=null) {
//            td.code = LayuiTableData.FLAG_SUCC;
//            td.msg = "查询成功";
//            td.data = json;
//        }else{
//            System.out.println(json);
//            td.code = LayuiTableData.FLAG_FAIL;
//            td.msg = "查询失败";
//        }
//        out.write(JSON.toJSONString(td));
//        out.flush();
//        out.close();
//    }




}
