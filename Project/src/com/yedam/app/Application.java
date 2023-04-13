package com.yedam.app;

import java.util.Scanner;

import com.yedam.consumer.ConsumerService;

public class Application {
	Scanner sc = new Scanner(System.in);
	ConsumerService cs = new ConsumerService();
	int menuNo = 0;

	public Application() {
		run();
	}

	private void run() {
		while (true) {
			if (ConsumerService.ConsumerInfo == null) {
				System.out.println("==============================================================");
				System.out.println("\t\t1. 로그인 | 2. 회원가입 | 3. 종료");
				System.out.println("==============================================================");
				menuNo = Integer.parseInt(sc.nextLine());

				if (menuNo == 1) {
					cs.login();
				} else if (menuNo == 2) {
					cs.consumerAdd();
				} else if (menuNo == 3) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시입력해주세요");
				}
			} else if(ConsumerService.ConsumerInfo != null) {
				new ManageMent();
			}
		}
	}
}
	
	
	
	
	
	
