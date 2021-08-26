package com.lemon.lemonprofile.service;

import com.lemon.lemonprofile.mapper.UserNutrientMapper;
import com.lemon.lemonprofile.model.TbUserNutrientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserNutrientService {
    @Autowired
    UserNutrientMapper userNutrientMapper;

    /**
     *
     * @param userId
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public List<TbUserNutrientVo> getUserNutrient(String userId, String startDate, String endDate) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date to = transFormat.parse(startDate);
        Date from = transFormat.parse(endDate);
        List<TbUserNutrientVo> tbUserNutrientVos = userNutrientMapper.getUserNutrient(userId, to, from);
        for(TbUserNutrientVo nutrientVo : tbUserNutrientVos) {
            System.out.println(nutrientVo);
        }
        return tbUserNutrientVos;
    }

    /**
     *
     * @param userId
     * @return
     */
    public TbUserNutrientVo getCurrentUserNutrient(String userId) {
        String current = currentDate();
        return userNutrientMapper.getCurrentUserNutrient(userId, current);
    }

    /**
     *
     * @param id
     * @param nutrientVo
     * @return
     */
    public Map addUserNutrient(String id, TbUserNutrientVo nutrientVo) {
        Map<String, Boolean> result = new HashMap<>();
        boolean isSaved = false;
        Map<String, Object> param = new HashMap<>();
        param.put("USER_ID", id);
        param.put("DATE", currentDate());
        param.put("CALORIE", nutrientVo.getCALORIE());
        param.put("CARBOHYDRATE", nutrientVo.getCARBOHYDRATE());
        param.put("FAT", nutrientVo.getFAT());
        param.put("MAGNESIUM", nutrientVo.getMAGNESIUM());
        param.put("VITAMIN_A", nutrientVo.getVITAMIN_A());
        param.put("VITAMIN_B", nutrientVo.getVITAMIN_B());
        param.put("VITAMIN_C", nutrientVo.getVITAMIN_C());
        param.put("CALCIUM", nutrientVo.getCALCIUM());
        param.put("OMEGA_3", nutrientVo.getOMEGA_3());
        if(userNutrientMapper.addUserNutrient(param)>0) {
            isSaved = true;
        }
        result.put("success", isSaved);
        return result;
    }

    public Map setCurrentNutrient(String id, TbUserNutrientVo nutrientVo) {
        Map<String, Boolean> result = new HashMap<>();
        TbUserNutrientVo currentNutrient = getCurrentUserNutrient(id);
        if(currentNutrient!=null) {
            Map<String, Object> param = new HashMap<>();
            param.put("USER_ID", id);
            param.put("DATE", currentDate());
            param.put("CALORIE", nutrientVo.getCALORIE()+currentNutrient.getCALORIE());
            param.put("CARBOHYDRATE", nutrientVo.getCARBOHYDRATE()+currentNutrient.getCARBOHYDRATE());
            param.put("FAT", nutrientVo.getFAT()+currentNutrient.getFAT());
            param.put("MAGNESIUM", nutrientVo.getMAGNESIUM()+currentNutrient.getMAGNESIUM());
            param.put("VITAMIN_A", nutrientVo.getVITAMIN_A()+currentNutrient.getVITAMIN_A());
            param.put("VITAMIN_B", nutrientVo.getVITAMIN_B()+currentNutrient.getVITAMIN_B());
            param.put("VITAMIN_C", nutrientVo.getVITAMIN_C()+currentNutrient.getVITAMIN_C());
            param.put("CALCIUM", nutrientVo.getCALCIUM()+currentNutrient.getCALCIUM());
            param.put("OMEGA_3", nutrientVo.getOMEGA_3()+currentNutrient.getOMEGA_3());
            if(userNutrientMapper.setCurrentNutrient(param)>0) {
                result.put("success", true);
            }else {
                result.put("success", false);
            }
        }else {
            return addUserNutrient(id, nutrientVo);
        }
        return result;
    }

    public String currentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String current = currentDateTime.format(formatter);
        return current;
    }

}
