package org.example.Islambek.security;

import org.example.Islambek.jwt.JwtTokenAuthenticationFilter;
import org.example.Islambek.jwt.JwtTokenGeneratorFilter;
import org.example.Islambek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/users/**","/books/**", "/issueds/**", "/personalDatas/**", "/genres/**", "/publishers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/books/**", "/personalDatas/**", "/genres/**", "/publishers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/issueds/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/users/**", "/books/**",  "/issueds/**", "/personalDatas/**", "/genres/**", "/publishers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/books/**", "/issueds/**", "/personalDatas/**", "/genres/**", "/publishers/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/users/**").hasAuthority("ADMIN")
                .antMatchers("/users/signUp").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**", "/");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}

