package game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class GameController {

    private static int n = 5;
    private static NumbersLibrary numbersLibrary;
    private static ArrayList<String> tempNumbers;
    private static char[] current;
    private static char[] secret;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getNumber(){
        numbersLibrary = new NumbersLibrary(n);
        tempNumbers = new ArrayList<String>();
        return new ModelAndView("start");
    }

    @RequestMapping(value = "/guessfirst", method = RequestMethod.GET)
    public ModelAndView guessStart(){
        current = numbersLibrary.random();
        tempNumbers.add(String.valueOf(current));
        return new ModelAndView("guess", "numbers", tempNumbers);
    }

    @RequestMapping(value = "/guess", method = RequestMethod.GET)
    public ModelAndView bullsCows(@RequestParam(value = "bullsCows") String bullsCows){
        tempNumbers.add(String.valueOf(bullsCows));
        if (Integer.parseInt(bullsCows) == n) {
            return new ModelAndView("won", "numbers", tempNumbers);

        } else {
            numbersLibrary.clean(current, bullsCows.toCharArray());
            current = numbersLibrary.random();
            tempNumbers.add(String.valueOf(current));
        }
        return new ModelAndView("guess", "numbers", tempNumbers);
    }

    @RequestMapping(value = "/riddlefirst", method = RequestMethod.GET)
    public ModelAndView secret(){
        secret = numbersLibrary.random();
        tempNumbers.add(String.valueOf(secret));
        return new ModelAndView("riddle", "secret", tempNumbers);
    }

    @RequestMapping(value = "/riddle", method = RequestMethod.GET)
    public ModelAndView getNumber(@RequestParam(value = "number") String number){
        tempNumbers.add(number);
        tempNumbers.add(String.valueOf(numbersLibrary.calc(secret, number.toCharArray())));
        if (numbersLibrary.calc(secret, number.toCharArray())[1] == n + 48)
            return new ModelAndView("won", "numbers", tempNumbers);
        return new ModelAndView("riddle", "numbers", tempNumbers);
    }

    @RequestMapping(value = "/apiriddle", method = RequestMethod.GET)
    public ModelAndView getNumberApi(@RequestParam(value = "number") String number){
        String s = String.valueOf(numbersLibrary.calc(secret, number.toCharArray()));
        return new ModelAndView("api", "api", s);
    }

}
