// package com.nsbm.studentapi;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;


// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter
// {
//     @Override
//     protected void configure(HttpSecurity http) throws Exception
//     {
//         http
//                 .csrf().disable()
//                 .authorizeRequests().anyRequest().authenticated()
//                 .and()
//                 .httpBasic();
//     }

//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth)
//             throws Exception
//     {
//         auth.inMemoryAuthentication()
//                 .withUser("user").password("{noop}password").roles("USER")
//                 .and()
//                 .withUser("admin").password("{noop}password").roles("ADMIN");
//     }
// }