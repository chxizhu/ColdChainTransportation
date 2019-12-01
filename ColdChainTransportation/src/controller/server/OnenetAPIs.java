package controller.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import business.dao.TempModelDAO;
import business.impl.TempModelDAOImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TTemperature;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Expression;


/**
 * 鍚姩鏈嶅姟鍣ㄤ互鍚庤皟鐢ㄦ柟娉�
 *
 * @author lixu
 *
 *
 */
@Controller
@RequestMapping(value="Onenet")
public class OnenetAPIs extends BaseController {

    private static String date;
    private static String temp;

    @RequestMapping(value="/gettemp")//鏄犲皠璺緞,鎷︽埅post璇锋眰
    public void gettemplist(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model) throws IOException{
        Expression exp = new Expression();
        gettemp();
        addtemp();
        TempModelDAO adao = new TempModelDAOImpl();
        List carlist = adao.seletTemperature();
        int size = adao.getTemperatureAmount();
        if (carlist!=null){
            dt.code = dt.SUCCESS;
            dt.msg = "鏌ヨ鎴愬姛";
            dt.count = size;
            dt.data = carlist;
        }else {
            dt.code = dt.ERROR;
            dt.msg = "鏌ヨ澶辫触 ";
        }
        closeout();
    }
//    @RequestMapping(value="/GIT")
//    public void contextInitialized() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Boolean result = false;
//        int count = 0;
//        while(!result) {
//            try {
//                Thread.sleep(1 * 10000); //璁剧疆闂撮殧鐨勬椂闂�
//                count ++ ;
//                gettemp();//GET鑾峰彇鏂规硶
//                addtemp();//娣诲姞鏂规硶
//                System.out.println(date);
//                System.out.println(temp);
//                if (count == 20) {//寰幆娆℃暟
//                    result = true;
//                    break ;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        // System.out.println(OneNetAPI.getDataStreams("10000", "apikey" , "userCount"));
//    }
    /**
     * 娣诲姞鏁版嵁搴撴柟娉曡皟鐢�
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
     * GIT鑾峰彇鏁版嵁鏂规硶璋冪敤
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
            // 鎵撳紑鍜孶RL涔嬮棿鐨勮繛鎺�
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 璁剧疆閫氱敤鐨勮姹傚睘鎬�
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("api-key", apiKey);
            // 寤虹珛瀹為檯鐨勮繛鎺�
            connection.connect();
            // 瀹氫箟 BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
            InputStream is = connection.getInputStream();
            //鏋勯�涓�釜瀛楃娴佺紦瀛�
            br = new BufferedReader(new InputStreamReader(is));
            str = br.readLine();
            str = new String(str.getBytes(), "UTF-8");
            json = JSONObject.parseObject(str);
            JSONArray array = json.getJSONArray("data");
            JSONObject o = array.getJSONObject(1);
            date = (String) o.get("update_at");
            temp = (String) o.get("current_value");
        } catch (Exception e) {
            System.out.println("鍙戦�GET璇锋眰鍑虹幇寮傚父锛�");
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
//     * 鑾峰彇鏁版嵁娴�
//     *
//     * @param deviceId锛氳澶嘔D
//     * @param apiKey
//     * @param datastreamId锛氭暟鎹祦ID
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
//            // 鎵撳紑鍜孶RL涔嬮棿鐨勮繛鎺�
//            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
//            // 璁剧疆閫氱敤鐨勮姹傚睘鎬�
//            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("api-key", apiKey);
//            // 寤虹珛瀹為檯鐨勮繛鎺�
//            connection.connect();
//            // 瀹氫箟 BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
//            InputStream is = connection.getInputStream();
//            //鏋勯�涓�釜瀛楃娴佺紦瀛�
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
//            System.out.println("鍙戦�GET璇锋眰鍑虹幇寮傚父锛�");
//            e.printStackTrace();
//        }
//        // 浣跨敤finally鍧楁潵鍏抽棴杈撳叆娴�
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
//            td.msg = "鏌ヨ鎴愬姛";
//            td.data = json;
//        }else{
//            System.out.println(json);
//            td.code = LayuiTableData.FLAG_FAIL;
//            td.msg = "鏌ヨ澶辫触";
//        }
//        out.write(JSON.toJSONString(td));
//        out.flush();
//        out.close();
//    }




}
