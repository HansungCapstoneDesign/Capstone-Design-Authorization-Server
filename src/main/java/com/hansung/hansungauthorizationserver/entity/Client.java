package com.hansung.hansungauthorizationserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@Getter
@Setter
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
