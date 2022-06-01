package com.example.naverrestaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;

    private List<SearchImageItem> items;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem{
        private String title;
        private String link;
        private String thumbnail;
        private String telephone;
        private String sizeheight;
        private String sizewidth;


    }
}
