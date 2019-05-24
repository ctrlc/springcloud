package com.sa.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trace2Controller {
    Logger logger = LoggerFactory.getLogger(Trace2Controller.class);

    @RequestMapping(value = "trace-2", method = RequestMethod.GET)
    public String trace(){
        logger.info("call --> trace-2");
        return "Trace";
    }

}
