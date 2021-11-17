package test.appman.string2int.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.appman.string2int.model.InputRequestDTO;
import test.appman.string2int.model.IntServiceResponse;
import test.appman.string2int.service.ParseIntServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/parse")
public class ParseIntController {

    public static final Logger LOG = LoggerFactory.getLogger(ParseIntController.class);
    private ParseIntServiceImpl parseIntService;

    @Autowired
    public ParseIntController(ParseIntServiceImpl parseIntService) {
        this.parseIntService = parseIntService;
    }

    @GetMapping("/int/{input}")
    public @ResponseBody ResponseEntity<IntServiceResponse> parseint(@PathVariable String request ) throws Exception{
        LOG.info("parseing Integer");
        LOG.warn("input: " + request);
        IntServiceResponse response = parseIntService.parseInt(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
