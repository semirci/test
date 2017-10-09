package com.emirci.envanter.controller;

import com.emirci.envanter.service.MessageByLocaleService;
import com.emirci.envanter.service.impl.MessageByLocaleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Createdss by serdaremirci on 9/18/17.
 */
@Controller

public class HomeController extends AbstractController {

    @Inject
    MessageByLocaleServiceImpl messageByLocaleService;



    @GetMapping("/home")
    public String home() {
        return "/home1";
    }

    
    
    
    @GetMapping("/about")
    public String about() {
        return "/about1";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


    public String home(@RequestParam(value = "nam1e", required = false, defaultValue = "Wprld") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = {"/welcome"})
    public String welcome(@RequestHeader("Accept-Language") Locale locale) {

        String msg =  messageByLocaleService.getMessage("welcome");

        return "welcome";
    }

    //https://github.com/reylibutan/hrms

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "merhaba controller");
        return model;
    }
}
