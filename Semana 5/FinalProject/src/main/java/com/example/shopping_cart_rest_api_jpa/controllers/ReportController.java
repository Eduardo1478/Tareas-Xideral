package com.example.shopping_cart_rest_api_jpa.controllers;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private static final String REPORT_PATH = "sales_report.csv"; // Path where the file is stored

    @GetMapping("/downloadSalesReport")
    public ResponseEntity<FileSystemResource> downloadSalesReport() {
        File file = new File(REPORT_PATH);
        if (!file.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        FileSystemResource resource = new FileSystemResource(file);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
