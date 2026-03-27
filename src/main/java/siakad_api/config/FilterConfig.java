package siakad_api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> reg = new FilterRegistrationBean<>();

        reg.setFilter(new JwtFilter());
        reg.addUrlPatterns("/api/*");

        return reg;
    }
}