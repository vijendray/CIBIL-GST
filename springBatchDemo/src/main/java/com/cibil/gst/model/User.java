package com.cibil.gst.model;

public class User {
	
	private String TICKET_ID;
	private String Member_Id;
	private String Member_Name;
	private String USER_ID;
	private String PRODUCT_NAME;
	private String REQUEST_TYPE;
	private String REQUEST_DATE;
	private String FULFILLED_DATE;
	private String CREDIT_UNITS_DEDUCTED;
	private String USAGE_CONTRACT_ID;
	private String DUNS_NUMBER;
	private String BORROWER_NAME;
	private String APPLICATION_REFERENCE_NO;
	private String APPLICATION_AMOUNT;
	private String SELF_ENQIRY;
	private String STATUS;
	private String RESTORE_CREDIT_UNITS;
	private String RESTORED_DATE;
	private String RESTORED_IN_CONTRACT_ID;
	private String RESTORED_REASON;
	private String CSE_USER;
	private String CSE_USER_NOTE;
	private String SEARCH_CRITERIA;
	private String CMR_DELIVERED;
	private String flag;
	private String des;
	private String source;
	
	public String getTICKET_ID() {
		return TICKET_ID;
	}
	public void setTICKET_ID(String tICKET_ID) {
		TICKET_ID = tICKET_ID;
	}
	public String getMember_Id() {
		return Member_Id;
	}
	public void setMember_Id(String member_Id) {
		Member_Id = member_Id;
	}
	public String getMember_Name() {
		return Member_Name;
	}
	public void setMember_Name(String member_Name) {
		Member_Name = member_Name;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getREQUEST_TYPE() {
		return REQUEST_TYPE;
	}
	public void setREQUEST_TYPE(String rEQUEST_TYPE) {
		REQUEST_TYPE = rEQUEST_TYPE;
	}
	public String getREQUEST_DATE() {
		return REQUEST_DATE;
	}
	public void setREQUEST_DATE(String rEQUEST_DATE) {
		REQUEST_DATE = rEQUEST_DATE;
	}
	public String getFULFILLED_DATE() {
		return FULFILLED_DATE;
	}
	public void setFULFILLED_DATE(String fULFILLED_DATE) {
		FULFILLED_DATE = fULFILLED_DATE;
	}
	public String getCREDIT_UNITS_DEDUCTED() {
		return CREDIT_UNITS_DEDUCTED;
	}
	public void setCREDIT_UNITS_DEDUCTED(String cREDIT_UNITS_DEDUCTED) {
		CREDIT_UNITS_DEDUCTED = cREDIT_UNITS_DEDUCTED;
	}
	public String getUSAGE_CONTRACT_ID() {
		return USAGE_CONTRACT_ID;
	}
	public void setUSAGE_CONTRACT_ID(String uSAGE_CONTRACT_ID) {
		USAGE_CONTRACT_ID = uSAGE_CONTRACT_ID;
	}
	public String getDUNS_NUMBER() {
		return DUNS_NUMBER;
	}
	public void setDUNS_NUMBER(String dUNS_NUMBER) {
		DUNS_NUMBER = dUNS_NUMBER;
	}
	public String getBORROWER_NAME() {
		return BORROWER_NAME;
	}
	public void setBORROWER_NAME(String bORROWER_NAME) {
		BORROWER_NAME = bORROWER_NAME;
	}
	public String getAPPLICATION_REFERENCE_NO() {
		return APPLICATION_REFERENCE_NO;
	}
	public void setAPPLICATION_REFERENCE_NO(String aPPLICATION_REFERENCE_NO) {
		APPLICATION_REFERENCE_NO = aPPLICATION_REFERENCE_NO;
	}
	public String getAPPLICATION_AMOUNT() {
		return APPLICATION_AMOUNT;
	}
	public void setAPPLICATION_AMOUNT(String aPPLICATION_AMOUNT) {
		APPLICATION_AMOUNT = aPPLICATION_AMOUNT;
	}
	public String getSELF_ENQIRY() {
		return SELF_ENQIRY;
	}
	public void setSELF_ENQIRY(String sELF_ENQIRY) {
		SELF_ENQIRY = sELF_ENQIRY;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getRESTORE_CREDIT_UNITS() {
		return RESTORE_CREDIT_UNITS;
	}
	public void setRESTORE_CREDIT_UNITS(String rESTORE_CREDIT_UNITS) {
		RESTORE_CREDIT_UNITS = rESTORE_CREDIT_UNITS;
	}
	public String getRESTORED_DATE() {
		return RESTORED_DATE;
	}
	public void setRESTORED_DATE(String rESTORED_DATE) {
		RESTORED_DATE = rESTORED_DATE;
	}
	public String getRESTORED_IN_CONTRACT_ID() {
		return RESTORED_IN_CONTRACT_ID;
	}
	public void setRESTORED_IN_CONTRACT_ID(String rESTORED_IN_CONTRACT_ID) {
		RESTORED_IN_CONTRACT_ID = rESTORED_IN_CONTRACT_ID;
	}
	public String getRESTORED_REASON() {
		return RESTORED_REASON;
	}
	public void setRESTORED_REASON(String rESTORED_REASON) {
		RESTORED_REASON = rESTORED_REASON;
	}
	public String getCSE_USER() {
		return CSE_USER;
	}
	public void setCSE_USER(String cSE_USER) {
		CSE_USER = cSE_USER;
	}
	public String getCSE_USER_NOTE() {
		return CSE_USER_NOTE;
	}
	public void setCSE_USER_NOTE(String cSE_USER_NOTE) {
		CSE_USER_NOTE = cSE_USER_NOTE;
	}
	public String getSEARCH_CRITERIA() {
		return SEARCH_CRITERIA;
	}
	public void setSEARCH_CRITERIA(String sEARCH_CRITERIA) {
		SEARCH_CRITERIA = sEARCH_CRITERIA;
	}
	public String getCMR_DELIVERED() {
		return CMR_DELIVERED;
	}
	public void setCMR_DELIVERED(String cMR_DELIVERED) {
		CMR_DELIVERED = cMR_DELIVERED;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}		
}