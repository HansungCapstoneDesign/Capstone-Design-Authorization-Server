package com.hansung.hansungauthorizationserver.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String username;
    private String password;
    private String authority; // 수정 필요, 다대다?
    private String picture;
    private String firstTrack;
    private String secondTrack;

    @Builder
    public User(String studentId, String username, String password, String authority, String picture, String firstTrack, String secondTrack) {
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.picture = picture;
        this.firstTrack = firstTrack;
        this.secondTrack = secondTrack;
    }

}
