package com.kh.jpa.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROFILE")
public class Profile {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long profileId;

    @Column(name = "PROFILE_IMAGE", length = 100)
    private String profileImage;

    @Column(name = "INTRO", length = 300)
    private String intro;

    //==== 연관관계 맵핑 ====

    // 1:1 관계 - Profile이 연관관계의 주인 (외래키를 가진 쪽), 반대로 사용해 됨
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", unique = true, nullable = false)
    private Member member;
}