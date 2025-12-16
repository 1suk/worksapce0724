package com.kh.jpa.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name = "TAG_NAME", length = 30, nullable = false, unique = true)
    private String tagName;

    // N:M 관계 - Tag와 Board (BoardTag를 통한 다대다)
    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<BoardTag> boardTags = new ArrayList<>();
}