package com.hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String DEAD_STATE_CODE = "X";
    public static final String DIABETES_STATE_CODE = "D";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SPACE = " ";
    public static final String FEVER_STATE_CODE = "F";
    public static final String HEALTHY_STATE_CODE = "H";
    public static final String TUBERCULOSIS_STATE_CODE = "T";
    public static final String ERRORS_MESSAGES = "Health state not found";
    public static final List<String> REPORT = new ArrayList<>(Arrays.asList("F", "H", "D", "T", "X"));

}
