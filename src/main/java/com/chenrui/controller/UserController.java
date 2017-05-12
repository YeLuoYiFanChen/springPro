package com.chenrui.controller;

import com.chenrui.entity.TbUser;
import com.chenrui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public void index(Model model,String username) {
        model.addAttribute("users", userService.getAllTbUsers());
    }

    @RequestMapping("/detail")
    public void detail(Model model,Integer id) {
        model.addAttribute("map", userService.getUserForMap(id));
        model.addAttribute("user", userService.findUserById(id));
    }

    @RequestMapping("/edit")
    public void edit(Model model, Integer id) {
       if(id!=null){
           model.addAttribute("user", userService.findUserById(id));
       }else {
           model.addAttribute("user",new TbUser());
       }
    }

    @RequestMapping("/save")
    public String save(Model model, TbUser tbUser) {
        userService.save(tbUser);
        return "redirect:/index.do";
    }

    @RequestMapping("/delete")
    public String index(Model model,Integer id) {
        userService.delete(id);
        return "redirect:/index.do";
    }
}
