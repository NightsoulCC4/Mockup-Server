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
    @PostMapping("/test")
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, Object>> testController(@RequestParam("patient_id") String patient_id, @RequestParam("image_file_name") String image_file_name, @RequestParam("scan_id") String scan_id, @RequestParam("scan_spid") String scan_spid, @RequestParam("scan_date") String scan_date, @RequestParam("scan_time") String scan_time, @RequestParam("folder_name") String folder_name, @RequestParam("base64") String base64) throws IOException {
        logger.info(" ");
        logger.info("/example/api/test");

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("patient_id", patient_id);
        map.put("image_file_name", image_file_name);
        map.put("scan_id", scan_id);
        map.put("scan_spid", scan_spid);
        map.put("scan_date", scan_date);
        map.put("scan_time", scan_time);
        map.put("folder_name", folder_name);
        map.put("base64", base64);

        for(int i = 0 ; i < base64.length() ;i++)
            System.out.println("Line " + i + ": " + base64.charAt(i));

        // return ResponseEntity.status(HttpStatus.OK).body(new LinkedHashMap<>());
        return service.testService(map);
    }
}
