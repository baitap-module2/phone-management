package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController{
    @Autowired
    private SmartphoneService smartphoneService;

//    thêm
    @RequestMapping(value = ("/create"),method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/new-phone");
        modelAndView.addObject("sPhone", new Smartphone());
        return modelAndView;
    }

    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }
}
