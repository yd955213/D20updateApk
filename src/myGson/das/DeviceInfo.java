package myGson.das;

import com.google.gson.annotations.SerializedName;

public class DeviceInfo {
	
	@SerializedName(value ="DevName", alternate = {"devName", "DEVNAME"} )
	public String DevName1 = null;
	@SerializedName(value ="DevAddress", alternate = {"devAddress", "DEVADDRESS"} )
	public String DevAddress1 = null;
	@SerializedName(value ="UdpPort", alternate = {"udpPort", "UDPPORT"} )
	public int UdpPort1 = 0;
	@SerializedName(value ="DevMacAddr", alternate = {"devMacAddr", "DEVMACADDR"} )
	public  String DevMacAddr1 = null;
	@SerializedName(value ="DevVer", alternate = {"devVer", "DEVVER"} )
	public String DevVer1 = null;
	public String getDevName1() {
		return DevName1;
	}
	public void setDevName1(String devName1) {
		DevName1 = devName1;
	}
	public String getDevAddress1() {
		return DevAddress1;
	}
	public void setDevAddress1(String devAddress1) {
		DevAddress1 = devAddress1;
	}
	public int getUdpPort1() {
		return UdpPort1;
	}
	public void setUdpPort1(int udpPort1) {
		UdpPort1 = udpPort1;
	}
	public String getDevMacAddr1() {
		return DevMacAddr1;
	}
	public void setDevMacAddr1(String devMacAddr1) {
		DevMacAddr1 = devMacAddr1;
	}
	public String getDevVer1() {
		return DevVer1;
	}
	public void setDevVer1(String devVer1) {
		DevVer1 = devVer1;
	}
	

	
	
}
