package com.semantyca.restserver;

import com.codahale.metrics.health.HealthCheck;

public class HealthHandler extends HealthCheck {
    private String template;

    public HealthHandler(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
