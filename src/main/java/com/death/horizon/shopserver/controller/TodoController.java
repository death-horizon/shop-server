package com.death.horizon.shopserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author dayday
 */
@RestController
@RequestMapping("")
@Slf4j
public class TodoController {

    @GetMapping("todo")
    public String todo() {
        log.info("xxx");
        return "test";
    }
}
