package com.server.mockup.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    Logger logger = LogManager.getLogger(MyService.class);

    public ResponseEntity<LinkedHashMap<String, Object>> admitService() throws IOException {

        LinkedHashMap<String, Object> list = new LinkedHashMap<>();

        try {
            logger.info("response [" + HttpStatus.OK.value() + "] : ");
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] : ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
