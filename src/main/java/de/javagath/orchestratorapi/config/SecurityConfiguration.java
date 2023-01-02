package de.javagath.orchestratorapi.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration Bean for Web Security. Because of matching in the static files the application
 * needs access to both target and mapped addresses.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  /**
   * Configures filter chain for web security instead of using WebSecurityConfigurerAdapter.
   *
   * @param http http security
   * @return configured http
   * @throws Exception possible exceptions in the filter chain
   */
  @Bean
  SecurityFilterChain web(HttpSecurity http)
      throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .httpBasic()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(
            (request, response, authException) ->
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()))
        .and().
        authorizeHttpRequests(authConfig -> {
          authConfig.requestMatchers("/", "/blog/**").permitAll();
          authConfig.requestMatchers("/accounting/**").authenticated();
        })
        .exceptionHandling();

    return http.build();
  }
}