package com.green.spring_board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardCreateRequest {
    @NotBlank // 비어있으면 안된다는 의미
    @Size(min = 10, max = 50) // 최소 길이, 최대 길이
    private String title;

    @NotBlank
    @Size(min = 10)
    private String content;
}
