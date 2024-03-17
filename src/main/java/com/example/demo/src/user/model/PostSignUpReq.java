package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostSignUpReq {
    private String email;
    private String password;
    private String phone;

    public PostSignUpReq() {
        // 왜 빈 생성자를 놔야 에러가 나지 않을까?
        // https://velog.io/@mcyoo/cannot-deserialize-from-Object-value-%EC%97%90%EB%9F%AC
    }
}
