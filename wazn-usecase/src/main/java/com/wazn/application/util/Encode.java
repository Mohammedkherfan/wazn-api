package com.wazn.application.util;

import java.util.Base64;

public class Encode {

    public static String encode(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}
