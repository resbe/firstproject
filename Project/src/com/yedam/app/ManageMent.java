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
			if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				System.out.println("1. 책 찾기 | 2.마이페이지 | 3. 로그아웃 ");
			} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("B")) {
				System.out.println("1. 도서 검색 | 2. BEST 도서 검색 | 3.로그아웃");
			}
			System.out.println("입력>");
			menu = Integer.parseInt(sc.nextLine());
			if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				if (menu == 1) {
					SearchMenu();
				} else if (menu == 2) {
					myPage();
				} else if (menu == 3) {
					cs.logout();
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				}
			} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("B")) {
				if (menu == 1) {
					
				} else if (menu == 2) {
					
				} else if (menu == 3) {
					cs.logout();
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				}
			}

		}
	}

	public void SearchMenu() {
		while (true) {
			System.out.println("1. 도서 검색 | 2. BEST 도서 검색 | 3. 뒤로가기");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				getLastBookMenu();
			} else if (menu == 2) {
				bs.getBestBook();
			} else {
				break;
			}
		}
	}

	public void myPage() {
		// 제가 이거 책을 골라서 구매하기를 누르면
		// insert into buying values (?,?,?,sysdate);
		// 책 제목 제가 산 책이 = 내가 고른 책이니깐
		// 입력했던 고유번호의 책을이용해서
		// pstmt.setString(1,ConsumerService.ConsumerInfo.getConsumerId())
		// 2,
		
		// 구매내역 테이블 만들기 아이디 책 제목 책가격 (구매날짜)
		// 구매내역 조회하는 메소드와 구매내역 생성하는 메소드
		
		while (true) {
			System.out.println("1. 구매내역 | 2. MY정보보기 | 3.MY 정보 수정 | 4. 뒤로가기 ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				
			} else if (menu == 2) {
				cs.getselfInfo();
			} else if (menu == 3) {
				myInfoUpdate();
			} else if (menu == 4) {
				break;
				
			}
		}
	}
	public void getLastBookMenu() {
		while (true) {
			System.out.println("1. 도서제목 검색 | 2. 저자 검색 | 3. 장르 검색 | 4. 뒤로가기");
			int search = Integer.parseInt(sc.nextLine());
			if (search == 1) {
				bs.getBookName();
			} else if (search == 2) {
				bs.getBookWriter();
			} else if (search == 3) {
				bs.getBookGenre();
			} else {
				break;
			}
		}
	}


	public void myInfoUpdate() {
		System.out.println("1.이름 수정 | 2. 닉네임 수정 | 3.아이디 수정 | 4. 비밀번호 수정 | 5.이메일 수정 | 6.전화번호 수정 | 7.주소 수정 ");
		while (true) {

		}
	}

}
