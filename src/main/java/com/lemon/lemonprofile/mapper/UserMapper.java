package com.lemon.lemonprofile.mapper;

import com.lemon.lemonprofile.model.TbUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<TbUserVo> getUser();
}
