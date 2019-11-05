package business.basic;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	
	//json转bean
	public static <T> T deserialize(String json,Class<T> cls){
		json=json.replace( "[","" ).replace( "]","" );
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try{
            t=mapper.readValue(json, cls);
        }catch (Exception ex){
            return null;
        }
        return t;
    }

	//json数组转bean
    public static <T> List<T> decode(String json,Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        List<T> list;
       try{
           mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
           mapper.configure( DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ;
           mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
           JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, cls);
           list=(List<T>)mapper.readValue(json, javaType);
       }
       catch (Exception ex){
           return null;
       }
        return list;
    }
    
    //bean转json
    public static String beanToJson(Object obj) {
    	ObjectMapper mapper = new ObjectMapper();
    	String json="";
    	try {
			json=mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return json;
    }
    
    //list转json
    public static String listToJson(List list){
    	ObjectMapper mapper = new ObjectMapper();
    	String json="";
    	try {
			json=mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return json;
    }
}
