package com.yedam.book;

import lombok.Data;

@Data

public class BuyingHistory {
//	BOOKNAME             VARCHAR2(60) 
//	BOOKWRITER           VARCHAR2(30) 
//	BOOKPRICED           NUMBER       
//	BOOKID      NOT NULL NUMBER       
//	CREATE_DATE          DATE  
	
	private String bookName;
	private String bookWriter;
	private int bookPriced;
	private int bookId;
	private String date;
}