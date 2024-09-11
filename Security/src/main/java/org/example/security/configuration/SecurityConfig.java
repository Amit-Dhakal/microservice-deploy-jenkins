package org.example.security.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain getFilterObject(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth -> auth
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login-page")
                        .defaultSuccessUrl("/welcome-page")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(eh -> eh.accessDeniedPage("/403"));
        return http.build();
    }
    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}









//    @Bean
//    public UserDetailsService getUserDetails(){
//
//        UserDetails user= User.withUsername("amit").password("amit").roles("USER").build();
//        return new InMemoryUserDetailsManager(user);
//    }

//security filter chain
//authentication manager
//authentication provider
//userdetailsservice
//steps
//security filter chain request haru filter purpose ko laagi
//


//user endpoints
//user1 has some endpoint1 access
//user2 hase other endpoint2 access
//user3 hase endpoint3 access

//i want to populate 10 users into database when i run the programme
