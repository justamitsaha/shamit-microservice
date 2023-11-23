package com.saha.amit.security.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .regexMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                        .regexMatchers(HttpMethod.GET, "/api/employees/.*").hasRole("EMPLOYEE")
//                        .regexMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                        .regexMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                        .regexMatchers(HttpMethod.DELETE, "/api/employees/.*").hasRole("ADMIN"));
//
//        /*In Spring 3 requestMatchers accepts below format for 2. have to use above
//                configurer
//                        .requestMatchers(HttpMethod.GET).hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));*/
//        //use HTTP Basic authentication
//
//        http.csrf(csrf -> csrf.disable());
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
}
