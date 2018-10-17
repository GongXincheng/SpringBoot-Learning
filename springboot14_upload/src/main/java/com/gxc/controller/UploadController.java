package com.gxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传.
 *
 * @author 宫新程
 * @since 2018/10/16 15:20
 */
@Controller
public class UploadController {

  @GetMapping("/")
  public String index() {
    return "upload";
  }

  @PostMapping("/upload")
  public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {

    if (file.isEmpty()) {
      model.addAttribute("message", "Please select a file to upload");
      return "result";
    }

    // 创建文件夹
    File path = new File("E:\\upload");
    if (!path.exists()) {
      path.mkdirs();
    }
    try {
      file.transferTo(new File(path, file.getOriginalFilename()));
      model.addAttribute(
          "message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "result";
  }
}
