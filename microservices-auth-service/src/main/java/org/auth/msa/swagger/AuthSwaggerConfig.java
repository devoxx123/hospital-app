package org.auth.msa.swagger;
/*package org.auth.main.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@CrossOrigin
public class AuthSwaggerConfig {

	@Value("${config.oauth2.accessTokenUri}")
	private String accessTokenUri;

	@Bean
	public Docket UserApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.auth.main.controller")).paths(PathSelectors.any())
				.build().securityContexts(Collections.singletonList(securityContext()))
				.securitySchemes(Arrays.asList(securitySchema())).apiInfo(getApiInfo());

	}

	private OAuth securitySchema() {

		List<AuthorizationScope> authScopeList = new ArrayList();
		authScopeList.add(new AuthorizationScope("read", "read all"));
		authScopeList.add(new AuthorizationScope("write", "access all"));

		List<GrantType> grantTypes = new ArrayList();
		GrantType pwdCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
		grantTypes.add(pwdCredentialsGrant);

		return new OAuth("oauth2", authScopeList, grantTypes);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {

		final AuthorizationScope[] authScopes = new AuthorizationScope[3];
		authScopes[0] = new AuthorizationScope("read", "read all");
		authScopes[1] = new AuthorizationScope("trust", "trust all");
		authScopes[2] = new AuthorizationScope("write", "write all");

		return Collections.singletonList(new SecurityReference("oauth2", authScopes));
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityConfiguration security() {
		return new SecurityConfiguration("EmblaMagazineClient", "f2a1ed52710d4533bde25be6da03b6e3", "", "", "Bearer access token", ApiKeyVehicle.HEADER,
				"Authorization", ": Bearer");
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("SCI IT SOLUTIONS", "mhari.dropbox@gmail.com", null);
		return new ApiInfoBuilder().title("Spring Boot 2.0 REST API")
				.description("SpringBoot With RESTful Using User-Registration").version("2.0.0").license("Apache 2.0")
				.contact(contact).build();
	}

}
*/