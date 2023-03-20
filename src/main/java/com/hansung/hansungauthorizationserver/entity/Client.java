package com.hansung.hansungauthorizationserver.entity;

import jakarta.persistence.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@Entity
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String secret;
    private String redirectUri; // 수정 필요, 다대다?
    private String scope; // 수정 필요, 다대다?
    private String authMethod; // 수정 필요, 다대다?
    private String grantType; // 수정 필요, 다대다?

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public static Client from(RegisteredClient registeredClient) {
        Client client = new Client();

        client.setClientId(registeredClient.getClientId());
        client.setSecret(registeredClient.getClientSecret());
        client.setRedirectUri( // Not Clean Code
                registeredClient.getRedirectUris().stream().findAny().get()
        );
        client.setScope( // Not Clean Code
                registeredClient.getScopes().stream().findAny().get()
        );
        client.setAuthMethod( // Not Clean Code
                registeredClient.getClientAuthenticationMethods().stream().findAny().get().getValue()
        );
        client.setGrantType( // Not Clean Code
                registeredClient.getAuthorizationGrantTypes().stream().findAny().get().getValue()
        );

        return client;
    }

    public static RegisteredClient from(Client client) {
        return RegisteredClient.withId(String.valueOf(client.getId()))
                .clientId(client.getClientId())
                .clientSecret(client.getSecret())
                .scope(client.getScope())
                .redirectUri(client.getRedirectUri())
                .clientAuthenticationMethod(new ClientAuthenticationMethod(client.getAuthMethod()))
                .authorizationGrantType(new AuthorizationGrantType(client.getGrantType()))
                // .tokenSettings(TokenSettings.builder().accessTokenTimeToLive(Duration.ofHours(24)).build())
                .build();
    }
}
