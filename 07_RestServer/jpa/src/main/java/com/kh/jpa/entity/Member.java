package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import com.kh.jpa.enums.CommonEnums.Gender;
import com.kh.jpa.enums.CommonEnums.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "USER_ID", length = 30)
    private Long userId;

    @Column(name = "USER_PWD", length = 100, nullable = false)
    private String userPwd;

    @Column(name = "USER_NAME", length = 15, nullable = false)
    private String userName;

    @Column(name = "EMAIL", length = 254)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 1)
    private Gender gender; // M or F

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE", length = 13)
    private String phone;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @CreationTimestamp
    @Column(name = "ENROLL_DATE", updatable = false)
    private LocalDateTime enrollDate;

    @UpdateTimestamp
    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 1, nullable = false)
    @Builder.Default
    private CommonEnums.Status status = Status.Y; // Y or N

    // ==== 연관관계 멥핑 ====
    // cascade : Member 객체 상태 자체가 삭제(변경)되면 profile에도 영향을 주겠다.
    // orphanRemoval : Member 객체에서 profile의 참조값이 삭제되면 실제 DB에 반영하겠다.
    // cacade(객체 자신), orphanRemoval(참조 객체)
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Profile profile;

    // 1:N 관계 - Member가 여러 Notice 작성
    @OneToMany(mappedBy = "noticeWriter", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Notice> notices = new ArrayList<>();

    // 1:N 관계 - Member가 여러 Board 작성
    @OneToMany(mappedBy = "boardWriter", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Board> boards = new ArrayList<>();

    // 1:N 관계 - Member가 여러 Reply 작성
    @OneToMany(mappedBy = "replyWriter", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Reply> replies = new ArrayList<>();
}