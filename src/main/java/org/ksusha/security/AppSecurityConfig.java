package org.ksusha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final
    MyUserDetailsService userDetailsService;

    @Autowired
    public AppSecurityConfig(@Qualifier("myUserDetailsService") MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user/find/all").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .antMatchers("/logout").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .antMatchers("/user/find/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/register/**").permitAll()
                .and().formLogin().defaultSuccessUrl("/user/find/all", false)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true).permitAll();
    }
}