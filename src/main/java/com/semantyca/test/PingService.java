package com.semantyca.test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.util.concurrent.*;

public class PingService {
    private static final int TIME_OUT_SECS = 5;
    static int requestStatus = 0;
    public static final String advancedFormat = "%-5s%-10s%s%n";
    private  static String[] apps = {"http://test1-basic-info-backend.intra.ocp-yty.prh.fi",
            "http://test1-codestable-backend.intra.ocp-yty.prh.fi",
            "http://test1-advanced-search-backend.intra.ocp-yty.prh.fi",
            "http://test1-notification-search.intra.ocp-yty.prh.fi",
            "http://test1-notification-browse.intra.ocp-yty.prh.fi",
            "http://test1-electronic-documents.intra.ocp-yty.prh.fi",
            "http://test1-yrtti-products-backend.intra.ocp-yty.prh.fi",
            "http://test1-extract-search-backend.intra.ocp-yty.prh.fi",
            "http://tpark-testi.prh.fi:80/WS_PRH/srvPRH.asmx",
            "http://ipecho.net/plain"
    };

    public void request(String serviceURL) {

        final Duration timeout = Duration.ofSeconds(TIME_OUT_SECS);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
             Future<String> handler = executor.submit(new Callable() {
                private int time = 0;
                @Override
                public String call() throws Exception {
                    Response response = ClientBuilder.newClient()
                            .target(serviceURL)
                            .request()
                            .get();
                    requestStatus = response.getStatus();
                    return "";
                }
            });
            try {
                handler.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                handler.cancel(true);
                System.out.println("TimeoutException " + TIME_OUT_SECS + " sec");
                requestStatus = -1;
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        PingService pingService = new PingService();
        for (String app:apps) {
            long startTime = System.currentTimeMillis();
            pingService.request(app);
            if (requestStatus != -1) {
                System.out.printf(advancedFormat, requestStatus, getTimeDiffInMilSec(startTime), app);
            }else{
                System.out.printf(advancedFormat, requestStatus, getTimeDiffInMilSec(startTime), app + ", ERROR");
            }
        }
        System.exit(0);
    }

    public static String getTimeDiffInMilSec(long start_time) {
        long time = System.currentTimeMillis() - start_time;
        int sec = (int) time / 1000;
        int msec = (int) time % 1000;
        return Integer.toString(sec) + "." + Integer.toString(msec);
    }

}
