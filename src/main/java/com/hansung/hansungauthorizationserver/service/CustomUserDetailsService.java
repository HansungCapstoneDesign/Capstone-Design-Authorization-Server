package com.hansung.hansungauthorizationserver.service;

import com.hansung.hansungauthorizationserver.entity.User;
import com.hansung.hansungauthorizationserver.repository.UserRepository;
import com.hansung.hansungauthorizationserver.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByStudentId(studentId);
        return user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("유저 정보가 없습니다."));
    }

    @Transactional
    public void init(User user) {
        userRepository.save(user);
    }

}
