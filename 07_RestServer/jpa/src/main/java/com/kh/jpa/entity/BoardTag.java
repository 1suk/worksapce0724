package com.kh.jpa.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "BOARD_TAG")
public class BoardTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_NO", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;
}