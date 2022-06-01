package com.example.naverrestaurant.wishlist.dto;


import com.example.naverrestaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto {
    private int index;
    private String title;   //음식명 장소명
    private String category; // 카테고리
    private String address;  //주소
    private String readAddress;//
    private String homepageAddress; //홈페이지 주소
    private String imageLink; // 이미지 주소
    private boolean isVisit; // 방문여부
    private int visitCount;
    private LocalDateTime lastVisitDate;


}
