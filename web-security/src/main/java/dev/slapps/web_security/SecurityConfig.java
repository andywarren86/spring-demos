package dev.slapps.web_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityConfig() {
        System.out.println("SecurityConfig.SecurityConfig()");
    }

    @Bean
    public SecurityFilterChain securityFilterChain( final HttpSecurity http ) throws Exception {
        System.out.println("SecurityConfig.securityFilterChain()");
        return http
                .authorizeHttpRequests(requests ->
                    requests.requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(LogoutConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("SecurityConfig.userDetailsService()");
        final UserDetails user =
            User.withDefaultPasswordEncoder()
                .username("user")
                .password("pass")
                .roles("USER", "FOO")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
