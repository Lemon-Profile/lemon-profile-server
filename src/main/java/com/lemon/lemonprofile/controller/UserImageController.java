package com.lemon.lemonprofile.controller;

import com.lemon.lemonprofile.model.TbUserFoodImageReqVo;
import com.lemon.lemonprofile.model.TbUserFoodImageVo;
import com.lemon.lemonprofile.model.TbUserNutrientVo;
import com.lemon.lemonprofile.service.UserFoodImageService;
import com.lemon.lemonprofile.service.UserNutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class UserImageController {
    @Autowired
    UserFoodImageService userFoodImageService;

    @GetMapping("/foods/images")
    public List<TbUserFoodImageVo> getUserNutrientById(@RequestParam("id") String userId) throws ParseException {
        return userFoodImageService.getFoodImages(userId);
    }

    @PostMapping("/foods/images")
    public Map addFoodImages(@RequestParam("id") String userId, @RequestBody TbUserFoodImageReqVo userFoodImageVo) {
        return userFoodImageService.addFoodImage(userFoodImageVo);
    }

    @DeleteMapping("/foods/images")
    public Map deleteFoodImages(@RequestParam("id") String userId, @RequestBody String imgSrc) {
        return userFoodImageService.deleteFoodImage(userId, imgSrc);
    }
}
