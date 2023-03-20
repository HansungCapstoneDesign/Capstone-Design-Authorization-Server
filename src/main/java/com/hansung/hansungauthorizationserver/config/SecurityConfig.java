package com.hansung.hansungauthorizationserver.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.UUID;

@Configuration
public class SecurityConfig {

    private final CORSCustomizer corsCustomizer;

    public SecurityConfig(CORSCustomizer corsCustomizer) {
        this.corsCustomizer = corsCustomizer;
    }

    @Bean
    @Order(1) // 설정 1순위
    public SecurityFilterChain asSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http); // Authorization Server 기본 설정 적용

        http
                .getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                .oidc(Customizer.withDefaults());

        http.exceptionHandling( // 에러 발생 시, Login 페이지로 이동
                e -> e.authenticationEntryPoint(
                        new LoginUrlAuthenticationEntryPoint("/login")
                )
        );
        corsCustomizer.corsCustomizer(http);

        return http.build();
    }

    @Bean
    @Order(2) // 설정 2순위
    public SecurityFilterChain appSecurityFilterChain(HttpSecurity http) throws Exception {
        corsCustomizer.corsCustomizer(http);

        http
                .formLogin() // Login Form Customize Possible !!!
                .and()
                .authorizeHttpRequests().anyRequest().authenticated(); // 모든 요청에 대해 권한 요구

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // 절대 이대로 사용하지 않기
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder()
                // .issuer("https://example.com") // issuer Customize possible
                .build();
    }

    // key pair 여러개 정의해서 Rotation 하는 것이 좋음
    @Bean
    public JWKSource<SecurityContext> jwkSource() throws Exception {
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); // RSA Algorithm
        kg.initialize(2048);
        KeyPair keyPair = kg.generateKeyPair();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // public key, 공개 키
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // private key, 개인 키

        RSAKey key = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();

        JWKSet set = new JWKSet(key);

        return new ImmutableJWKSet<>(set);
    }

    @Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> oAuth2TokenCustomizer() {
        return context -> {
            Collection<? extends GrantedAuthority> authorities = context.getPrincipal().getAuthorities();

            context.getClaims().claim("authorities",
                    authorities.stream().map(GrantedAuthority::getAuthority).toList());
        };
    }
}
