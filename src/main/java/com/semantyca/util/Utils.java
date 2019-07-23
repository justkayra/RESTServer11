package com.semantyca.util;


import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.MultivaluedMap;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Utils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    static {
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
    }



    public static String getTimeDiffInMilSec(long start_time) {
        long time = System.currentTimeMillis() - start_time;
        int sec = (int) time / 1000;
        int msec = (int) time % 1000;
        return Integer.toString(sec) + "." + Integer.toString(msec);
    }


}