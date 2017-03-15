package com.shengxin.controller;

import com.shengxin.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenshengxin on 2017/3/10.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;
    
    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "id: " + id;
    }
}
