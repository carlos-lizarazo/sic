package co.gov.sic.encuesta;

import java.util.Arrays;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class EncuestasSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    DataSource dataSource;
	
	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .authoritiesByUsernameQuery("SELECT username, authority "
        		+ "FROM sic.authorities "
        		+ "WHERE username = ?")
        .usersByUsernameQuery("SELECT username, \"password\", enabled "
        		+ "FROM sic.users "
        		+ "where username = ?").passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and().authorizeRequests().antMatchers(
				"/*.js", "/*.css", "/favicon.ico", "/index.html", "/authenticate", "/login", "/error").permitAll()
		.anyRequest().authenticated();
		http.csrf().disable();
	}
}
