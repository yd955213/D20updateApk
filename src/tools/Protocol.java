package tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import myGson.das.DeviceInfo;
import myGson.das.UpdateStatus;
import views.MainIntfaceView;

public class Protocol {
	private final String COMMAND_HEADER = "Send";
	public String commandWord = "";
	/**
	 * validData的长度
	 */
	public String commandLength = "";
	public String validData = "";
	private String sumCheck = "";
//	private DeviceInfo deviceInfo = null;
	public static Map<String, DeviceInfo> deviceInfoMap = new HashMap<String, DeviceInfo>();
	Gson gson = new Gson();
	public void splitCommand(String data, String ip) {
//		System.out.println(ip);
		commandWord = data.substring(4, 6);
		commandLength = data.substring(6, 12);
//		System.out.println(commandLength);
		validData = data.substring(12, 12 + Integer.parseInt(commandLength, 16));
		sumCheck = data.substring(data.length() - 4);
//		System.out.println(validData);
		switch (commandWord) {
		case "00":
			if (validData.length() > 0) {
//				deviceInfo = new DeviceInfo();
				try {
					DeviceInfo deviceInfo = gson.fromJson(validData, new TypeToken<DeviceInfo>() {}.getType());
//					System.out.println("devAddress=" + deviceInfo.getDevAddress1());
//					System.out.println("devMacAddr=" + deviceInfo.DevMacAddr1);
//					System.out.println("devName=" + deviceInfo.DevName1);
//					System.out.println("devVer=" + deviceInfo.DevVer1);
//					System.out.println("udpPort=" + deviceInfo.UdpPort1);
					deviceInfo.DevAddress1 = ip;
					deviceInfoMap.put(deviceInfo.DevMacAddr1, deviceInfo);
					updateTable(MainIntfaceView.devTable);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}	
			break;
		case "01":
			UpdateStatus updateStatus = gson.fromJson(validData, new TypeToken<UpdateStatus>() {}.getType());
			
			if (updateStatus.Code.equals("0")) {
				setTabelValue(MainIntfaceView.devTable, ip, "下载成功");
			}else if (updateStatus.Code.equals("1")) {
				setTabelValue(MainIntfaceView.devTable, ip, "下载失败");
			}else if (updateStatus.Code.equals("2")) {
				setTabelValue(MainIntfaceView.devTable, ip, "正在下载");
			}else {

				setTabelValue(MainIntfaceView.devTable, ip, "未定义返回码（"+updateStatus.Code+"）");
			}
			
			break;
		default:
			break;
		}
		
	}
	
	private void updateTable(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Vector<Object> vt = null;
		Iterator<Entry<String, DeviceInfo>> iterator = deviceInfoMap.entrySet().iterator();
		Entry<String, DeviceInfo> entry = null;
		while (iterator.hasNext()) {
			vt = new Vector<>();
			vt.add(tableModel.getRowCount()+1);
			vt.add(true);
			
			entry = iterator.next();
			vt.add(entry.getValue().DevMacAddr1);
			vt.add(entry.getValue().DevAddress1);
			vt.add(entry.getValue().UdpPort1);
			vt.add(entry.getValue().DevName1);
			vt.add(entry.getValue().DevVer1);
			tableModel.addRow(vt);
		}
	}
	
	public String getSendDate() {
		String data = "";
		if(Integer.parseInt(commandLength,16) == 0) {
			data = COMMAND_HEADER+commandWord+commandLength;
		}else {
			data = COMMAND_HEADER+commandWord+MyString.getFullString(commandLength, "0", 6) + validData;
		}
		data += getSumCheckAscii(data);

//		System.out.println(data);
		return data;
	}
	
	public String getSumCheck(String data) {
		MyString myString = new MyString();
		String[] hex = myString.splitString(data, 2);
		int sum = 0;
		for(int i = 0 ; i < hex.length ; i++) {
			sum +=Integer.parseInt(hex[i],16); 
		}
		data = myString.complementStrLength(Integer.toHexString(sum),4);
		return data;
	}
	public String getSumCheckAscii(String data) {
		char[] chars = data.toCharArray();
		int sum = 0 ;

		for (int i = 0; i < chars.length; i++) {
//			System.out.println(chars[i] + "=  " + (int)chars[i]);
			sum += (int)chars[i];
		}
//		System.out.println(sum);
		String sumCheck = Integer.toHexString(sum);
		if (sumCheck.length() < 4) {
			sumCheck = MyString.getFullString(sumCheck, "0", 4);
		}else {
			sumCheck.substring(sumCheck.length()-4, sumCheck.length());
		}
		return sumCheck;
	}
	
	private void setTabelValue(JTable table, String rowValue, String wantValue) {
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Vector<Vector<Object>> dataVector = tableModel.getDataVector();
		for (int i = 0; i < dataVector.size(); i++) {

			System.out.println(dataVector.get(i));
			System.out.println(dataVector.contains(rowValue));
			System.out.println(wantValue);
			if (dataVector.get(i).contains(rowValue)) {
				tableModel.setValueAt(wantValue, i, 7);
			}
		}
	}
}
