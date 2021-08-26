package com.lemon.lemonprofile.mapper;

import com.lemon.lemonprofile.model.TbUserFoodImageVo;
import com.lemon.lemonprofile.model.TbUserNutrientVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserFoodImageMapper {
    /**
     *
     * @param userId
     * @return
     */
    List<TbUserFoodImageVo> getFoodImages(@Param("USER_ID") String userId);

    /**
     *
     * @param INTAKE_DT
     * @param IMG_SRC
     * @return
     */
    int addFoodImage(String INTAKE_DT, String IMG_SRC);

    /**
     *
     * @param USER_ID
     * @param IMG_SRC
     * @return
     */
    int deleteFoodImage(String USER_ID, String IMG_SRC);
}
