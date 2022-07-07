package com.dreamfactory.exam_controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//자동구성을 활성화 해 준다
//애플리케이션 패키지 내에서 @Component가 붙은 클래스를 검색한 후(scan), Spring Bean으로 등록하는 기능을 활성화 해 준다
//@Configuration 이 붙은 클래스를 자동으로 찾아주고, 추가적으로 Spring Bean을 등록하는 기능을 활성화 해 준다

public class ExamControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamControllerApplication.class, args);
	}
	//SpringApplication.run : Spring 애플리케이션을 부트스트랩하고, 실행하는 역할을 한다
}
