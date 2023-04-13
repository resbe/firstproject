package com.yedam.book;

import java.util.List;
import java.util.Scanner;

import com.yedam.consumer.Consumer;
import com.yedam.consumer.ConsumerDAO;

public class BookService {
	public static Book BookInfo = null;

	Scanner sc = new Scanner(System.in);

	int menu = 0;
	int buy = 0;
	// 책 제목 검색

	public void getBookName() {

		System.out.println("검색>");
		String bookName = sc.nextLine();
		List<Book> booklist = BookDAO.getInstance().getBookName(bookName);

		if (booklist.isEmpty()) {
			System.out.println("해당 책이 존재하지 않습니다");
		} else if (booklist.size() > 1) {
			for (Book book : booklist) {
				System.out.println("책이름 : " + book.getBookName());
				System.out.println("저자 : " + book.getBookWriter());
				System.out.println("가격 : " + book.getBookPriced() + "원");
				System.out.println("고유번호 : " + book.getBookId());

			}
			choiceBook(booklist.size(), 1);
		} else if (booklist.size() == 1) {
			System.out.println("책이름 : " + booklist.get(0).getBookName());
			System.out.println("저자 : " + booklist.get(0).getBookWriter());
			System.out.println("가격 : " + booklist.get(0).getBookPriced() + "원");
			System.out.println("고유번호 : " + booklist.get(0).getBookId());
			choiceBook(booklist.size(), booklist.get(0).getBookId());
		}
	}

	// 나누기
	public void choiceBook(int size, int num) {
		if (size > 1) {
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
			} else {
				System.out.println("뒤로가기");

			}
		} else if (size == 1) {
			System.out.println("구매하시겠습니까?");
			System.out.println("1. 예 | 2.아니오");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				BookDAO.getInstance().getbookbuying(num);
				System.out.println("구매완료");
			} else {
				System.out.println("뒤로가기");

			}
		}
	}
	// 책 저자 검색
//	public void getBookWriter() {
//		System.out.println("저자>");
//		String bookWriter = sc.nextLine();
//		List <Book> booklist = BookDAO.getInstance().getBookWriter(bookWriter);
//		
//		if(booklist.isEmpty()) {
//			System.out.println("해당 책이 존재하지 않습니다");
//		}else{
//			for(Book book : booklist) {
//			System.out.println("책이름 : " + book.getBookName());
//			System.out.println("저자 : " + book.getBookWriter());
//			System.out.println("가격 : " + book.getBookPriced());
//			System.out.println("고유번호 : " + book.getBookId());
//		}
//		choiceBook(1,2);
//	}
//	}
//	// 책 장르 검색
//	
//	public void getBookGenre() {
//		System.out.println("책 장르>");
//		String bookGenre = sc.nextLine();
//		List <Book> booklist = BookDAO.getInstance().getBookGenre(bookGenre);
//		
//
//		if(booklist.isEmpty()) {
//			System.out.println("해당 책이 존재하지 않습니다");
//		}else{
//			for(Book book : booklist) {
//			System.out.println("책이름 : " + book.getBookName());
//			System.out.println("저자 : " + book.getBookWriter());
//			System.out.println("가격 : " + book.getBookPriced());
//			System.out.println("위치 : " + book.getBookLocation());
//			}
//		}
//	}
//	
//	

	// Best 도서
	public void getBestBook() {
		List<Book> booklist = BookDAO.getInstance().getBestBook();

		for (int i = 0; i < booklist.size(); i++) {
			System.out.println(i + 1 + "등");
			System.out.println("책 이름 : " + booklist.get(i).getBookName());
			System.out.println("책 작가 : " + booklist.get(i).getBookWriter());
			System.out.println("고유번호 : " + booklist.get(i).getBookId());
		}
		choiceBook(2, 3);

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

	// 구매내역보기

	public void getselfhisory() {
		List<BuyingHistory> buyinglist = BookDAO.getInstance().getselfhistory();

		if (buyinglist.isEmpty()) {
			System.out.println("구매내역이 없습니다.");
		} else {
			for (BuyingHistory history : buyinglist) {
				System.out.println("책 이름 : " + history.getBookName());
				System.out.println("저자 : " + history.getBookWriter());
				System.out.println("책 가격 : " + history.getBookPriced());
				System.out.println("고유 번호 : " + history.getBookId());
				System.out.println("구매날짜 : " + history.getDate());
			}

		}

	}

	public void bookAdd() {
		System.out.println("책 제목 >");
		String bookName = sc.nextLine();
		System.out.println("저자 >");
		String bookWriter = sc.nextLine();
		System.out.println("장르 > ");
		String bookGenre = sc.nextLine();
		System.out.println("가격 >");
		int bookPriced = Integer.parseInt(sc.nextLine());
		System.out.println("책 위치 > ");
		String bookLocation = sc.nextLine();
		System.out.println("고유번호 > ");
		int bookId = Integer.parseInt(sc.nextLine());

		Book book = new Book();

		book.setBookName(bookName);
		book.setBookWriter(bookWriter);
		book.setBookGenre(bookGenre);
		book.setBookPriced(bookPriced);
		book.setBookLocation(bookLocation);
		book.setBookId(bookId);

		int result = BookDAO.getInstance().bookAdd(book);

		if (result == 1) {
			System.out.println("책 추가");
		} else {
			System.out.println("책 추가 실패");
		}

	}

	public void bookUpdate1() {

		System.out.println("수정하고 싶은 책의 고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);

		if (book != null) {
			System.out.println("고유번호 : " + number);
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("장르 : " + book.getBookGenre());

			System.out.println("수정하실 이름을 입력해주세요");
			String name = sc.nextLine();

			book.setBookName(name);

			int result = BookDAO.getInstance().bookUpdate1(book, number);

			if (result > 0) {
				System.out.println("내용 수정 성공");
			} else {
				System.out.println("내용 수정 실패");
			}
		} else {
			System.out.println("존재히지 않는 고유번호입니다.");
		}
	}

	public void bookUpdate2() {

		System.out.println("수정하고 싶은 책의 고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);

		if (book != null) {
			System.out.println("고유번호 : " + number);
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("장르 : " + book.getBookGenre());

			System.out.println("수정하실 저자를 입력해주세요");
			String name = sc.nextLine();

			book.setBookWriter(name);

			int result = BookDAO.getInstance().bookUpdate2(book, number);

			if (result > 0) {
				System.out.println("내용 수정 성공");
			} else {
				System.out.println("내용 수정 실패");
			}
		} else {
			System.out.println("존재히지 않는 고유번호입니다.");
		}
	}

	public void bookUpdate3() {

		System.out.println("수정하고 싶은 책의 고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);

		if (book != null) {
			System.out.println("고유번호 : " + number);
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("장르 : " + book.getBookGenre());

			System.out.println("수정하실 장르를 입력해주세요");
			String name = sc.nextLine();

			book.setBookGenre(name);

			int result = BookDAO.getInstance().bookUpdate3(book, number);

			if (result > 0) {
				System.out.println("내용 수정 성공");
			} else {
				System.out.println("내용 수정 실패");
			}
		} else {
			System.out.println("존재히지 않는 고유번호입니다.");
		}
	}

	public void bookUpdate4(int num) {
		serchnum();
//		System.out.println("수정하고 싶은 책의 고유번호를 입력해주세요");
//		int number = Integer.parseInt(sc.nextLine());
//		Book book = BookDAO.getInstance().getsearchBookName(number);
//
//		if (book != null) {
//			System.out.println("고유번호 : " + number);
//			System.out.println("책이름 : " + book.getBookName());
//			System.out.println("저자 : " + book.getBookWriter());
//			System.out.println("가격 : " + book.getBookPriced() + "원");
//			System.out.println("장르 : " + book.getBookGenre());

		System.out.println("수정하실 가격을 입력해주세요");
		int name = Integer.parseInt(sc.nextLine());
		Book book = new Book();
		book.setBookPriced(name);

		int result = BookDAO.getInstance().bookUpdate4(book, num);

		if (result > 0) {
			System.out.println("내용 수정 성공");
		} else {
			System.out.println("내용 수정 실패");
		}

//		} else {
//			System.out.println("존재히지 않는 고유번호입니다.");
//		}
	}

	public void serchnum() {
		System.out.println("수정하고 싶은 책의 고유번호를 입력해주세요");
		int number = Integer.parseInt(sc.nextLine());
		Book book = BookDAO.getInstance().getsearchBookName(number);

		if (book != null) {
			System.out.println("고유번호 : " + number);
			System.out.println("책이름 : " + book.getBookName());
			System.out.println("저자 : " + book.getBookWriter());
			System.out.println("가격 : " + book.getBookPriced() + "원");
			System.out.println("장르 : " + book.getBookGenre());

		} else {
			System.out.println("존재히지 않는 고유번호입니다.");
		}
	}
}