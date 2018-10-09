package com.wazn.application.util;

public class VerificationCode {

    private static final int MAX_VERIFICATION_CODE = 100000;
    private static final int MIN_VERIFICATION_CODE = 999999;

    public static String generateVerificationCode() {
       /* Random rand = new Random();
        Integer code = rand.nextInt(MIN_VERIFICATION_CODE - MAX_VERIFICATION_CODE + 1) + MAX_VERIFICATION_CODE;
        return code.toString();*/
       return "00000";
    }
}
