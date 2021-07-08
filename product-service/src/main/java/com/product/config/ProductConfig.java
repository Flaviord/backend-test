package com.product.config;

import com.product.services.ProductService;
import com.sun.net.ssl.SSLContextSpi;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.tomcat.jni.SSLContext;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    @Bean
    public RestTemplate restTemplate() throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient =
                HttpClients.custom()
                        .setSSLHostnameVerifier(new NoopHostnameVerifier())
                        .build();
        HttpComponentsClientHttpRequestFactory reqFactory =
                new HttpComponentsClientHttpRequestFactory();
        reqFactory.setHttpClient(httpClient);
        return new RestTemplate(reqFactory);
    }
}
