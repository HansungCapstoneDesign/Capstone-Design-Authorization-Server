package com.hansung.hansungauthorizationserver;

import com.hansung.hansungauthorizationserver.entity.Client;
import com.hansung.hansungauthorizationserver.entity.GrantType;
import com.hansung.hansungauthorizationserver.entity.User;
import com.hansung.hansungauthorizationserver.service.CustomClientService;
import com.hansung.hansungauthorizationserver.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 실행 직후, Client, User 초기 데이터 생성
 * Password Encoder 설정으로 data.sql 사용 불가
 */
@Component
@RequiredArgsConstructor
public class InitDataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
    private final CustomClientService clientService;

    @Value("${feUri}")
    private String feUri;
    @Value("${asUri}")
    private String asUri;

    @Override
    public void run(String... args) {
        Client client = Client.builder()
                .clientId("client")
                .secret(passwordEncoder.encode("secret"))
                .scope("openid")
                .authMethod("client_secret_basic")
                .redirectUri(feUri + "/authorized")
                .build();

        GrantType grantType1 = new GrantType();
        grantType1.setGrantType("refresh_token");
        GrantType grantType2 = new GrantType();
        grantType2.setGrantType("authorization_code");

        Set<GrantType> clientGrantTypes = new HashSet<>();
        clientGrantTypes.add(grantType1);
        clientGrantTypes.add(grantType2);
        client.setGrantTypes(clientGrantTypes);

        User user1 = User.builder()
                .studentId("1871308")
                .username("권현택")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user2 = User.builder()
                .studentId("1891239")
                .username("오찬근")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user3 = User.builder()
                .studentId("1971096")
                .username("곽은서")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user4 = User.builder()
                .studentId("2071274")
                .username("김서영")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user5 = User.builder()
                .studentId("2271234")
                .username("새내기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User admin = User.builder()
                .studentId("ADMIN")
                .username("ADMIN")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_ADMIN")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack(null)
                .secondTrack(null)
                .build();

        clientService.init(client);
        userDetailsService.init(user1);
        userDetailsService.init(user2);
        userDetailsService.init(user3);
        userDetailsService.init(user4);
        userDetailsService.init(user5);
        userDetailsService.init(admin);
    }

}
