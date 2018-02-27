package com.glf.test.glftest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHomePage(Model model) {
        return "index";
    }

}
