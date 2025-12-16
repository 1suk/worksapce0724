package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO")
    private Long boardNo;

    @Column(name = "BOARD_TITLE", length = 100, nullable = false)
    private String boardTitle;

    @Lob // 대용량 텍스트 데이터(CLOB) 매핑
    @Column(name = "BOARD_CONTENT", nullable = false)
    private String boardContent;

    @Column(name = "ORIGIN_NAME", length = 100)
    private String originName;

    @Column(name = "CHANGE_NAME", length = 100)
    private String changeName;

    @Column(name = "COUNT")
    @Builder.Default // 빌드패턴으로 객체생성시 count 값이 없다면 기본값을 사용한다.
    private Integer count = 0; // int는 null 값을 가질 수 없어 Integer를 사용

    @CreationTimestamp
    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 1, nullable = false)
    @Builder.Default
    private Status status = Status.Y; // Y or N

    // N:1 관계 - Board가 연관관계의 주인 (외래키를 가진 쪽)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_WRITER", nullable = false)
    private Member boardWriter;

    // 1:N 관계 - Board가 여러 Reply를 가짐
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Reply> replies = new ArrayList<>();

    // N:M 관계 - Board와 Tag (BoardTag를 통한 다대다)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<BoardTag> boardTags = new ArrayList<>();
}