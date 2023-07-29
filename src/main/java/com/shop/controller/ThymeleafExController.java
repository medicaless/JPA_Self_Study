package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {

    //컨트롤러에 작성된 model의 key값에 담아준 값을 출력. thymeleaf의 문법이 "th:text"다.
    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model){
        model.addAttribute("data", "타임리프 예제 입니다.");
        return "thymeleafEx/thymeleafEx01";
    }

    //th:text (Entity 클래스 자체를 반환하면 안됨, 데이터 전달용 객체를 생성해서 사용해야 함), 뷰를 생성하여 결과를 출력
    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }
    //th:each (for문과 같이 반복문처럼 사용하는 역할) , 뷰를 생성하여 결과를 출력
    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1; i<=10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품" +i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    //th:if , th:unless 예제 (조건문과 같은 역할)
    @GetMapping(value="/ex04")
    public String thymeleafExample04(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1; i<=10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품"+i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }
    //th:href 예제 (href와 기능동일)
    @GetMapping(value="/ex05")
    public String thymeleafExample05(){
        return "thymeleafEx/thymeleafEx05";
    }
    //th:href (파라미터 전달 예제)
    @GetMapping(value = "/ex06")
    public String thymeleafExample06(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleafEx/thymeleafEx06";
    }

    @GetMapping(value="/ex07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }
}


