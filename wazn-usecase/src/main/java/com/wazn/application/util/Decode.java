package com.wazn.application.util;

import java.util.Base64;

public class Decode {

    public static String decode(String value) {
        return new String(Base64.getDecoder().decode(value));
    }
}
