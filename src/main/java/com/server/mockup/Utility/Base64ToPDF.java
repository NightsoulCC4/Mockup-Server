package com.server.mockup.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public final class Base64ToPDF {

    public static Boolean convertBase64ToPDF(String param, String image_file_name) throws IOException {
        // byte[] pdfBytes = readPdfFile(pdfFilePath);

        System.out.println(image_file_name);
        try {
            byte[] decodedPDF = DatatypeConverter.parseBase64Binary(param);
            Path destinationFile = Paths.get("C:/src/json/", image_file_name);
            Files.write(destinationFile, decodedPDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
