package myGson.das;

import com.google.gson.annotations.SerializedName;

public class UpdateStatus {
	@SerializedName(value = "Code", alternate = {"code", "CODE"})
	public String Code;

	@SerializedName(value = "DevMacAddr", alternate = {"devMacAddr", "DEVMACADDR"})
	public String DevMacAddr;

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
	
}
