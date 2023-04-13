package com.yedam.consumer;

import java.util.Scanner;

import com.yedam.app.Application;

public class ConsumerService {
	
	//로그인 정보
	
	
	public static Consumer ConsumerInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	//로그인
	
	public void login() {
		Consumer consumer = new Consumer();
		
		System.out.println("ID>");
		String id =  sc.nextLine();
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		consumer = ConsumerDAO.getInstance().login(id);
		
		if(consumer != null) {
			if(consumer.getConsumerPw().equals(pw)) {
				System.out.println(consumer.getConsumerNickName()+"님 환영합니다.");
				ConsumerInfo = consumer;
			}else {
				System.out.println("비밀번호가 틀렸습니다");
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다 회원가입하시겠습니까?");
		}
		
	}
	
	
	public void logout() {
		if (ConsumerInfo != null) {
			ConsumerInfo = null ;
			System.out.println("로그아웃되었습니다.");
		}
	}
		
		
		
	//회원가입
		
		
	public void consumerAdd() {
		System.out.println("아이디>");
		String consumerId =  sc.nextLine();
		System.out.println("비밀번호>");
		String consumerPw = sc.nextLine();
		System.out.println("비밀번호 확인>");
		String consumerPw2 = sc.nextLine();
		System.out.println("이름>");
		String consumerName = sc.nextLine();
		System.out.println("닉네임>");
		String consumerNickName = sc.nextLine();
		System.out.println("전화번호>");
		String consumerTell = sc.nextLine();
		System.out.println("이메일>");
		String consumerEmail = sc.nextLine();
		System.out.println("주소 입력>");
		String consumerAddress = sc.nextLine();
		
		Consumer consumer = new Consumer();
		
		consumer.setConsumerId(consumerId);
		consumer.setConsumerPw(consumerPw);
		consumer.setConsumerPw2(consumerPw2);
		consumer.setConsumerName(consumerName);
		consumer.setConsumerNickName(consumerNickName);
		consumer.setConsumerTell(consumerTell);
		consumer.setConsumerEmail(consumerEmail);
		consumer.setConsumerAddress(consumerAddress);
		
		ConsumerDAO.getInstance().consumerAdd(consumer);
		
		
		if(consumer != null) {
			if(consumerPw.equals(consumerPw2)) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.다시 입력해주세요.");
			}

		}
	
	
	}
	
	public void getselfInfo() {
		
		Consumer consumer = ConsumerDAO.getInstance().getselfInfo();
		
		System.out.println("이름 : " + consumer.getConsumerName());
		System.out.println("아이디 : " + consumer.getConsumerId());
		System.out.println("비밀번호 :" + consumer.getConsumerPw());
		System.out.println("닉네임 : " + consumer.getConsumerNickName());
		System.out.println("전화번호 : " + consumer.getConsumerTell());
		System.out.println("이메일 : " + consumer.getConsumerEmail());
		System.out.println("주소 :" + consumer.getConsumerAddress());
		}
	
	public void getselftest (){
		System.out.println("회원정보 수정을 위해서 아이디,비밀번호를 다시 입력해주세요");
		System.out.println("ID>");
		String id = sc.nextLine();
		System.out.println("PW>");
		String pw = sc.nextLine();

		Consumer consumer = new Consumer();
		consumer.setConsumerId(id);
		consumer.setConsumerPw(pw);

		if(id.equals(ConsumerInfo.getConsumerId()) && pw.equals(ConsumerInfo.getConsumerPw())){
			System.out.println("인증성공");
		}else {
			System.out.println("인증실패");
		}
	}
	
	
	
	
	public void consumerUpdate1() {
		
		System.out.println("수정하실 이름을 입력해주세요");
		String name = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerName(name);
		
		int result = ConsumerDAO.getInstance().consumerUpdate1(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}
	}
	public void consumerUpdate2() {
		
		System.out.println("수정하실 닉네임을 입력해주세요");
		String nickname = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerNickName(nickname);
		
		int result = ConsumerDAO.getInstance().consumerUpdate2(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}
	}
	public void consumerUpdate3() {
		
		System.out.println("수정하실 아이디를 입력해주세요");
		String id = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerId(id);
		
		int result = ConsumerDAO.getInstance().consumerUpdate3(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
			ConsumerInfo.setConsumerId(id);
		}else {
			System.out.println("내용 수정 실패");
		}
	}
	public void consumerUpdate4() {
		
		System.out.println("수정하실 비밀번호를 입력해주세요");
		String pw = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerPw(pw);
		
		int result = ConsumerDAO.getInstance().consumerUpdate4(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
			ConsumerInfo.setConsumerPw(pw);
			int number = 0;
		}else {
			System.out.println("내용 수정 실패");
		}
	
	}
	public void consumerUpdate5() {
		
		System.out.println("수정하실 이메일을 입력해주세요");
		String mail = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerEmail(mail);
		
		int result = ConsumerDAO.getInstance().consumerUpdate5(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}	
	}
	public void consumerUpdate6() {
		
		System.out.println("수정하실 전화번호를 입력해주세요");
		String tel = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerTell(tel);
		
		int result = ConsumerDAO.getInstance().consumerUpdate6(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}	
	}
	public void consumerUpdate7() {
		
		System.out.println("수정하실 주소를 입력해주세요");
		String address = sc.nextLine();
		
		Consumer consumer = new Consumer();
		consumer.setConsumerAddress(address);
		
		int result = ConsumerDAO.getInstance().consumerUpdate7(consumer);
		
		if(result > 0) {
			System.out.println("내용 수정 성공");
		}else {
			System.out.println("내용 수정 실패");
		}	
	}
	public void consumerDelete() {
		System.out.println("탈퇴시 회원님의 정보가 모두 사라져 복구하실수가 없습니다. 정말로 탈퇴하시겠습니까?");
		System.out.println("1.예 | 2. 아니오");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			System.out.println("회원 탈퇴를 위해 아이디 비밀번호를 인증해주세요");
			System.out.println("ID>");
			String id = sc.nextLine();
			System.out.println("PW>");
			String pw = sc.nextLine();

			Consumer consumer = new Consumer();
			consumer.setConsumerId(id);
			consumer.setConsumerPw(pw);

			if(id.equals(ConsumerInfo.getConsumerId()) && pw.equals(ConsumerInfo.getConsumerPw())){
				System.out.println("인증성공.null님의 탈퇴가 이루어지셨습니다.");
				int result = ConsumerDAO.getInstance().consumerDelete();
				ConsumerService.ConsumerInfo = null;
				if(ConsumerService.ConsumerInfo != null) {
					System.out.println("로그인 정보 삭제 실패");
				}
			}else {
				System.out.println("인증실패.");
			}	

		}
	}
	
}
