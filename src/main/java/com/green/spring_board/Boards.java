package com.green.spring_board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boards")
@AllArgsConstructor // 파라미터를 자동으로 만들어주는 놈
@NoArgsConstructor // 생성자를 자동으로 만들어주는 놈
@Getter // getter 함수들을 자동으로 만들어주는 놈
@Setter // setter 함수들을 자동으로 만들어주는 놈
public class Boards {
    @Id // SQL의 PRIMARY KEY와 같음
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SQL의 AUTO_INCREMENT와 같음
    private int id;

    @Column(nullable = false) // SQL의 NOT NULL과 같음
    private String title; // VARCHAR과 TEXT는 String으로 통일

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int hits;
}
