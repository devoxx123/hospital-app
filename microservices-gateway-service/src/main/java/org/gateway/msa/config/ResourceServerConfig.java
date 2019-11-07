package org.gateway.msa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private ResourceServerTokenServices tokenServices;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("sciits-resource").tokenServices(tokenServices);
	}

	/*@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().and().authorizeRequests().antMatchers("/*.html","/*.css","/*.js","/actuator/**", "/auth/**").permitAll()
				.anyRequest().authenticated();
		http.formLogin().loginPage("/oauth/token").failureUrl("/login?error=true").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/access-denied");
	}*/
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
         http
                 .formLogin().loginPage("/oauth/token").permitAll()
                 .and().httpBasic().and()
                 .requestMatchers()
                 .antMatchers("/oauth/token", "/auth/**")
                 .antMatchers("/fonts/**", "/js/**", "/css/**")
                 .and()
                 .authorizeRequests()
                 .antMatchers("/fonts/**", "/js/**", "/css/**").permitAll()
                 .anyRequest().authenticated();
     }
}
