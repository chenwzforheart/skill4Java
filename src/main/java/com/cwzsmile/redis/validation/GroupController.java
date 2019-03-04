package com.cwzsmile.redis.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by csh9016 on 2019/3/4.
 */
@RestController
public class GroupController {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@Validated @RequestBody AddAndUpdateIVO paramIVO, BindingResult binding) {
        if (binding.hasErrors()) {
            System.out.println(binding.getFieldError().getField() + ":" + binding.getFieldError().getDefaultMessage());
        }
        System.out.println("OK");
    }
}
