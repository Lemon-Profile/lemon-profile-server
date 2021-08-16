package com.lemon.lemonprofile.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TbUserVo {
    private String USER_ID;
    private String USER_PASSWORD;
    private String EMAIL;
    private int AGE;
    private int WEIGHT;
    private int HEIGHT;
    private String SEX;
}
