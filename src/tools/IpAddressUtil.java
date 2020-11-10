package tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressUtil {
	private static String os = null;
	private static Process pro = null;
	private static BufferedReader br = null;
	private static List<String> ip = null;
    
	public static List<String> getlocalIP() throws IOException {
		os = System.getProperties().getProperty("os.name");    //�õ�����ϵͳ xp Ϊ"Windows XP"  �����ĵ�¥���Լ�ȥ����
		pro = Runtime.getRuntime().exec("ipconfig");
	    br = new BufferedReader(new InputStreamReader(pro.getInputStream(),"GBK"));
	    String temp;
	    ip = new ArrayList<>();
	    while((temp = br.readLine()) != null){
	    	String dg =  os.equals("Windows 7") ? "Ĭ������" : "Default Gateway"; //����ֻ�ж���win7 
		        if(temp.indexOf(dg) != -1){
		            Matcher mc = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}").matcher(temp);
		            
		            if(mc.find()) {
		            	ip.add(mc.group());
		            	System.out.println(mc.group());
		            }
		        }
	    	
	        String sm=  os.equals("Windows 7") ? "��������" : "Subnet Mask"; //����ֻ�ж���win7
	        if(temp.indexOf(sm) != -1){
	            Matcher mc = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}").matcher(temp);
	            if(mc.find()) {
	            	ip.add(mc.group());
	            	System.out.println(mc.group());
	            }
	        }
	       
	    }
	    return ip;
	}
	
	public static boolean isIP(String ipStr) {
		if(ipStr.length() < 7 || ipStr.length() > 15 || "".equals(ipStr))  
        {  
            return false;  
        }
		// 定义正则表达式 
        String regex = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"; 
        return ipStr.matches(regex);
	}
}
