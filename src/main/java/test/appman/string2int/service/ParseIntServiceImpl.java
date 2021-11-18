package test.appman.string2int.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.appman.string2int.model.IntServiceResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ParseIntServiceImpl implements ParseIntService{

    public static final Logger LOG = LoggerFactory.getLogger(ParseIntServiceImpl.class);

    @Override
    public IntServiceResponse parseInt(String input) {

        int num = 0;
        int degit = 0;
        List integers = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        HashMap<Character,Integer> hashCharToInt = new HashMap<Character,Integer>();
        hashCharToInt.put('0',0);
        hashCharToInt.put('1',1);
        hashCharToInt.put('2',2);
        hashCharToInt.put('3',3);
        hashCharToInt.put('4',4);
        hashCharToInt.put('5',5);
        hashCharToInt.put('6',6);
        hashCharToInt.put('7',7);
        hashCharToInt.put('8',8);
        hashCharToInt.put('9',9);



//        irritating backward from string input
        for (int i = input.length()-1; i >= 0; i--) {
            char letter = input.charAt(i);
//            check character is integer
            if(integers.contains(letter)){
//                calculate integer eg. 123 = 1*100 + 2*10 + 3*1
                int pow = 1;
                for (int j = 0; j < degit; j++) {
                     pow *= 10;
                }
                num += pow * hashCharToInt.get(letter);
                degit++;
            }
        }
        IntServiceResponse intServiceResponse = new IntServiceResponse(num);
        return intServiceResponse;
    }
}
