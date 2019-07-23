package com.semantyca.util;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Pinger {
    private static final int TIME_OUT_SECS = 5;
    static int requestStatus = 0;
    public static final String advancedFormat = "%-5s%-10s%s%n";

    public void check(String app){
        request(requestStatus, app);
    }

    public static void request(int requestStatus, String serviceURL) {
        long startTime = System.currentTimeMillis();
        final Duration timeout = Duration.ofSeconds(TIME_OUT_SECS);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<String> handler = executor.submit(new Callable() {
                @Override
                public String call() throws Exception {
                    Response response = ClientBuilder.newClient()
                            .target(serviceURL)
                            .request()
                            .get();
                    int requestStatus = response.getStatus();
                    if (requestStatus != -1) {
                        System.out.printf(advancedFormat, requestStatus, Utils.getTimeDiffInMilSec(startTime), serviceURL);
                    }else{
                        System.err.printf(advancedFormat, requestStatus, Utils.getTimeDiffInMilSec(startTime), serviceURL + ", ERROR");
                    }
                    return "";
                }
            });
            try {
                handler.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                handler.cancel(true);
                System.err.println("TimeoutException " + TIME_OUT_SECS + " sec");
                requestStatus = -1;
            }

        } catch (Exception ex) {
            System.err.println(ex.toString());
            ex.printStackTrace();
        }
    }

}
