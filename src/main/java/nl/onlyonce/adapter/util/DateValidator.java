package nl.onlyonce.adapter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author: Gerben
 */
public class DateValidator {

    public static boolean isValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

}