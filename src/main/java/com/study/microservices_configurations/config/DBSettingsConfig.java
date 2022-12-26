package com.study.microservices_configurations.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
public class DBSettingsConfig {
    private String schema;
    private String host;
    private String connectionParams;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConnectionParams() {
        return connectionParams;
    }

    public void setConnectionParams(String connectionParams) {
        this.connectionParams = connectionParams;
    }

    @Override
    public String toString() {
        return "DBSettingsConfig{" +
                "schema='" + schema + '\'' +
                ", host='" + host + '\'' +
                ", connectionParams='" + connectionParams + '\'' +
                '}';
    }
}
