package com.yedam.app;

import java.util.Scanner;

import com.yedam.book.BookService;
import com.yedam.consumer.Consumer;
import com.yedam.consumer.ConsumerService;


public class ManageMent {
	public ManageMent() {		
		bookStore();
	}

	ConsumerService cs = new ConsumerService();

	int menu = 0;
	Scanner sc = new Scanner(System.in);
	BookService bs = new BookService();

	//1번메뉴
	
	private void bookStore() {
		while (true) {
			if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				 System.out.println("==============================================================");
				System.out.println("\t\t1. 도서 찾기 | 2.마이페이지 | 3. 로그아웃 ");
				 System.out.println("==============================================================");
			} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("B")) {
				System.out.println("==============================================================");
				System.out.println("\t\t1. 도서 업데이트 | 2.매출정보 | 3.로그아웃");
				System.out.println("==============================================================");
			}
			System.out.println("메뉴 >");
			menu = Integer.parseInt(sc.nextLine());
			if (ConsumerService.ConsumerInfo.getUserGrade().equals("C")) {
				if (menu == 1) {
					SearchMenu();
				} else if (menu == 2) {
					myPage();
					if(ConsumerService.ConsumerInfo == null) {
						break;
					}
				} else if (menu == 3) {
					cs.logout();
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				}
			} else if (ConsumerService.ConsumerInfo.getUserGrade().equals("B")) {
				if (menu == 1) {
					 bookupdate();
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

	//도서 검색 메뉴
	public void SearchMenu() {
		while (true) {
			System.out.println("==============================================================");
			System.out.println("\t\t1. 도서 검색 | 2. BEST 도서 보기 | 3. 뒤로가기");
			System.out.println("==============================================================");
			System.out.println("메뉴 >");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				bs.getBookName();
			} else if (menu == 2) {
				bs.getBestBook();
			} else {
				break;
			}
		}
		
		
		
	}
	
	
	//마이페이지
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
			System.out.println("==============================================================");
			System.out.println("\t1. 구매내역 | 2. MY정보보기 | 3.MY 정보 수정 | 4. 뒤로가기 ");
			System.out.println("==============================================================");
			System.out.println("메뉴 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				bs.getselfhisory();
			} else if (menu == 2) {
				cs.getselfInfo();
			} else if (menu == 3) {
				System.out.println("==========회원정보 수정을 위해서 아이디,비밀번호를 다시 입력해주세요=========");
				System.out.println("ID>");
				String id = sc.nextLine();
				System.out.println("PW>");
				String pw = sc.nextLine();

				Consumer consumer = new Consumer();
				consumer.setConsumerId(id);
				consumer.setConsumerPw(pw);

				if(id.equals(ConsumerService.ConsumerInfo.getConsumerId()) && pw.equals(ConsumerService.ConsumerInfo.getConsumerPw())){
					System.out.println("인증성공");
					myInfoUpdate();
					if(ConsumerService.ConsumerInfo == null) {
						break;
					}
				}else {
					System.out.println("인증실패");
				}
			} else if (menu == 4) {
				break;
				
			}
		}
	}

	
//	public void getLastBookMenu() {
//		while (true) {
//			System.out.println("1. 도서제목 검색 | 2. 저자 검색 | 3. 장르 검색 | 4. 뒤로가기");
//			int search = Integer.parseInt(sc.nextLine());
//			if (search == 1) {
//				bs.getBookName();
//			} else if (search == 2) {
//				bs.getBookWriter();
//			} else if (search == 3) {
//				bs.getBookGenre();
//			} else {
//				break;
//			}
//		}
//	}

	//내 정보 수정
	public void myInfoUpdate() {

		while (true) {
			System.out.println("==============================================================");
			System.out.println("1.이름 수정 | 2.닉네임 수정 | 3.아이디 수정 | 4.비밀번호 수정 |5.이메일 수정  "); 
			System.out.println("\t6.전화번호 수정 | 7.주소 수정 | 8.회원 탈퇴 | 9.뒤로가기");
			System.out.println("==============================================================");
			System.out.println("메뉴 > ");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1){
				cs.consumerUpdate1();
			} else if( menu == 2) {
				cs.consumerUpdate2();
			} else if( menu == 3) {
				cs.consumerUpdate3();
			} else if( menu == 4) {
				cs.consumerUpdate4();
			} else if( menu == 5) {
				cs.consumerUpdate5();
			} else if( menu == 6) {
				cs.consumerUpdate6();
			} else if( menu == 7) {
				cs.consumerUpdate7();
			} else if( menu == 8) {
				cs.consumerDelete();
				if(ConsumerService.ConsumerInfo == null) {
					break;
				}
			} else if( menu == 9) {
					break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요");
			}
			

		}
	}
		///=========================직원=======================================
		
		public void bookupdate() {
			while(true) {
				System.out.println("==============================================================");
				System.out.println("\t\t1. 도서 추가 | 2.도서 수정 | 3.뒤로가기");
				System.out.println("==============================================================");
				System.out.println("메뉴 > ");
				menu = Integer.parseInt(sc.nextLine());
				if(menu == 1) {
					bs.bookAdd();
				}else if(menu == 2) {
					bookInfoUpdate();
				}else if(menu == 3) {
					break;
				}else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				}
				
			}
		}
	
		//책 수정
		public void bookInfoUpdate(){
			while(true) {
			System.out.println("==============================================================");
			System.out.println("1.제목 수정 | 2.저자 수정 | 3.장르 수정 | 4.가격 수정 | 5.뒤로 가기  "); 
			System.out.println("==============================================================");
			System.out.println("메뉴 > ");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1){
				bs.bookUpdate1();
			}else if(menu == 2) {
				bs.bookUpdate2();
			}else if(menu == 3) {
				bs.bookUpdate3();
			}else if(menu == 4) {
				bs.bookUpdate4();
			}else if(menu == 5) {
				break;
			}else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요");
			}
			}
			
		}
	
	
	

}
