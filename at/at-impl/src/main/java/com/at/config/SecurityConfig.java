package com.at.config;

import com.at.config.authentication.EdbAuthenticationFailureHandler;
import com.at.config.authentication.EdbAuthenticationFilter;
import com.at.config.authentication.EdbAuthenticationProvider;
import com.at.config.authentication.EdbLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

//    private static final String PROPERTY_NAME_REDIRECT_URL = "http://localhost:8080/#/interview/interviews";
//
//    @Bean
//    LogoutHandler logoutHandler()
//    {
//        return new EdbLogoutHandler();
//    }
//
//    @Bean
//    AuthenticationFailureHandler authenticationFailureHandler()
//    {
//        return new EdbAuthenticationFailureHandler(PROPERTY_NAME_REDIRECT_URL);
//    }
//
//    @Bean
//    Filter authenticationFilter()
//            throws
//            Exception
//    {
//        EdbAuthenticationFilter authenticationFilter = new EdbAuthenticationFilter(AnyRequestMatcher.INSTANCE);
//
//        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
//        authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
//
//        return authenticationFilter;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws
//            Exception
//    {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Bean
    AuthenticationProvider authenticationProvider()
    {
        return new EdbAuthenticationProvider();
    }

    @Override
    protected void configure(HttpSecurity http)
            throws
            Exception
    {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .csrf().disable();
        http
                .logout().permitAll();
        http
                .formLogin().loginPage("/static/login.html")
                .loginProcessingUrl("/static/login")
                .defaultSuccessUrl("/").permitAll();
        http.authenticationProvider(authenticationProvider());
    }

}
