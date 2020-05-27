package com.easywaldo.book.springboot.web;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
public class AuthController {
    @GetMapping("/member/login")
    public String Login(HttpServletResponse response) throws UnsupportedEncodingException {

        String jwt = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
                .setExpiration(new Date(2020, 6, 1))
                .claim("name", "hello_man")
                .claim("scope", "self groups/admins")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes("UTF-8")
                )
                .compact();

        Cookie cookie = new Cookie("userJwt", jwt);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return "login success";
    }

    @GetMapping("/member/auth")
    public String AuthMember(
            @CookieValue(value = "userJwt", defaultValue = "") String jwtTokenString) throws UnsupportedEncodingException {

        Claims claims = Jwts.parser()
                .setSigningKey("secret".getBytes("UTF-8"))
                .parseClaimsJws(jwtTokenString)
                .getBody();

        String scope = claims.get("scope", String.class);
        String name = claims.get("name", String.class);

        if (name.equals("hello_man")) {
            return "success";
        }
        return "fail";
    }
}
