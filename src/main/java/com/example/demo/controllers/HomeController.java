package com.example.demo.controllers;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.node.ObjectNode;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/nojson")
    public String NoJson(){
        return "NoJson";
    }

    @ResponseBody
    @RequestMapping("/json")
    public TextToJson test(){
        return new TextToJson("Hector", "Marcos");
    }

    @ResponseBody
    @RequestMapping(path = "/json2", produces = "application/json")
    public String test2(){
        return "{\"page\": \"index.html\"}";
    }

    @ResponseBody
    @RequestMapping(path = "/json3")
    public ObjectNode index2(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("key", "value");
        objectNode.put("foo", "bar");
        objectNode.put("number", 42);
        return objectNode;
    }

    @ResponseBody
    @RequestMapping("/entity")
    public ResponseEntity<String> getGreetinWithResponseEntity(){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>("{\"test\": \"Hello with ResponseEntity\"}", httpHeaders, HttpStatus.OK);
    }
}
