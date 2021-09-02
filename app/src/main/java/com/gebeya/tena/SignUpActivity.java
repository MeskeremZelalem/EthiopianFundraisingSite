package com.gebeya.tena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gebeya.tena.R;
import com.gebeya.tena.User;
import com.gebeya.tena.UserViewModel;
import com.gebeya.tena.ui.LoginActivity;
import com.gebeya.tena.ui.UserDao;

public class SignUpActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText phoneNo;
    private EditText password;
    private EditText passwordConfirm;
    private Button signUp;

    private UserDao userDao;
    private ProgressDialog progressDialog;
    private RadioGroup radioGroup;
    private RadioButton provider;
    private RadioButton receiver;
    private String role;
    private UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        name = findViewById(R.id.nameS);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phone_no);
        password = findViewById(R.id.passwordS);
        passwordConfirm = findViewById(R.id.password_confirm);
        signUp = findViewById(R.id.btn_sign_up);
        radioGroup = findViewById(R.id.group_role);
        provider = findViewById(R.id.provider);
        receiver = findViewById(R.id.receiver);

        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(UserViewModel.class);

        signUp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          if (!emptyValidation()) {
                                              Log.d("TAGGGGGGG",name.getText().toString());
                                              viewModel.signUp(name.getText().toString(), email.getText().toString(), password.getText().toString(), phoneNo.getText().toString(), role);
                                              progressDialog.dismiss();
                                              Intent I = new Intent(SignUpActivity.this, LoginActivity.class);
                                              startActivity(I);
//
                                          }
                                      }
                                  });

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int idSelected = radioGroup.getCheckedRadioButtonId();
                        switch (idSelected) {
                            case R.id.provider:
                                role = "ProviderDto";
                                break;
                            case R.id.receiver:
                                role = "Receiver";
                                break;

                        }
                    }
                });
    }

                private boolean emptyValidation () {
                    if (TextUtils.isEmpty(name.getText().toString())
                            || TextUtils.isEmpty(email.getText().toString())
                            || TextUtils.isEmpty(phoneNo.getText().toString())
                            || TextUtils.isEmpty(password.getText().toString())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }