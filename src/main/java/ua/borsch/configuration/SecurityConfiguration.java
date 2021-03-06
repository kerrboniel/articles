package ua.borsch.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/blog").permitAll()
                .antMatchers("/blog/editor").hasRole("EDITOR")
                .and()
                .formLogin().loginPage("/blog/login").defaultSuccessUrl("/blog/editor").permitAll()
                .and()
                .logout().logoutUrl("/blog/logout").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user")
                .password("root").roles("EDITOR");
    }
}
