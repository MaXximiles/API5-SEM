package com.grupo3.finddata;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CORSPolicy {
    
	/*@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("http://localhost:8080","https://finddata-frontend.web.app","https://finddata-frontend.herokuapp.com"));
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }*/
}