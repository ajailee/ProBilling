/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ajai Lee
 */
public class InputValidate {

    public static void validateNumber(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_ENTER)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    public static void validateDecimalnumber(KeyEvent evt) {

        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_ENTER)
                || (c == KeyEvent.VK_PERIOD)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    public static boolean validatePhoneNumber(String s) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        Matcher m = p.matcher(s);
        if (!(m.matches())) {
            return false;
        }

        return true;
    }
    
    public static void validatePincode(KeyEvent evt,String pincode){
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_ENTER)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)) || pincode.length()>5) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    public static boolean validateEmail(String s) {

        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        if (!(m.matches())) {
            return false;
        }

        return true;
    }

    public static String validatePassword(String s) {

        String regex = "^(?=.*?[a-z])(?=.*?[0-9]).{8,}$";
        String validpassword = "valid";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
       
       if (s.length() < 8) {
            validpassword = "invalid1";
        } else if (!(m.matches())) {
            validpassword = "invalid2";
        }

        return validpassword;
    }
    
    public static void validateOnlyAlphabet(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            
        }else{
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }
    
    public static boolean validateName(String s) {

        String regex = "^[a-zA-Z.]*$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        if (!(m.matches())) {
            return false;
        }

        return true;
    }

    public static boolean validateGst(String str) {
     
    
        // Regex to check valid
        // GST (Goods and Services Tax) number
        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}"
                       + "[A-Z]{1}[1-9A-Z]{1}"
                       + "Z[0-9A-Z]{1}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null)
        {
            return false;
        }
 
        // Pattern class contains matcher()
        // method to find the matching
        // between the given string
        // and the regular expression.
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean validateAccountNo(String str) {
       
       String regex =  "[0-9]{9,18}";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null)
        {
            return false;
        }
 
        // Pattern class contains matcher()
        // method to find the matching
        // between the given string
        // and the regular expression.
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }
}