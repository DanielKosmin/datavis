package com.kosmin.datavis.service;

import static com.kosmin.datavis.util.DatavisUtil.extractUsername;

import com.kosmin.datavis.model.Response;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class DatavisService {

  public ResponseEntity<Response> processCsv(MultipartFile file, Map<String, String> httpHeaders) {
    String username = extractUsername(httpHeaders);
    MDC.put("username", username);
    log.info("Processing CSV file");
    return ResponseEntity.ok(new Response());
  }
}
