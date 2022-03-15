package ru.netology.homeworkjdata71;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan")
                .password(encoder().encode("1234"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Alexey")
                .password(encoder().encode("password"))
                .roles("READ", "DELETE")
                .and()
                .withUser("Vasiliy")
                .password(encoder().encode("qwerty"))
                .roles("READ", "WRITE")
                .and()
                .withUser("Sidor")
                .password(encoder().encode("0000"))
                .roles("READ");
    }
}
