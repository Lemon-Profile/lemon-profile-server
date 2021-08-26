package com.lemon.lemonprofile.config;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Token Config Class
 */
@Data
@Service("tokenConfig")
public class TokenConfig {

//    private String ip = "192.168.30.198";
//    private String port = "6379";
    /**
     * secret
     */
    private String secret = "SiGk2e";
    /**
     * expirationTime
     */
    private String expirationTime = "86400000";
    /**
     * tokenPrefix
     */
    private String tokenPrefix = "Bearer ";
    /**
     * header
     */
    private String header = "Authorization";
    /**
     * authCode
     */
    private String authCode = "authCD";
}