package com.itimoshin.spring_cloud_mastering.stock_service.config;

import com.itimoshin.spring_cloud_mastering.stock_service.security.CustomUserInfoTokenServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

/*    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
    }*/

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

   /* @Bean
    public ResourceServerTokenServices tokenServices(
            @Value("${security.oauth2.client.accessTokenUri}" ) String userInfoUri,
            @Value("${security.oauth2.client.clientId}" ) String clientId) {
        return new CustomUserInfoTokenServices(userInfoUri, clientId);
    }*/

    @Bean
    public UserInfoTokenServices tokenServices(
            @Value("${security.oauth2.resource.userInfoUri}") String userInfoEndpoint,
            @Value("${security.oauth2.client.clientId}") String clientId,
            @Value("${security.oauth2.client.clientSecret}") String clientSecret) {
        CustomUserInfoTokenServices userInfoTokenServices = new CustomUserInfoTokenServices(userInfoEndpoint, clientId);
        return userInfoTokenServices;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated();
    }
}
