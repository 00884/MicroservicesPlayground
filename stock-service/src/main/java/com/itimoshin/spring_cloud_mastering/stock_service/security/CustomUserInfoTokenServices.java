package com.itimoshin.spring_cloud_mastering.stock_service.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CustomUserInfoTokenServices extends UserInfoTokenServices {
    public CustomUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
        super(userInfoEndpointUrl, clientId);
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        OAuth2Authentication originalAuthentication = super.loadAuthentication(accessToken);
        OAuth2Request originalRequest = originalAuthentication.getOAuth2Request();
        OAuth2Request extendedRequest = new OAuth2Request(
                originalRequest.getRequestParameters(),
                originalRequest.getClientId(),
                originalRequest.getAuthorities(),
                originalRequest.isApproved(),
                extractScopes(originalAuthentication),
                originalRequest.getResourceIds(),
                originalRequest.getRedirectUri(),
                originalRequest.getResponseTypes(),
                originalRequest.getExtensions()
        );
        return new OAuth2Authentication(extendedRequest, originalAuthentication);
    }

    @SuppressWarnings("unchecked")
    private HashSet<String> extractScopes(OAuth2Authentication authentication) {
        Map<String, Object> userAuthDetails = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        Map<String, Object> oAuth2Request = (Map<String, Object>) userAuthDetails.get("oauth2Request");
        return new HashSet<>((List<String>) oAuth2Request.get("scope"));
    }
}
