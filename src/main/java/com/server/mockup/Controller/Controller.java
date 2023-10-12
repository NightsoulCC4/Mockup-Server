package com.server.mockup.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<LinkedHashMap<String, Object>> admitController() throws IOException {
        logger.info(" ");
        logger.info("/example/api/admit");

        // return ResponseEntity.status(HttpStatus.OK).body(new LinkedHashMap<>());
        return service.admitService();
    }
}
