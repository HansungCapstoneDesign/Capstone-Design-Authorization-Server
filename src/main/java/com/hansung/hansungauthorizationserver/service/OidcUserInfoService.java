package com.hansung.hansungauthorizationserver.service;

import com.hansung.hansungauthorizationserver.entity.User;
import com.hansung.hansungauthorizationserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OidcUserInfoService {

    private final UserRepository userRepository;
    private final Map<String, Object> userInfo = new HashMap<>();

    public OidcUserInfo loadUser(String studentId) {
        User user = userRepository.findByStudentId(studentId)
                .orElseThrow(() -> new UsernameNotFoundException("There is no student id like : " + studentId));

        userInfo.put("name", user.getUsername());
        userInfo.put("track1", user.getFirstTrack());
        userInfo.put("track2", user.getSecondTrack());
        userInfo.put("picture", user.getPicture());

        return new OidcUserInfo(userInfo);
    }

}
