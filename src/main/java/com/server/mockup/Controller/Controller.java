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
    public ResponseEntity<LinkedHashMap<String, Object>> admitController(String hospital_id, String data) throws IOException {
        logger.info(" ");
        logger.info("/example/api/admit");
        return service.admitService(hospital_id, data);
    }

    @PostMapping("/discharge")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, Object>> dischargeController(String hospital_id, String data) throws IOException {
        logger.info(" ");
        logger.info("/example/api/discharge");
        return service.dischargeService(hospital_id, data);
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
    public ResponseEntity<LinkedHashMap<String, Object>> orderController(String hospital_id, String data) throws IOException {
        logger.info(" ");
        logger.info("/example/api/order");
        return service.orderService(hospital_id, data);
    }

    @GetMapping("/summary")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> summaryController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/summary");
        return service.summaryService();
    }
}
