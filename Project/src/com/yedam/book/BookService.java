package com.yedam.book;

import java.util.List;
import java.util.Scanner;

import com.yedam.consumer.ConsumerDAO;

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
		}else if(booklist.size() > 1) {
		for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("고유번호 : " + book.getBookId());
	
		}
		choiceBook(booklist.size(),1);
	}else if(booklist.size() == 1) {
		System.out.println("책이름 : " + booklist.get(0).getBookName());
		System.out.println("저자 : " +booklist.get(0).getBookWriter());
		System.out.println("가격 : " + booklist.get(0).getBookPriced() + "원");
		System.out.println("고유번호 : " + booklist.get(0).getBookId());
		choiceBook(booklist.size(),booklist.get(0).getBookId());
	}	
	}
	
	//나누기
	public void choiceBook(int size,int num) {
		if(size >1) {
		System.out.println("선택하실 책의 고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);
		
		System.out.println("책이름 : " + book.getBookName());
		System.out.println("저자 : " + book.getBookWriter());
		System.out.println("가격 : " + book.getBookPriced() + "원");
		System.out.println("고유번호 : " + number);
			
		System.out.println("구매하시겠습니까?");
		System.out.println("1. 예 | 2.아니오");
		menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {
		 BookDAO.getInstance().getbookbuying(number);
		 System.out.println("구매완료!");
		}else{
			System.out.println("뒤로가기");
			
		}
		}else if(size == 1) {
			System.out.println("구매하시겠습니까?");
			System.out.println("1. 예 | 2.아니오");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
			 BookDAO.getInstance().getbookbuying(num);
			 System.out.println("구매완료");
			}else{
				System.out.println("뒤로가기");
				
		}
	}
	}
	//책 저자 검색
	public void getBookWriter() {
		System.out.println("저자>");
		String bookWriter = sc.nextLine();
		List <Book> booklist = BookDAO.getInstance().getBookWriter(bookWriter);
		
		if(booklist.isEmpty()) {
			System.out.println("해당 책이 존재하지 않습니다");
		}else{
			for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced());
			System.out.println("고유번호 : " + book.getBookId());
		}
		choiceBook(1,2);
	}
	}
	// 책 장르 검색
	
	public void getBookGenre() {
		System.out.println("책 장르>");
		String bookGenre = sc.nextLine();
		List <Book> booklist = BookDAO.getInstance().getBookGenre(bookGenre);
		

		if(booklist.isEmpty()) {
			System.out.println("해당 책이 존재하지 않습니다");
		}else{
			for(Book book : booklist) {
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced());
			System.out.println("위치 : " + book.getBookLocation());
			}
		}
	}
	
	
	
	//Best 도서
	public void getBestBook() {
		List<Book> booklist = BookDAO.getInstance().getBestBook();

		for(int i = 0; i<booklist.size(); i++) {
			System.out.println(i+1 + "등");
			System.out.println("책 이름 : " + booklist.get(i).getBookName());
			System.out.println("책 작가 : " + booklist.get(i).getBookWriter());
			System.out.println("고유번호 : " + booklist.get(i).getBookId());
		}
		choiceBook();
		
//		for(Book book : booklist) {
//			
//			System.out.println("책 이름 : " + book.getBookName());
//			System.out.println("책 작가 : " + book.getBookWriter());
//			System.out.println("고유번호 : " + book.getBookId());
//			
//		}
//		for (int i = 0 ; i < booklist.size(); i ++) {
//			System.out.println(i+1 + ":" );
	}
	
	//구매내역보기
	
	public void getselfhisory() {
		List<BuyingHistory> buyinglist =BookDAO.getInstance().getselfhistory();
		
		for(BuyingHistory history : buyinglist) {
			System.out.println("책 이름 : " + history.getBookName());
			System.out.println("책 가격 : " + h);
		}
	}

	
}



