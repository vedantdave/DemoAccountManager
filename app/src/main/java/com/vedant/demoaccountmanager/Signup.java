package com.vedant.demoaccountmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;

import io.fabric.sdk.android.Fabric;



public class Signup extends AppCompatActivity implements View.OnClickListener {
    private EditText editEmail, editPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this);
        setContentView(R.layout.activity_signup);
        editEmail = (EditText) findViewById(R.id.txtEmail);
        editPassword = (EditText) findViewById(R.id.txtPassword);


        findViewById(R.id.btnSignup).setOnClickListener(this);
        Pubnub pubnub1 = new Pubnub(getString(R.string.com_pubnub_publishKey), getString(R.string.com_pubnub_subscribeKey));

        try {
            pubnub1.subscribe("Channel-nnaip2v8k", new Callback() {

                        @Override
                        public void connectCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : CONNECT on channel:" + channel
                                    + " : " + message.getClass() + " : "
                                    + message.toString());
                        }

                        @Override
                        public void disconnectCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel
                                    + " : " + message.getClass() + " : "
                                    + message.toString());
                        }

                        public void reconnectCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel
                                    + " : " + message.getClass() + " : "
                                    + message.toString());
                        }

                        @Override
                        public void successCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : " + channel + " : "
                                    + message.getClass() + " : " + message.toString());
                        }

                        @Override
                        public void errorCallback(String channel, PubnubError error) {
                            System.out.println("SUBSCRIBE : ERROR on channel " + channel
                                    + " : " + error.toString());
                        }
                    }
            );
        } catch (PubnubException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignup:
                AccountUtils.get(Signup.this).createAccount(editEmail.getText().toString(), editPassword.getText().toString());
                startActivity(new Intent(Signup.this, HomeActivity.class));
                break;
        }

    }

}
