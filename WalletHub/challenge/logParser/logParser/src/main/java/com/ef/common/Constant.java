package com.ef.common;

import java.util.Arrays;
import java.util.List;

public class Constant {

	public static final String ACCESS_LOG = "accesslog";
    public static final String DURATION = "duration";
    public static final String THRESHOLD = "threshold";
    public static final String STARTDATE = "startDate";

    public static final String DAILY = "daily";
    public static final String HOURLY = "hourly";

    public static final List<String> DURATION_TYPES = Arrays.asList(DAILY, HOURLY);
    
    public static final List<String> MANDATORY_PARAMS = Arrays.asList(ACCESS_LOG, STARTDATE, DURATION, THRESHOLD);
	
    public static final int FIRST_POSITION = 0;
    
    public static final String SEPARATOR = "\\|";
    
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final int LOG_PATTERN_LENGTH = 5;
    
    public static final int DATE_POS = 0;
    public static final int IP_POS = 1;
    public static final int REQUEST_POS = 2;
    public static final int STATUS_POS = 3;
    public static final int USER_AGENT_POS = 5;
}
