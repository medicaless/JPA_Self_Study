package com.shop.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

//조회할 대상 만들어주기

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 리스트")
    public void createItemTest(){
//        Item item = new Item();
//        item.setItemNm("테스트 상품");
//        item.setPrice(10000);
//        item.setItemDetail("테스트 상품 상세 설명");
//        item.setItemSellStatus(ItemSellStatus.SELL);
//        item.setStockNumber(100);
//        item.setLegTime(LocalDateTime.now());
//        item.setUpdateTime(LocalDateTime.now());
//        Item savedItem = itemRepository.save(item);
//        System.out.println(savedItem.toString());
//        //JPA는 인터페이스만 작성하면 런타임 시점에 따라서 Dynamic Proxy를 이용하여 객체를 동적으로 생성해줌

        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품"+i);
            item.setPrice(10000+i);
            item.setItemDetail("테스트 상품 상세 설명"+i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setLegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            //JPA는 인터페이스만 작성하면 런타임 시점에 따라서 Dynamic Proxy를 이용하여 객체를 동적으로 생성해줌
        }

        }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemList(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
        for(Item item : itemList){
            System.out.println(item.toString());

        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByNmOrItmDetailTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItenNmOrItemDetail("테스트 상품1", "테스트 상품 상세설명5");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemNmOrItemDetail() {
    this.createItemTest();
    List<Item> itemList= itemRepository.findByItenNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
    for(Item item : itemList){
        System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByPriceLessThanTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDesc(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

}