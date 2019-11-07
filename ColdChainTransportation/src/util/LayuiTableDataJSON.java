package util;

/**
 * 一个用于处理返回信息的json类型对象
 * @author zhang jin sheng
 *
 */
public class LayuiTableDataJSON {

	public static final int FLAG_SUCC = 0;  //处理成功
    public static final int FLAG_FAIL = 1;  //处理失败
    
    public int code; //处理结果状态码
    public String msg;  //处理结果返回消息
    public int count; //代表数据的数量
    public Object data;
    
    public LayuiTableDataJSON(){
    	this.code = FLAG_FAIL;
    	this.msg = null;
    	this.count = 0;
    	this.data = null;
    }
}
