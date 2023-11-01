package com.server.mockup.Service;

import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.server.mockup.Utility.Utility;

@Service
public class MyService {
    Logger logger = LogManager.getLogger(MyService.class);

    public ResponseEntity<LinkedHashMap<String, Object>> admitService(String hospital_id, String data) throws IOException {
        LinkedHashMap<String, Object> list = null;
        try {
            List<Map<String, Object>> jsonData = Utility.StringToMap(data);

            if(list == null){
                list = new LinkedHashMap<String, Object>();
            }

            list.put("hospital_id", hospital_id);
            list.put("data", jsonData);

            logger.info("\nresponse [" + HttpStatus.OK.value() + "] : " );

            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] : ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<LinkedHashMap<String, Object>> dischargeService(String hospital_id, String data) throws IOException {
        LinkedHashMap<String, Object> list = null;
        try{
            List<Map<String, Object>> jsonData = Utility.StringToMap(data);

            if(list == null){
                list = new LinkedHashMap<String, Object>();
            }

            list.put("hospital_id", hospital_id);
            list.put("data", jsonData);

            logger.info("\nafter convert: " + jsonData);

            logger.info("\nresponse [" + HttpStatus.OK.value() + "] : " );
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch(Exception e){
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] : ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }    
    }

    public ResponseEntity<LinkedHashMap<String, String>> monitorInterfaceService() throws IOException {
        LinkedHashMap<String, String> list = new LinkedHashMap<>();
        try{
            logger.info("response [" + HttpStatus.OK.value() + "] : ");
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch(Exception e){
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] : ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    public ResponseEntity<LinkedHashMap<String, String>> orderService() throws IOException {
        LinkedHashMap<String, String> list = new LinkedHashMap<>();
        try{
            logger.info("response [" + HttpStatus.OK.value() + "] : ");
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch(Exception e){
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] + ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public ResponseEntity<LinkedHashMap<String, String>> summaryService() throws IOException {
        LinkedHashMap<String, String> list = new LinkedHashMap<>();
        try{
            logger.info("response [" + HttpStatus.OK.value() + "] : ");
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch(Exception e){
            e.printStackTrace();
            logger.info(" , response [" + HttpStatus.INTERNAL_SERVER_ERROR.value() + "] + ");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
