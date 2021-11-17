package test.appman.string2int.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.appman.string2int.model.IntServiceResponse;

@Service
public class ParseIntServiceImpl implements ParseIntService{

    public static final Logger LOG = LoggerFactory.getLogger(ParseIntServiceImpl.class);

    @Override
    public IntServiceResponse parseInt(String input) {

        String StringReplace = input.replaceAll("[^0-9]", "");
        LOG.info("String Replace: " + StringReplace);
        IntServiceResponse intServiceResponse = new IntServiceResponse(StringReplace);
        return intServiceResponse;
    }
}
