package com.green.spring_board;

import jakarta.persistence.*;

@Entity
@Table(name = "boards")
public class Boards {
    @Id // SQL의 PRIMARY KEY와 같음
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SQL의 AUTO_INCREMENT와 같음
    private int id;

    @Column(nullable = false) // SQL의 NOT NULL과 같음
    private String title; // VARCHAR과 TEXT는 String으로 통일

    @Column(nullable = false)
    private String content;

    public Boards() {}

    public Boards(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
