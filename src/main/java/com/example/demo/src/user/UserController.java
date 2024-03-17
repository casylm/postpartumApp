package com.example.demo.src.user;

import com.example.demo.config.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/app/users")
public class UserController {
    /**
     * 1. 회원가입 API
     * [POST] /users/signUp
     *
     * @return BaseResponse<PostUserRes>
     */
    // Body
    @ResponseBody
    @PostMapping("/sign-up")
    public BaseResponse createUser(@RequestBody PostSignUpReq postSignUpReq) {

        //이메일
        if (postSignUpReq.getEmail() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_EMAIL);
        }

        //핸드폰 번호
        if (postSignUpReq.getPhone() == null) {
            return new BaseResponse<>(REQUEST_ERROR);
        }

        //비밀번호
        if (postSignUpReq.getPassword() == null) {
            return new BaseResponse<>(REQUEST_ERROR);
        }

        return new BaseResponse<>(SUCCESS);
    }
}
