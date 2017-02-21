package com.vedant.demoaccountmanager;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Signup extends AppCompatActivity implements View.OnClickListener {
    private EditText editEmail, editPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editEmail = (EditText) findViewById(R.id.txtEmail);
        editPassword = (EditText) findViewById(R.id.txtPassword);

        findViewById(R.id.btnSignup).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignup:
                AccountUtils.get(Signup.this).createAccount(editEmail.getText().toString(), editPassword.getText().toString());
                startActivity(new Intent(Signup.this, HomeActivity.class));
                finish();
                break;
        }

    }

}
