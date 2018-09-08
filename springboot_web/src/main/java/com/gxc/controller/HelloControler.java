package com.gxc.controller;

import com.gxc.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.validation.Valid;

/**
 * 测试SpringBoot的Web项目.
 *
 * @author 宫新程
 * @date 2018/9/6 13:22
 */
@Controller
public class HelloControler {

  private static final String TEST_PAGE = "testPage";
  private static final Logger log = LoggerFactory.getLogger(HelloControler.class);

  @RequestMapping(
      value = "/delete/{userId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String test1(@PathVariable String userId) {
    log.debug("要删除的用户Id：{}", userId);
    return "Hello World " + userId;
  }

  @RequestMapping("/page")
  public String testPage(Model model) {
    model.addAttribute("hello", "Hello World");
    return TEST_PAGE;
  }

  /**
   * 信息验证.
   * @param user 用户信息
   * @param bindingResultr BindingResult
   * @param model Model
   * @return testPage
   */
  @RequestMapping("/check")
  public String checkDate(@Valid User user, BindingResult bindingResultr,
                          Model model) {
    log.debug("用户信息：{}", user);
    // 判断用户信息是否符合要求
    if (bindingResultr.hasErrors()) {
      List<ObjectError> errors = bindingResultr.getAllErrors();
      for (ObjectError error : errors) {
        model.addAttribute("msg",error.getDefaultMessage());
        return TEST_PAGE;
      }
    }
    log.debug("成功！");
    return TEST_PAGE;
  }
}
