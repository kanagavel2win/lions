package com.lionsclub.springboot.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lionsclub.springboot.thymeleaf.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    	
        http
                .authorizeRequests()
                    .antMatchers(
                            "/registration**",
                            "/app-assets/**",
                            "/assets/**",
                            "/gulp-tasks/**",
                            "/src/**",
                            "/css/**",
                            "/webjars/**",
                            "/ajax","/api/customer/all","/api/customer/save","/js/**"
                    		).permitAll()
                    .antMatchers("/").access("hasRole('ROLE_CLUBADMIN') or hasRole('ROLE_MEMBER')")
                    .antMatchers("/index").access("hasRole('ROLE_CLUBADMIN') or hasRole('ROLE_MEMBER')")
                    .antMatchers("/internationallionsclub").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/memberview").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/memberedit").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/memberlist").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/membersearch").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/memberupload").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/MemberPendingInfo").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportAllmemberdetails").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportAllmemberdetailswithFamily").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportOthers").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/Color").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportDOB").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportWedd").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportBloodGroup").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/ReportDifferentIntvslocal").access("hasRole('ROLE_CLUBADMIN')")
                    .antMatchers("/memberFamilyDelete").access("hasRole('ROLE_CLUBADMIN')")
                    
                    //Member Access
                    .antMatchers("/ReportDifferentIntvslocalRoleMember").access("hasRole('ROLE_MEMBER')")
                    .antMatchers("/membereditRoleMember").access("hasRole('ROLE_MEMBER')")
                    .antMatchers("/MemberviewRoleMember").access("hasRole('ROLE_MEMBER')")
                    //.antMatchers("/index").access("hasRole('ROLE_MEMBER')")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error/401Unaut")
                
                ;
        
        
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
