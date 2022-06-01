package com.example.naverrestaurant.naver;

import com.example.naverrestaurant.naver.dto.SearchImageReq;
import com.example.naverrestaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest
public class NaverClientTest {
    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest(){
    var search=new SearchLocalReq();
    search.setQuery("만두집");

    var result=naverClient.searchLocal(search);

    System.out.println("결과");
    System.out.println(result);
    }

    @Test
    public void searchImageTest(){
        var search=new SearchImageReq();
        search.setQuery("만두");

        var result=naverClient.searchImage(search);
        System.out.println("이미지 결과 ");
        System.out.println(result);

    }
}
