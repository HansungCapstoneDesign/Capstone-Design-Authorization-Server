package com.hansung.hansungauthorizationserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String username;
    private String password;
    private String authority; // 수정 필요, 다대다?
    private String picture;
    private String firstTrack;
    private String secondTrack;

}
