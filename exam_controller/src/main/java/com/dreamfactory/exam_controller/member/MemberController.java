package com.dreamfactory.exam_controller.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
//@애터테이션에 의해 자동으로 import 된다

@RestController

@RequestMapping(value ="v1/members", produces = MediaType.APPLICATION_JSON_VALUE)
//produces애트리뷰트(Attribute)는 응답 데이터를 어떤 미디어 타입으로 클라이언트에게 전송할 지를 설정한다
//JSON 형식의 데이터를 응답 데이터로 전송하기 위해 MediaType.APPLICATION_JSON_VALUE 값을 설정했다
//이 값을 설정하지 않으면 현재 코드에서는 JSON 형식의 데이터를 응답으로 전송하지 않고, 문자열 자체를 전송한다


public class MemberController {
    @PostMapping

    //postMember() 메서드는 회원 정보를 등록해주는 핸들러 메서드이다
    //클라이언트의 요청 데이터(request body)를 서버에 생성할 때 사용하는 애너테이션이다
    //클라이언트에서 요청 전송 시 HTTP Method 타입을 동일하게 맞춰 주어야 한다(POST)
    public String postMember(@RequestParam("email")String email,
                             @RequestParam("name")String name,
                             @RequestParam("phone")String phone) {
        //@RequestParam() 핸들러 메서드의 파라미터 종류 중 하나이다
        /*클라이언트에서 전송하는 요청 데이터를 쿼리 파라미터(Query Parmeter 또는 Query String),
        폼 데이터(form-data), x-www-form-urlencoded 형식으로 전송하면 서버 쪽에서 전달 받을 때
        사용하는 애너테이션이다*/

        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        //클라이언트 쪽에서 JSON 형식의 데이터를 전송 받아야 하기 때문에
        //응답 문자열을 JSON 형식에 맞게 작성한다
        String reponse =
                "{\"" +
                    "email\":\""+email+"\"," +
                    "\"name\":\""+name+"\",\"" +
                    "phone\":\"" + phone+
                "\"}";
        return reponse;
    }

    @GetMapping("/{member-id}")
    //@GetMapping은 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션이다
    //@GetMapping 애너테이션의 괄호 안에는 몇 가지 애트리뷰트(Attribute)를 사용할 수 있다
    //여기서는 전체 HTTP URI의 일부를 지정했다
    //클라이언트에서 getMember() 핸들러 메서드에 요청을 보낼 경우, 최종 URI는 형태는 아래와 같다
    // /v1/members/{member-id}
    //{member-id}는 회원 식별자를 의미한다
    //클라이언트가 요청을 보낼 때 URI로 어떤 값을 지정하느냐에 따라서 동적으로 바뀌는 값이다

    public String getMember(@PathVariable("member-id")long memberId) {
        //getMember() 메서드는 특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드이다

        //@PathVariable역시 핸들러 메서드의 파라미터 종류 중 하나이다
        //@PathVariable의 괄호 안에 입력한 문자열 값은 @GetMapping("/{member-id}") 처럼 중괄호({ }) 안의 문자열과 동일해야 한다
        //여기서는 두 문자열 모두 “member-id” 로 동일하게 지정했다
        //두 문자열이 다르면 MissingPathVariableException이 발생한다

        System.out.println("# memberId: " + memberId);

        //not implementation
        return null;
    }

    @GetMapping //별도의 URI를 지정해주지 않았기 때문에 클래스 레벨의 URI(“/v1/members”)에 매핑된다

    //getMembers() 메서드는 회원 목록을 클라이언트에게 제공하는 핸들러 메서드이다
    public String getMembers() {
        System.out.println("# get Members");

        //not implementation
        return null;
    }
}