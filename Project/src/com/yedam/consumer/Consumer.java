package com.yedam.consumer;

import lombok.Data;

@Data

public class Consumer {
//	CUSTOMENAME       VARCHAR2(12) 
//	CUSTOMERID        VARCHAR2(20) 
//	CUSTOMERPW        VARCHAR2(30) 
//	CUSTOMERPW2       VARCHAR2(30) 
//	CUSTOMERTEL       VARCHAR2(15) 
//	CUSTOMEREMAIL     VARCHAR2(30) 
//	CUSTOMERADDRES    VARCHAR2(40) 
	
	private String  consumerName;
	private String consumerId;
	private String consumerPw;
	private String consumerPw2;
	private String consumerNickName;
	private String consumerTell;
	private String consumerEmail;
	private String consumerAddress;
	private String userGrade;
	
}
