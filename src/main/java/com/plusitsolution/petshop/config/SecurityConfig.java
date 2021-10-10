package com.plusitsolution.petshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.plusitsolution.common.apikey.filter.ApiKeyFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApiKeyFilter apiKeyFilter;

    // 3 levels security
// /secure/** -> can access by apikey OR basicAuth (user, admin)
// /secure/admin/** -> can access by basicAuth (admin)
// any thing else -> unsecure
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().antMatcher("/secure/**")
                // Disable CRSF
                .csrf().disable().cors()
                // STATELESS Session
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Api Key Filter
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class).authorizeRequests()
                // Admin GET
                .antMatchers(HttpMethod.GET, "/secure/ADMIN/**").hasRole("ADMIN")
                // Admin POST
                .antMatchers(HttpMethod.POST, "/secure/ADMIN/**").hasRole("ADMIN")
                // Admin PUT
                .antMatchers(HttpMethod.PUT, "/secure/ADMIN/**").hasRole("ADMIN")
                // Admin DELETE
                .antMatchers(HttpMethod.DELETE, "/secure/ADMIN/**").hasRole("ADMIN")
                // Secure GET
                .antMatchers(HttpMethod.GET, "/secure/**").hasAnyRole("ADMIN", "USER")
                // Secure POST
                .antMatchers(HttpMethod.POST, "/secure/**").hasAnyRole("ADMIN", "USER")
                // Secure PUT
                .antMatchers(HttpMethod.PUT, "/secure/**").hasAnyRole("ADMIN", "USER")
                // Secure DELETE
                .antMatchers(HttpMethod.DELETE, "/secure/**").hasAnyRole("ADMIN", "USER")
                // Authenticate
                .anyRequest().authenticated();
        // apikey also support Authority (MODULE from apiKeyInfo) as example below
        // .antMatchers(HttpMethod.GET, "/secure/**").hasAuthority("Module1")
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token", "apikey"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}