package com.kosmin.datavis.util;

import java.util.Map;
import java.util.Optional;

public class DatavisUtil {

  public static String extractUsername(Map<String, String> httpHeaders) {
    return Optional.ofNullable(httpHeaders)
        .map(headers -> headers.get("x-username"))
        .orElseThrow(() -> new RuntimeException("No X-Username header found"));
  }
}
