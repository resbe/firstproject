package com.yedam.book;

import lombok.Data;

@Data

public class Book {
//	BOOKNAME        VARCHAR2(60) 
//	BOOKWRITER      VARCHAR2(30) 
//	BOOKGENRE       VARCHAR2(10) 
//	BOOKPRICED      NUMBER       
//	BOOKLOCATION    CHAR(1)      
//	BOOKSALE        NUMBER   
	private String bookName;
	private String bookWriter;
	private String bookGenre;
	private int bookPriced;
	private int bookSale;
	private String bookLocation;
	private int bookId;
}
