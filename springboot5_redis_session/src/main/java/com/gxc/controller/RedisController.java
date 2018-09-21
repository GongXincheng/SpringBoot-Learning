package com.gxc.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author 宫新程
 * @since 2018/09/21 16:50
 */
@Controller
public class RedisController {

  @RequestMapping(value = "/setSession", method = RequestMethod.GET)
  public Map<String, Object> setSession(HttpServletRequest request) {
    Map<String, Object> map = new HashMap<>();
    request.getSession().setAttribute("request Url", request.getRequestURL());
    map.put("request Url", request.getRequestURL());
    return map;
  }
}
