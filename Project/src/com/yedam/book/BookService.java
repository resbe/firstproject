package com.yedam.book;

import java.util.List;
import java.util.Scanner;

public class BookService {

	Scanner sc = new Scanner(System.in);
	
	int menu =0;
	int buy = 0;
	//책 제목 검색
	
	public void getBookName() {
		
		System.out.println("책 이름>");
		String bookName = sc.nextLine();
		List<Book> booklist = BookDAO.getInstance().getBookName(bookName);
		
		if(booklist.isEmpty()) {
			System.out.println("해당 책이 존재하지 않습니다");
		}else {
		for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("고유번호 : " + book.getBookId());
		}
		choiceBook();
	}
	}
	
	public void choiceBook() {
		System.out.println("고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);
		
		System.out.println("책이름 : " + book.getBookName());
		System.out.println("저자 : " + book.getBookWriter());
		System.out.println("가격 : " + book.getBookPriced() + "원");
		System.out.println("고유번호 : " + book.getBookId());
			
		System.out.println("구매하시겠습니까?");
		System.out.println("1. 예 | 2.아니오");
		menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			//구매하는 메소드 ==구매내역 추가 메소드 insert into bookDAO에서 만들기
		}else{
			System.out.println("뒤로가기");
			
		}
	
	
	//책 저자 검색
	public void getBookWriter() {
		System.out.println("저자>");
		String bookWriter = sc.nextLine();
		List <Book> booklist = BookDAO.getInstance().getBookWriter(bookWriter);
		
		if(booklist.isEmpty()) {
			System.out.println("해당 책이 존재하지 않습니다");
		}for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced());
			System.out.println("위치 : " + book.getBookLocation());
		}
	}
	
	// 책 장르 검색
	
	public void getBookGenre() {
		System.out.println("책 장르>");
		String bookGenre = sc.nextLine();
		List <Book> booklist = BookDAO.getInstance().getBookGenre(bookGenre);
		
//		if(book == null){
//			System.out.println("해당 책은 존재하지 않습니다.");
//		}else {
//			System.out.println("책이름 : " + book.getBookName());
//			System.out.println("저자 : " + book.getBookWriter());
//			System.out.println("가격 : " + book.getBookPriced());
//			System.out.println("위치 : " + book.getBookLocation());
//		}
		for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced());
			System.out.println("위치 : " + book.getBookLocation());
		}
	}
	
	

	
	
	
	public void getbookBuy(int search) {
		System.out.println("구매하시겠습니까?");
		System.out.println("1. 예 | 2.아니오");
		menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
			buy = 1;
		}else if(menu == 2) {
			buy = 0;
		}
		
		Book book = new Book();
		
		if (search == 1) {
			book.setBookName(Null);
		}
	 
		book.setBookSale(buy);
		
		
		int result = BookDAO.getInstance().
				
	}
	
	
	
	


	
}



