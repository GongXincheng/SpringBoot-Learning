package com.gxc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.gxc.controller.HelloControler;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 测试类
 *
 * @author 宫新程
 * @date 2018/9/6 13:34
 */
public class MyTest {

  private final String PASSWROD = "password";
  private MockMvc mockMvc;

  @Before
  public void init() {
    mockMvc = MockMvcBuilders.standaloneSetup(new HelloControler()).build();
  }

  @Test
  public void test1() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/delete/88")).andDo(print());
  }

  @Test
  public void testCheckDate() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/check")
                        .param(PASSWROD,"admin")
                        .param("age","1")).andDo(print());
  }
}
