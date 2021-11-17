package test.appman.string2int.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/int/{input}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<IntServiceResponse> parseint(@PathVariable String input ) throws Exception{
        LOG.info("parseing Integer: "+ input);
        IntServiceResponse response = parseIntService.parseInt(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
