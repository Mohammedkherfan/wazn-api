package com.wazn.application.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileValidator {

    private static final String MOBILE_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static Pattern pattern;
    private Matcher matcher;

    public MobileValidator() {
        pattern = Pattern.compile(MOBILE_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public Boolean validateMobile(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
