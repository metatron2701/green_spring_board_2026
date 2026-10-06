package com.green.spring_board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "boards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int hits;

    @Column(nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdDatetime;

    @Column(nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedDatetime;

    // ~~To~~ 형식, One은 1, Many는 다, 일대일, 일대다, 다대다 같은 데이터베이스 키 뭐시기 관계에 따라 나눠둔다는 듯, 근데 일대일이랑 다대다는 딱히 쓸모가 없다는 것 같기도 함.
    // 얘한테 넌 좀 게을러질 필요가 있다는 의미로 (fetch = FetchType.LAZY)도 추가해야 함.
    // (fetch = FetchType.LAZY)를 추가하면 굳이 필요한 경우가 아니라고 판단하면 얘를 굳이 조회 안 한다고 함. (얘가 ㄹㅇ로 "나중에 할 게"를 시전해버림)
    // JoinColumn은 외래키를 지정함, (name = "key")를 추가해서 어떤 키를 외래키로 사용하는지 알려줘야 함.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
