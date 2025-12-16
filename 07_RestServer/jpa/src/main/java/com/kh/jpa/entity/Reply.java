package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import com.kh.jpa.enums.CommonEnums.Status;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "REPLY")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO")
    private Long replyNo;

    @Column(name = "REPLY_CONTENT", length = 400, nullable = false)
    private String replyContent;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 1, nullable = false)
    @Builder.Default
    private CommonEnums.Status status = Status.Y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_BNO", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_WRITER", nullable = false)
    private Member replyWriter;
}