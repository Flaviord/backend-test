package com.gateway.config;

import com.gateway.model.UserToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            if (exchange.getRequest().getMethod().equals(HttpMethod.GET)) {
                log.info("GET METHOD.");
                Mono<Void> filter = chain.filter(exchange);
                return chain.filter(exchange);
            }

            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing authorization information");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

            String[] parts = authHeader.split(" ");

            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                throw new RuntimeException("Incorrect authorization structure");
            }

            return webClientBuilder.build()
                .post()
                .uri("http://authentication-service/api/v1/authentication/validateToken?token=" + parts[1])
                .retrieve().bodyToMono(UserToken.class)
                .map(token -> {
                    exchange.getRequest()
                            .mutate()
                            .header("X-auth-user-id", String.valueOf(token.getId()));
                    return exchange;
                }).flatMap(chain::filter);
        };
    }

    public static class Config {}
}
