package com.gxc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 宫新程
 * @since 2018/10/16 15:51
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MultipartException.class)
  public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
    return "redirect:/uploadStatus";
  }

}
