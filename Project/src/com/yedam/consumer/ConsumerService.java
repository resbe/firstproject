package com.yedam.consumer;

import java.util.Scanner;

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
				ConsumerInfo = consumer;
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
}
