package com.yedam.app;

import java.util.Scanner;

import com.yedam.book.BookService;
import com.yedam.consumer.ConsumerService;

public class ManageMent {
	public ManageMent() {
		bookStore();
	}

	ConsumerService cs = new ConsumerService();

	int menu = 0;
	Scanner sc = new Scanner(System.in);
	BookService bs = new BookService(); 
	private void bookStore() {
		while (true) {
			menu();
			if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				if (menu == 1) {
					SearchMenu();
				} else if (menu == 2) {

				} else if (menu == 3) {
					cs.logout();
					break;
				}
			} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				if (menu == 1) {
					
				}else if(menu ==2) {
					
				}else if(menu == 3) {
				cs.logout();
					break;
				}
			}

		}
	}
	
	
	

	private void menu() {
		if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
			System.out.println("1. 책 찾기 | 2.마이페이지 | 3. 로그아웃 ");
		} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("B")) {
			System.out.println("1. 도서 검색 | 2. BEST 도서 검색 | 3.로그아웃");
		}
		System.out.println("입력>");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	public void SearchMenu() {
		System.out.println("1. 도서 검색 | 2. BEST 도서 검색 | 3. 뒤로가기");
		menu = Integer.parseInt(sc.nextLine());
		while(true) {
		if(menu == 1) {
			getLastBookMenu();
		}else if(menu == 2) {
		
		System.out.println("장르 검색 > ");	
		}else {
			break;
			}
		}
	}
	public void getLastBookMenu() {
		while(true) {
		System.out.println("1. 도서제목 검색 | 2. 저자 검색 | 3. 장르 검색 | 4. 뒤로가기");
		int search = Integer.parseInt(sc.nextLine());
		if(search == 1) {
			bs.getBookName();
		}else if(search == 2) {
			bs.getBookWriter();
		}else if(search == 3) {
			bs.getBookGenre();
			
		}else {
			break;
		}
	}
	}	
		
	public void myPage() {
		System.out.println("1. 구매내역 | 2. MY정보보기 | 3.MY 정보 수정 | 4. 뒤로가기 ");
		
		//제가 이거 책을 골라서 구매하기를 누르면
		//insert into buying values (?,?,?,sysdate);
		책 제목 제가 산 책이 = 내가 고른 책이니깐
				입력했던 고유번호의 책을이용해서 
		pstmt.setString(1,ConsumerService.ConsumerInfo.getConsumerId())
						2,
		
		//구매내역 테이블 만들기 아이디 책 제목 책가격 (구매날짜)
		//구매내역 조회하는 메소드와 구매내역 생성하는 메소드
		
		menu = Integer.parseInt(sc.nextLine());
		while(true) {
		if(menu == 1) {
		
		}else if(menu == 2) {
		
		}else if(menu == 3){
		
		}else if(menu ==4) {
			break;
	
		}
	}
	}
	
	
			
}
