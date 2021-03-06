package com.dreamfactory.exam_controller.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="v1/orders"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)

public class OrderController {
    @PostMapping

    //postOrder() 메서드는 커피 주문 정보를 등록한다
    public /*String*/ResponseEntity postOrder(HttpServletRequest httpServletRequest,
                                              @RequestParam("memberId") String memberId,
                                              @RequestParam("coffeeId") String coffeeId) {

////        Map<String, String> map = new HashMap<>();
////        map.put("memberId", memberId);
////        map.put("coffeeId", coffeeId);
//
//        return new ResponseEntity(map, HttpStatus.CREATED);

        System.out.println("user-agent: " + httpServletRequest.getHeader("user-agent"));
        return new ResponseEntity<>(new Order(memberId, coffeeId),
                HttpStatus.CREATED);
//        System.out.println("# memberId:" + memberId);
//        System.out.println("# coffeeId:" + coffeeId);
//
//        String reponse =
//                "{\"" +
//                        "memberId\":\"" + memberId + "\"," +
//                        "\"coffeeId\":\"" + coffeeId +
//                        "\"}";
//        return reponse;
    }

    @GetMapping("/{order-id}")
    public /*String*/ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId: " + orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping //별도의 URI를 지정해주지 않았기 때문에 클래스 레벨의 URI(“/v1/orders”)에 매핑된다

    //getOrders() 메서드는 주문 목록을 클라이언트에게 제공하는 핸들러 메서드이다
    public /*String*/ResponseEntity getOrders() {
        System.out.println("# get Orders");
        return new ResponseEntity(HttpStatus.OK);
    }
}
