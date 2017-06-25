package com.cibil.gst.model;

public class FixedLenghtModel {
	private String userId;
	private String bruId;
	private String controllNumber;
	
	private String reservedkey;
	private String date;
	
	private String timestamp;
	private String refNumber;
	
	private String currency1;
	private String Logic_identifier;
	
	private String Source;
	private String des;
	private String flag;
	private String Ignore_digit;
	private String Extra_values;
	
	
	public String getLogic_identifier() {
		return Logic_identifier;
	}
	public void setLogic_identifier(String logic_identifier) {
		Logic_identifier = logic_identifier;
	}
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}
	public String getIgnore_digit() {
		return Ignore_digit;
	}
	public void setIgnore_digit(String ignore_digit) {
		Ignore_digit = ignore_digit;
	}
	public String getExtra_values() {
		return Extra_values;
	}
	public void setExtra_values(String extra_values) {
		Extra_values = extra_values;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBruId() {
		return bruId;
	}
	public void setBruId(String bruId) {
		this.bruId = bruId;
	}
	public String getControllNumber() {
		return controllNumber;
	}
	public void setControllNumber(String controllNumber) {
		this.controllNumber = controllNumber;
	}
	public String getReservedkey() {
		return reservedkey;
	}
	public void setReservedkey(String reservedkey) {
		this.reservedkey = reservedkey;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getCurrency1() {
		return currency1;
	}
	
	
	@Override
	public String toString() {
		return "FixedLenghtModel [userId=" +userId+ ", bruId=" + bruId + ",Ignore_digit=" +Ignore_digit +", controllNumber=" + controllNumber
				+ ", reservedkey=" + reservedkey + ", date=" + date + ", timestamp=" + timestamp + ", refNumber="
				+ refNumber + ", currency1=" + currency1 + ", Logic_identifier=" + Logic_identifier + ",Extra_values= " +Extra_values+"]";
	}
	
}
