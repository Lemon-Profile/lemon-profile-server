package com.lemon.lemonprofile.service.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lemon.lemonprofile.config.TokenConfig;
import com.lemon.lemonprofile.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * JwtTokenService class
 */
@Service("jwtTokenService")
public class JwtTokenService {
    /**
     * config
     */
    @Autowired
    TokenConfig config;
    /**
     * getToken
     * @param request request
     * @return String
     */
    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(this.config.getHeader());
        if(token==null){
            CookieUtil co;
            CookieUtil.getValue(request, "token");
            token = CookieUtil.getValue(request, "token");
        }
        return token;
    }

    /**
     * getTokenBySessionId
     * @param sessionId sessionId
     * @return String
     */
    public String getTokenBySessionId(final String sessionId){ return null; }

    /**
     * isValid
     * @param request request
     * @return boolean
     * @throws JWTVerificationException
     */
    public boolean isValid(HttpServletRequest request) throws JWTVerificationException{
        String token = getToken(request);
        if(token == null ){
            return false;
        }else{
            return (!isTokenExpired(request) && getUserName(request) != null);
        }
    }

    /**
     * getAuthCode
     * @param request request
     * @return String
     */
    public String getAuthCode(HttpServletRequest request){
        String token = getToken(request);
        if(token == null){
            return null;
        }
        return JWT.require(Algorithm.HMAC512(this.config.getSecret().getBytes()))
                .build()
                .verify(token.replace(this.config.getTokenPrefix(), ""))
                .getClaim(config.getAuthCode())
                .asString();
    }

    /**
     * isTokenExpired
     * @param request request
     * @return Boolean
     * @throws JWTVerificationException
     */
    private Boolean isTokenExpired(HttpServletRequest request)  throws JWTVerificationException {
        String token = getToken(request);

        Date expiration =  JWT.require(Algorithm.HMAC512(this.config.getSecret().getBytes()))
                .build()
                .verify(token.replace(this.config.getTokenPrefix(), ""))
                .getExpiresAt();
        return expiration.before(new Date());
    }

    /**
     * getUserName
     * @param request request
     * @return String
     */
    public String getUserName(HttpServletRequest request){
        String token = getToken(request);
        if(token == null){
            return null;
        }

        return JWT.require(Algorithm.HMAC512(this.config.getSecret().getBytes()))
                .build()
                .verify(token.replace(this.config.getTokenPrefix(), ""))
                .getSubject();
    }
}
