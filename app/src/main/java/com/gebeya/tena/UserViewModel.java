package com.gebeya.tena;

import android.app.Application;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserViewModel extends ViewModel {


    MutableLiveData<List<User>> UserList;
    private Retrofit retrofit;
    private UserService mService;

    public LiveData<String> signUp(String firstname, String email,String phoneNo, String password, String role) {
        final MutableLiveData<String> formResponse = new MutableLiveData<String>();
        mService = App.getConnection().create(UserService.class);
        mService.signUp(firstname,email,phoneNo,password,role).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                    formResponse.setValue("submission sucessful");
                else {
                    formResponse.setValue("unsuccessful");

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //Toast.makeText(SignUpActivity.class, t.getMessage(), Toast.LENGTH_LONG);
            }
        });

        return formResponse;
    }

    }
