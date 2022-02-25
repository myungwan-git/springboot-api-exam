package yes.exam.api.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import yes.exam.api.data.DataSet;

@Slf4j
@Controller
public class ResponseEntityExam {

  @PostMapping("api-call")
  public ResponseEntity<MultiValueMap<String, String>> responseApi(@RequestBody DataSet dataSet) {
    HttpHeaders httpHeaders = new HttpHeaders();

    String name = dataSet.getName();
    int age = dataSet.getAge();
    dataSet.setName(name + "api-call");
    dataSet.setAge(age + 100);
    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
    multiValueMap.add("A", "AAA");
    multiValueMap.add("B", "BBB");
    multiValueMap.add("C", "CCC");

    ResponseEntity<MultiValueMap<String, String>> responseEntity =
        new ResponseEntity<MultiValueMap<String, String>>(multiValueMap, httpHeaders, HttpStatus.OK);

    return responseEntity;
  }

  @PostMapping("request-json-response-object")
  public ResponseEntity<DataSet> responseObject(@RequestBody DataSet dataSet) {
    return new ResponseEntity<DataSet>(dataSet,HttpStatus.OK);
  }

}
