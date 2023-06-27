package com.exchange.rates.Config;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;

import com.getsentry.raven.connection.ProxyAuthenticator;
import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Client.Proxied feignClient() {
        Authenticator.setDefault(new ProxyAuthenticator("user", "password"));
        return new Client.Proxied(null, null,
                new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress("proxy-addr", 8080)),
                "user","password");
    }
}
