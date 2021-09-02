package com.gebeya.tena;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signUp(
            @Field("fullName") String fullName,
            @Field("email") String email,
            @Field("phoneNo") String phoneNo,
            @Field("password") String password,
            @Field("role") String role
    );

    @FormUrlEncoded
    @POST("/user/login")
    Call<LoginResponse> logIn(

            @Field("userName") String username,
            @Field("passWord") String password
    );
}
