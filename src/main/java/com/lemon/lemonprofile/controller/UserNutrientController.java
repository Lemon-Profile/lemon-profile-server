package com.lemon.lemonprofile.controller;

import com.lemon.lemonprofile.model.TbUserNutrientVo;
import com.lemon.lemonprofile.service.UserNutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class UserNutrientController {
    @Autowired
    UserNutrientService userNutrientService;

    /**
     * 영양 정보 통계 가져오기
     * @param userId
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    @GetMapping("/nutrient")
    public List<TbUserNutrientVo> getUserNutrientById(@RequestParam("id") String userId,@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException {
        return userNutrientService.getUserNutrient(userId, startDate, endDate);
    }

    /**
     * 오늘의 영양 정보 가져오기
     * @param userId
     * @return
     */
    @GetMapping("/nutrient/current")
    public TbUserNutrientVo getCurrentUserNutrient(@RequestParam("id") String userId) {
        return userNutrientService.getCurrentUserNutrient(userId);
    }

    /**
     * 오늘 영양 정보 추가
     * @param id
     * @param nutrientVo
     * @return
     */
    @PostMapping("/nutrient/{id}")
    public Map setCurrentNutrient(
            @PathVariable String id,
            @RequestBody TbUserNutrientVo nutrientVo
    ) {
        return userNutrientService.setCurrentNutrient(id, nutrientVo);
    }


}
