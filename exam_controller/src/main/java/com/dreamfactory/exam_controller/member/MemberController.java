package com.dreamfactory.exam_controller.member;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
//@애터테이션에 의해 자동으로 import 된다

import java.util.HashMap;
import java.util.Map;


@RestController

/*Spring MVC에서는 특정 클래스에 @RestController 를 추가하면 해당 클래스가 REST API의 리소스(자원, Resource)를 처리하기 위한 API 엔드포인트로 동작함을 정의한다
//@RestController가 추가된 클래스는 애플리케이션 로딩 시, Spring Bean 으로 등록 해 준다
//REST API란 REST 방식을 통해서 리소스에 접근하기 위한 서비스 API를 지칭한다
//REST(Representational State Transfer)는 HTTP 네트워크 상의 리소스(Resource, 자원)를 정의하고 해당 리소스를 URI라는 고유의 주소로 접근하는 접근 방식을 의미한다*/

@RequestMapping("v1/members"/*,produce=MediaType.APPLICATION_JSON_VALUE*/)
//produces애트리뷰트(Attribute)는 응답 데이터를 어떤 미디어 타입으로 클라이언트에게 전송할 지를 설정한다


public class MemberController {
    @PostMapping

    /*postMember() 메서드는 회원 정보를 등록해주는 핸들러 메서드이다
    //클라이언트의 요청 데이터(request body)를 서버에 생성할 때 사용하는 애너테이션이다
    //클라이언트에서 요청 전송 시 HTTP Method 타입을 동일하게 맞춰 주어야 한다(POST)*/
    public /*String*/ResponseEntity postMember(@RequestHeader Map<String, String> headers,
                                     //@RequestHeader를 사용해서 Request의 모든 헤더 정보를 Map으로 전달 받는다
                                               @RequestParam("email")String email,
                                               @RequestParam("name")String name,
                                               @RequestParam("phone")String phone) {
        //@RequestParam() 핸들러 메서드의 파라미터 종류 중 하나이다
        /*클라이언트에서 전송하는 요청 데이터를 쿼리 파라미터(Query Parmeter 또는 Query String),
        폼 데이터(form-data), x-www-form-urlencoded 형식으로 전송하면 서버 쪽에서 전달 받을 때
        사용하는 애너테이션이다*/

//        System.out.println("# email: " + email);
//        System.out.println("# name: " + name);
//        System.out.println("# phone: " + phone);

//        JSON문자열 응답 타입을 수작업 코드에서 Map객체로 변경->produce애트리뷰트를 삭제할 수 있다
            //MAp 객체를 리턴하면 내부적으로 응답 데이터를 JSON데이터로 자동 변환해야 한다고 인식한다
//            Map<String, String> map = new HashMap<>();
//            map.put("email", email);
//            map.put("name", name);
//            map.put("phone", phone);

        //@RequestHeader Map을 사용하여 전체 헤더 정보를 받아 온다
        for (Map.Entry<String, String> entry : headers.entrySet()){
            System.out.println("key: " + entry.getKey() +
                    ", value: " + entry.getValue());
        }
            //리턴 값을 변경된 ResponseEntity로 대체
            //ResponseEntity 객체를 생성하고 생성자 파라미터로 map과 HttpStatus.CREATED를 반환한다
            //HttpStatus.CREATED 는 201, created를 의미한다
//            return new ResponseEntity<>(map, HttpStatus.CREATED);
        //@RequestHeader Map 을 사용함으로 리턴 값의 코드가 변경된다
        return new ResponseEntity<>(new Member(email, name, phone), HttpStatus.CREATED);


        //클라이언트 쪽에서 JSON 형식의 데이터를 전송 받아야 하기 때문에
        //응답 문자열을 JSON 형식에 맞게 작성한다
//        String reponse =
//                "{\"" +
//                    "email\":\""+email+"\"," +
//                    "\"name\":\""+name+"\",\"" +
//                    "phone\":\"" + phone+
//                "\"}";
//        return reponse;
    }

    @GetMapping("/{member-id}")
    //@GetMapping은 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션이다
    //@GetMapping 애너테이션의 괄호 안에는 몇 가지 애트리뷰트(Attribute)를 사용할 수 있다
    //여기서는 전체 HTTP URI의 일부를 지정했다
    //클라이언트에서 getMember() 핸들러 메서드에 요청을 보낼 경우, 최종 URI는 형태는 아래와 같다
    // /v1/members/{member-id}
    //{member-id}는 회원 식별자를 의미한다
    //클라이언트가 요청을 보낼 때 URI로 어떤 값을 지정하느냐에 따라서 동적으로 바뀌는 값이다

    public /*String*/ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        //getMember() 메서드는 특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드이다

        //@PathVariable역시 핸들러 메서드의 파라미터 종류 중 하나이다
        //@PathVariable의 괄호 안에 입력한 문자열 값은 @GetMapping("/{member-id}") 처럼 중괄호({ }) 안의 문자열과 동일해야 한다
        //여기서는 두 문자열 모두 “member-id” 로 동일하게 지정했다
        //두 문자열이 다르면 MissingPathVariableException이 발생한다

        System.out.println("# memberId: " + memberId);
        //리턴 값을 변경된 ResponseEntity로 대체
        //HttpStatus.OK 는 200, OK를 의미한다
        return new ResponseEntity<>(HttpStatus.OK);
        //not implementation
//        return null;
    }

    @GetMapping //별도의 URI를 지정해주지 않았기 때문에 클래스 레벨의 URI(“/v1/members”)에 매핑된다

    //getMembers() 메서드는 회원 목록을 클라이언트에게 제공하는 핸들러 메서드이다
    public /*String*/ResponseEntity getMembers() {
        System.out.println("# get Members");
        //리턴 값을 변경된 ResponseEntity로 대체
        //HttpStatus.OK 는 200, OK를 의미한다
        return new ResponseEntity<>(HttpStatus.OK);
        //not implementation
//        return null;
    }
}