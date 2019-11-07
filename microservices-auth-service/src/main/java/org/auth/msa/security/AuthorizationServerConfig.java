package org.auth.msa.security;

import java.util.Arrays;
import java.util.List;

import org.auth.msa.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
//@EnableResourceServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		return converter;
	}

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ResourceServerTokenServices tokenServices;

	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("sciits-resource").tokenServices(tokenServices);
	}

	static final String CLIEN_ID = "sciits-client";
	static final String CLIENT_SECRET = "sciits-secret";
	static final String GRANT_TYPE = "password";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(CLIEN_ID).secret(passwordEncoder.encode(CLIENT_SECRET))
				.authorizedGrantTypes(GRANT_TYPE, REFRESH_TOKEN).scopes(SCOPE_READ, SCOPE_WRITE)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		//configurer.pathMapping("/oauth/token", "/api/v1/user/login");
		List list = Arrays.asList(accessTokenConverter());
		enhancerChain.setTokenEnhancers(list);
		configurer.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter()).tokenEnhancer(enhancerChain);
		configurer.authenticationManager(authenticationManager);
		configurer.userDetailsService(userDetailsService);// new
		configurer.reuseRefreshTokens(false);// new
		configurer.accessTokenConverter(accessTokenConverter());//new
	}
}
