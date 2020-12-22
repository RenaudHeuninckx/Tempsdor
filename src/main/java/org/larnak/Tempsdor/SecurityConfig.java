package org.larnak.Tempsdor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void congigGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder().encode("root"))
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/activity/**","/activity")
                .authenticated()
                .antMatchers("/booking/**","/booking")
                .authenticated()
                .antMatchers("/room/**","/room")
                .authenticated()
                .antMatchers("/user/**", "/user")
                .hasRole("USER")
                .antMatchers(HttpMethod.POST)
                .authenticated()
                .antMatchers(HttpMethod.PUT)
                .authenticated()
                .antMatchers(HttpMethod.DELETE)
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder encoder() { return new BCryptPasswordEncoder(); }
}
