package com.server.mockup.Controller;

import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.server.mockup.Service.MyService;

@CrossOrigin
@RestController
@RequestMapping("/example/api")
@Validated
public class Controller {

    @Autowired
    MyService service;

    Logger logger = LogManager.getLogger(Controller.class);
    @PostMapping("/admit")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> admitController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/admit");
        return service.admitService();
    }
    @PostMapping("/discharge")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> dischargeController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/discharge");
        return service.dischargeService();
    }
    @PostMapping("/monitorInterface")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> monitorInterfaceController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/monitorInterface");
        return service.monitorInterfaceService();
    }
    @PostMapping("/order")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> orderController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/order");
        return service.orderService();
    }
    @GetMapping("/summary")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> summaryController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/summary");
        return service.summaryService();
    }
}
