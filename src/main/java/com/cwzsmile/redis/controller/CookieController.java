package com.cwzsmile.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/10/2 0002.
 */
@RestController
public class CookieController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/test/cookie",method = {RequestMethod.GET,RequestMethod.POST})
    public String cookie(
            HttpServletRequest  request,
            HttpServletResponse response,
            HttpSession session) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            Arrays.stream(cookies).forEach(
                    (cookie) ->
                            logger.info(cookie.getName() + " : " + cookie.getValue()));
        }
        response.addCookie(new Cookie("key","value"));
        return "index";
    }
    @RequestMapping(value = "/test/cookie1",method = {RequestMethod.GET,RequestMethod.POST})
    public String cookie1( HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return "index";
    }

}
