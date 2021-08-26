package com.lemon.lemonprofile.service;

import com.lemon.lemonprofile.mapper.UserFoodImageMapper;
import com.lemon.lemonprofile.model.TbUserFoodImageReqVo;
import com.lemon.lemonprofile.model.TbUserFoodImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFoodImageService {
    @Autowired
    UserFoodImageMapper userFoodImageMapper;

    public List<TbUserFoodImageVo> getFoodImages(String userId) {
        return userFoodImageMapper.getFoodImages(userId);
    }

    public Map addFoodImage(TbUserFoodImageReqVo userFoodImageVo) {
        Map<String, Boolean> result = new HashMap<>();
        if(userFoodImageMapper.addFoodImage(userFoodImageVo.getINTAKE_DT(), userFoodImageVo.getIMG_SRC())>0) {
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }

    public Map deleteFoodImage(String userId, String imgSrc) {
        Map<String, Boolean> result = new HashMap<>();
        if(userFoodImageMapper.deleteFoodImage(userId, imgSrc)>0) {
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        return result;
    }
}
