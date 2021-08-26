package com.lemon.lemonprofile.mapper;

import com.lemon.lemonprofile.model.TbUserNutrientVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserNutrientMapper {

    List<TbUserNutrientVo> getUserNutrient(@Param("USER_ID") String userId, @Param("TO_DATE") Date to, @Param("FROM_DATE") Date from);

    TbUserNutrientVo getCurrentUserNutrient(@Param("USER_ID") String userId, @Param("DATE") String current);

    int addUserNutrient(Map<String, Object> param);

    int setCurrentNutrient(Map<String, Object> param);
}
