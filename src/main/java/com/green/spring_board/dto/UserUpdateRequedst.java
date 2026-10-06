package com.green.spring_board.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateRequedst {
    @Email
    @Size(max = 100)
    private String email;

    @Size(min = 1, max = 30)
    private String nickname;

    // 값 유무 검증
    // @NotNull - Null은 허용하지 않음
    // @NotEmpty - 문자열 or 콜렉션이 비어 있으면 안됨 (공백으로 채운 문자열은 허용)
    // @NotBlank - 문자열 or 콜렉션이 비어 있으면 안됨 (공백으로 채운 문자열도 허용하지 않음)

    // 값 범위 검증
    // @Size(min, max) - 문자열 or 콜렉션의 최소/최대 길이, 숫자의 크기는 보지 않음
    // @min, @max - 숫자의 최소/최대 값 지정
    // @Positive, @Negative - 양수/음수만 허용
    // @Past, @Future - 날짜 값의 과거/미래 여부 검사

    // 값 형식 검증
    // @Email - 이메일 형식인지 검사
}
