package yes.exam.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yes.exam.api.data.DataSet;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JsonToObject {

  private final ObjectMapper objectMapper;

  @PostMapping("request-json")
  public void requestHttpEntityJson(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ServletInputStream inputStream = request.getInputStream();
    String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
    DataSet dataSet = objectMapper.readValue(message, DataSet.class);

    log.info(">>> DataSet : name = {}, age = {}", dataSet.getName(), dataSet.getAge());

    response.getWriter().write("OK");
  }

  @PostMapping("request-json-requestbody")
  public void requestBodyJson(@RequestBody DataSet dataSet){
    log.info("DataSet : name = {}, age = {}", dataSet.getName(), dataSet.getAge());
  }

  @PostMapping("request-json-requestbody-responsebody")
  public DataSet requestBodyJsonResponse(@RequestBody DataSet dataSet){
    log.info("DataSet : name = {}, age = {}", dataSet.getName(), dataSet.getAge());

    DataSet set = new DataSet();
    set = dataSet;

    return set;
  }

}
