package com.dreamfactory.exam_controller.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
//@애터테이션에 의해 자동으로 import 된다

@RestController

@RequestMapping(value ="v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
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
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        String reponse =
                "{\"" +
                    "email\":\""+email+"\"," +
                    "\"name\":\""+name+"\",\"" +
                    "phone\":\"" + phone+
                "\"};
        return reponse;
    }

    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        //not implementation
        return null;
    }

    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        //not implementation
        return null;
    }

    @GetMapping
    public String getMember() {
        System.out.println("# get Members");

        //not implementation
        return null;
    }
}