package com.yedam.app;

import java.util.Scanner;

import com.yedam.consumer.ConsumerService;



public class Application {
	Scanner sc = new Scanner(System.in);
	ConsumerService cs = new ConsumerService();
	public Application() {
		run();
	}
	
	int menuNo = 0;
	private void run() {
		while(true) {
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
			menuNo = Integer.parseInt(sc.nextLine());
			
			if(menuNo == 1) {
				cs.login();
				if(ConsumerService.ConsumerInfo !=  null){
					new ManageMent();
				}
			}else if(menuNo == 2) {
				cs.consumerAdd();
				cs.login();
				if(ConsumerService.ConsumerInfo !=  null){
				new ManageMent();
			}else if(menuNo == 3) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	}
	
}
	
	
	
	
	
	
