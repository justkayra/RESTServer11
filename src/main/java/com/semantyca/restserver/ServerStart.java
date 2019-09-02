package com.semantyca.restserver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.xml.ws.Endpoint;


public class ServerStart extends Application<ServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ServerStart().run(args);
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) {
        environment.healthChecks().register("database", new HealthHandler("ss"));
        environment.jersey().register(new Resource());
        environment.jersey().register(new TResource());
        environment.jersey().register(new SResource());
        environment.jersey().register(new VResource());
    }

    @Override
    public void initialize(final Bootstrap<ServerConfiguration> bootstrap) {

        bootstrap.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor())
        );
        bootstrap.addBundle(new AssetsBundle("/static/", "/static"));

        String bindingURI = "http://localhost:9888/YrttiInvoicing";
        YrttiInvoicingRequest webService = new YrttiInvoicingRequest();
        Endpoint.publish(bindingURI, webService);
        System.out.println("WebService server started at: " + bindingURI);

    }

}
