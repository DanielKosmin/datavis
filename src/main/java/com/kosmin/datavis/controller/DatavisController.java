package com.kosmin.datavis.controller;

import com.kosmin.datavis.model.Response;
import com.kosmin.datavis.service.DatavisService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("datavis/v1")
@Slf4j
@RequiredArgsConstructor
public class DatavisController {

  private final DatavisService datavisService;

  @PostMapping("schema")
  public ResponseEntity<Response> postSchema(
      @RequestParam("file") MultipartFile file, @RequestHeader Map<String, String> headers) {
    return datavisService.processCsv(file, headers);
  }
}
