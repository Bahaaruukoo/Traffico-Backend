package com.SpringSecurity.AuthAgainstDBPractice1.account;

import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UserDetailsServiceImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests( (auth)-> auth
                .requestMatchers( "/home").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/ticket").permitAll()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("/logs").permitAll()
                .requestMatchers("/seeyouagain").permitAll()
                .requestMatchers("/allticket").permitAll()
                .requestMatchers("/profile/{id}").permitAll()
                //.requestMatchers("/performance/{id}").permitAll()
                //.requestMatchers("/**").authenticated()
                .anyRequest().authenticated()
                )//.formLogin(withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout((logout) ->
                        logout.deleteCookies("remove")
                                .invalidateHttpSession(false)
                                .logoutUrl("/logout")
                                //.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                                //.logoutSuccessUrl("/seeyouagain")
                                .logoutSuccessHandler(new SimpleUrlLogoutSuccessHandler())
                                .permitAll()
                ).csrf((cscrf) -> cscrf.disable())
                .cors((cors)-> cors.disable())
                .build();
    }
     @Bean
    public AuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
         daoAuthenticationProvider.setUserDetailsService(userDetailsService());

         return daoAuthenticationProvider;
     }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public FilterRegistrationBean corsFilter_() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
