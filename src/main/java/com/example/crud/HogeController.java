package com.example.crud;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HogeController {

  @Autowired
  HogeService service;

  @ModelAttribute
    public HogeForm form() {
      return new HogeForm();
    }

  @RequestMapping("/")
  public String hoge() {
    return "hoge";
  }

  //データの登録
  @RequestMapping("/save")
  public String saveHoge(HogeForm form){
    service.save(form);
    return "redirect:/";
  }

  //idの検索
  @RequestMapping("/findById")
  public String findbyId(Integer id, Model model) {
    List <Hoge> findById=service.findById(id);
    model.addAttribute("findById", findById);
    return "findById";
  }
}
