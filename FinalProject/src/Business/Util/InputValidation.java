/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zhaoxi
 */
public class InputValidation {
    
    public static boolean isValidName(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Z][a-z]+$";//name starting with a upper case
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[aA-zZ])" + ".{5,}$";
        //JOptionPane.showMessageDialog(null, "Password should be at least 5 digits, with at least one letter and one digit");
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    public static boolean isValidNumber(String number) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[1-9][0-9]*$";//number not start with 0
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
      
    public static boolean isValidZipCode(String number) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{5}$";//5 digits number
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String number) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{10}$";//10 digits phone number
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }

}
