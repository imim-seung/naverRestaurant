package com.example.naverrestaurant.naver.service;

import com.example.naverrestaurant.naver.NaverClient;
import com.example.naverrestaurant.naver.dto.SearchImageReq;
import com.example.naverrestaurant.naver.dto.SearchLocalReq;
import com.example.naverrestaurant.wishlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;
    public WishListDto search(String query){

        //지역검색
        var searchLocalReq=new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes=naverClient.searchLocal(searchLocalReq);

        if (searchLocalRes.getTotal()>0){
            var localItem=searchLocalRes.getItems().stream().findFirst().get();
            var imageQuery=localItem.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq=new SearchImageReq();
            searchImageReq.setQuery(imageQuery);
            //이미지 검색
            var searchImageRes=naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal()>0){
                var imageItem=searchImageRes.getItems().stream().findFirst().get();
                //결과를 리턴
                var result=new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setReadAddress(localItem.getRoadAddress());
                result.setHomepageAddress(localItem.getLink());
                result.setImageLink(imageItem.getLink());
                return result;

            }
        }
        return new WishListDto();
    }
}
