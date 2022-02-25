package yes.exam.api.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yes.exam.api.data.DataSet;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class HttpEntityExam {
  private ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("request-http-entity")
  public HttpEntity<String> requestHttpEntity(HttpEntity<String> httpEntity) {
    String httpEntityBody = httpEntity.getBody();
    HttpHeaders headers = httpEntity.getHeaders();
    log.info(">>> headers = {}", headers);
    log.info(">>> httpEntityBody = {}", httpEntityBody);

    return new HttpEntity<>("OK");
  }



}
