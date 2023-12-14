package com.ruppyrup.mtlsclientlib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(
properties = {
        "mtls.enabled=true",
        "mtls.private-key-passwd=password"
        }
)
class MtlsClientLibApplicationTests {

    @Autowired
    RestTemplate mtlsRestTemplate;

    @Test
    void contextLoads() {
        String restTemplateName = mtlsRestTemplate.getClass().getSimpleName();
        Assertions.assertEquals("RestTemplate", restTemplateName);
    }

}
