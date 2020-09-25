package com.hospital.utils;

import com.hospital.Constant;

import java.util.Arrays;


public class ValidationInputData implements Validation {

    @Override
    public void validateInputString(String[] input) {
        if (Arrays.stream(input).filter(s -> !Constant.REPORT.contains(s)).count() > 0l) {
            new IllegalStateException(Constant.ERRORS_MESSAGES);
        }
    }
}
