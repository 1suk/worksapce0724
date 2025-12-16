package com.kh.jpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "NOTICE")
public class  Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    @Column(name = "NOTICE_TITLE", length = 30, nullable = false)
    private String noticeTitle;

    @Column(name = "NOTICE_CONTENT", length = 200, nullable = false)
    private String noticeContent;

    @CreationTimestamp
    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;

    // N:1 관계 - Notice가 연관관계의 주인 (외래키를 가진 쪽)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_WRITER", nullable = false)
    private Member noticeWriter;
}