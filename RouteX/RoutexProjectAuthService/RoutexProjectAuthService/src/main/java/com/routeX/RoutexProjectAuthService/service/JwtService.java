package com.routeX.RoutexProjectAuthService.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService implements CommandLineRunner {
    @Value("${jwt.expiry}")
    private int expiry;//get value from application.prop
    @Value("${jwt.secret}")
    private String secret;

    //this method create a brand new jwt token based on corresponding playload
    private String createToken(Map<String,Object> payload,String username){
        //set expiry
        Date now=new Date();
        Date expiryDate=new Date(now.getTime()+ expiry*1000L);//convert this to ms

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().claims(payload)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiryDate)
                .subject(username) ////subject claim is passenger so username is subject
                .signWith(key)//signkey sha 256 and with secret
                .compact();//build jwt and serialize to compact url safe string
    }


    //to check over sercvice work
    @Override
    public void run(String... args) throws Exception {
        Map<String,Object>mp=new HashMap<>();
        mp.put("email","abc@.com");
        mp.put("phoneno","794789494");
        String result=createToken(mp,"sanket");
        System.out.println("Generated token"+result);
    }
}
