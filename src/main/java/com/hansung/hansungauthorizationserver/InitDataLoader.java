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
                .studentId("1791457")
                .username("송무개")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user6 = User.builder()
                .studentId("1971245")
                .username("한무개")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user7 = User.builder()
                .studentId("1991587")
                .username("이무기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("디지털콘텐츠·가상현실트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user8 = User.builder()
                .studentId("2071123")
                .username("신짱구")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user9 = User.builder()
                .studentId("2071456")
                .username("김구거")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user10 = User.builder()
                .studentId("2191789")
                .username("박민영")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user11 = User.builder()
                .studentId("2174612")
                .username("오무개")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("디지털콘텐츠·가상현실트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user12 = User.builder()
                .studentId("2171271")
                .username("임무개")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user13 = User.builder()
                .studentId("2291882")
                .username("주우재")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user14 = User.builder()
                .studentId("2271789")
                .username("유가영")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("디지털콘텐츠·가상현실트랙")
                .build();

        User user15 = User.builder()
                .studentId("2291819")
                .username("감딸기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("모바일소프트웨어트랙")
                .secondTrack("웹공학트랙")
                .build();

        User user16 = User.builder()
                .studentId("2371553")
                .username("남도일")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("컴퓨터공학부")
                .secondTrack("컴퓨터공학부")
                .build();

        User user17 = User.builder()
                .studentId("2170000")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user18 = User.builder()
                .studentId("2170001")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user19 = User.builder()
                .studentId("2170002")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user20 = User.builder()
                .studentId("2170003")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user21 = User.builder()
                .studentId("2170004")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user22 = User.builder()
                .studentId("2170005")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user23 = User.builder()
                .studentId("2170006")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user24 = User.builder()
                .studentId("2170007")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user25 = User.builder()
                .studentId("2170008")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user26 = User.builder()
                .studentId("2170009")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user27 = User.builder()
                .studentId("2090000")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user28 = User.builder()
                .studentId("2090001")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user29 = User.builder()
                .studentId("2090002")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user30 = User.builder()
                .studentId("2090003")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user31 = User.builder()
                .studentId("2090004")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user32 = User.builder()
                .studentId("2090005")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/hansungCat.png")
                .firstTrack("웹공학트랙")
                .secondTrack("빅데이터트랙")
                .build();

        User user33 = User.builder()
                .studentId("2090006")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user34 = User.builder()
                .studentId("2090007")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user35 = User.builder()
                .studentId("2090008")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user36 = User.builder()
                .studentId("2090009")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user37 = User.builder()
                .studentId("2270000")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user38 = User.builder()
                .studentId("2270001")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user39 = User.builder()
                .studentId("2270002")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user40 = User.builder()
                .studentId("2270003")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user41 = User.builder()
                .studentId("2270004")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user42 = User.builder()
                .studentId("2270005")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user43 = User.builder()
                .studentId("2270006")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user44 = User.builder()
                .studentId("2270007")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user45 = User.builder()
                .studentId("2270008")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("디지털콘텐츠·가상현실트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user46 = User.builder()
                .studentId("2270009")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user47 = User.builder()
                .studentId("2290000")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("디지털콘텐츠·가상현실트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user48 = User.builder()
                .studentId("2290001")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("디지털콘텐츠·가상현실트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user49 = User.builder()
                .studentId("2290002")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User user50 = User.builder()
                .studentId("2290003")
                .username("상상부기")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_STUDENT")
                .picture(asUri + "/profile_image/picture.jpg")
                .firstTrack("웹공학트랙")
                .secondTrack("모바일소프트웨어트랙")
                .build();

        User admin = User.builder()
                .studentId("1800000")
                .username("ADMIN")
                .password(passwordEncoder.encode("1234"))
                .authority("ROLE_ADMIN")
                .picture(asUri + "/profile_image/boogie.png")
                .firstTrack(null)
                .secondTrack(null)
                .build();

        clientService.init(client);

        User[] users = {
                user1, user2, user3, user4, user5, user6, user7, user8, user9, user10,
                user11, user12, user13, user14, user15, user16, user17, user18, user19, user20,
                user21, user22, user23, user24, user25, user26, user27, user28, user29, user30,
                user31, user32, user33, user34, user35, user36, user37, user38, user39, user40,
                user41, user42, user43, user44, user45, user46, user47, user48, user49, user50,
                admin
        };

        for (User user : users) {
            userDetailsService.init(user);
        }

    }

}
