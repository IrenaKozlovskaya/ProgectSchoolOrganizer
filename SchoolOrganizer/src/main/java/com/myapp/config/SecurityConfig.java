package com.myapp.config;

import com.myapp.security.UserAuthenticationProvider;
<<<<<<< HEAD
import com.myapp.security.jwt.JwtAuthEntryPoint;
import com.myapp.security.jwt.JwtSecurityConfig;
import com.myapp.security.jwt.JwtTokenProvider;
=======
>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
<<<<<<< HEAD
import org.springframework.security.config.http.SessionCreationPolicy;
=======
>>>>>>> main

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserAuthenticationProvider authProvider;
<<<<<<< HEAD
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;


    @Autowired
    public SecurityConfig(UserAuthenticationProvider authProvider, JwtTokenProvider jwtTokenProvider, JwtAuthEntryPoint jwtAuthEntryPoint) {
        this.authProvider = authProvider;
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
=======


    @Autowired
    public SecurityConfig(UserAuthenticationProvider authProvider) {
        this.authProvider = authProvider;
>>>>>>> main
    }


    @Override
    public void configure(@Autowired AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
<<<<<<< HEAD
                .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
=======
>>>>>>> main
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/","/enter","/register").permitAll()
                .and()
                .formLogin()
                .loginPage("/enter").loginProcessingUrl("/login").usernameParameter("email")
                .passwordParameter("password")
                .and()
<<<<<<< HEAD
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").permitAll()
                .and()
                .apply(new JwtSecurityConfig(jwtTokenProvider));

=======
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful").permitAll();
>>>>>>> main


    }


}
