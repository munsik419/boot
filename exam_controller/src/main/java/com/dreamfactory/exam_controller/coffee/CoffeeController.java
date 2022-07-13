package com.dreamfactory.exam_controller.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="v1/coffees"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
//v1은 버젼을 의미한다. coffees는 데이터 post, get 의 조회 위치를 의미한다

public class CoffeeController {
    @PostMapping

    //postCoffee() 메서드는 커피 정보를 등록해 준다
    public /*String*/ResponseEntity postCoffee(@RequestParam("coffee")String coffee,
                                                 @RequestParam("coffeeId")String coffeeId,
                                                 @RequestParam("korName")String korName,
                                                 @RequestParam("engName")String engName,
                                                 @RequestParam("price")int price) {
//        System.out.println("# coffee:" + coffee);
//        System.out.println("# coffeeId:" + coffeeId);
//        System.out.println("# korName:" + korName);
//        System.out.println("# engName:" + engName);
//        System.out.println("# price:" + price);

        //Map객체로 변경
            Map<String, String> map = new HashMap<>();
            map.put("coffee", coffee);
            map.put("coffeeId", coffeeId);
            map.put("korName", korName);
            map.put("engName", engName);
            map.put("price", String.valueOf(price));

            //return 값을 ResponseEntity로 변경
        return new ResponseEntity<>(map, HttpStatus.CREATED);

//        String reponse =
//                "{\"" +
//                    "coffee\":\""+coffee+"\"," +
//                    "\"coffeeId\":\""+coffeeId+"\"," +
//                    "\"korName\":\""+korName+"\"," +
//                    "\"engName\":\""+engName+"\"," +
//                    "\"price\":\""+price+
//                "\"}";
//        return reponse;
    }

    @GetMapping("/{coffee-id}")

    //getCoffee() 메서드는 커피 정보을 클라이언트에게 제공하는 핸들러 메서드이다
    public /*String*/ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);
        return new ResponseEntity<>(HttpStatus.OK);
        }

    @GetMapping //별도의 URI를 지정해주지 않았기 때문에 클래스 레벨의 URI(“/v1/coffees”)에 매핑된다

    //getCoffees() 메서드는 커피 목록을 클라이언트에게 제공하는 핸들러 메서드이다
    public /*String*/ResponseEntity getCoffees() {
        System.out.println("# get Coffees");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}