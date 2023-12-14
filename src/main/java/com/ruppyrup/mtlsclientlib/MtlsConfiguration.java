package com.ruppyrup.mtlsclientlib;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnProperty(name = "mtls.enabled", havingValue = "true")
public class MtlsConfiguration {

    @Bean("mtlsRestTemplate")
    public RestTemplate mtlsRestTemplate(RestTemplateBuilder restTemplateBuilder, SslBundles sslBundles) {
        return restTemplateBuilder.setSslBundle(sslBundles.getBundle("consumer-mtls")).build();
    }

}
