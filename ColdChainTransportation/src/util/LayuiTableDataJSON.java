package util;

/**
 * һ�����ڴ�������Ϣ��json���Ͷ���
 * @author zhang jin sheng
 *
 */
public class LayuiTableDataJSON {

	public static final int FLAG_SUCC = 0;  //����ɹ�
    public static final int FLAG_FAIL = 1;  //����ʧ��
    
    public int code; //������״̬��
    public String msg;  //������������Ϣ
    public int count; //�������ݵ�����
    public Object data;
    
    public LayuiTableDataJSON(){
    	this.code = FLAG_FAIL;
    	this.msg = null;
    	this.count = 0;
    	this.data = null;
    }
}
