package com.server.mockup.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.server.mockup.Utility.Base64ToPDF;

@Service
public class MyService {
    Logger logger = LogManager.getLogger(MyService.class);

    public ResponseEntity<LinkedHashMap<String, Object>> testService(HashMap<String, Object> map) throws IOException {
        System.out.println(map.get("base64").toString().length());

        LinkedHashMap<String, Object> list = new LinkedHashMap<>();

        list.put("status", "success.");
        list.put("message", "test sucessful.");
        list.put("base64", map.get("base64").toString());

        Base64ToPDF.convertBase64ToPDF((String) map.get("base64"),(String) map.get("image_file_name"));

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
