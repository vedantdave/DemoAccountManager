package com.vedant.demoaccountmanager;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.vedant.demoaccountmanager.orm.models.AccountMaster;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtName, txtReName;
    AccountMaster accountMaster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        accountMaster = new AccountMaster(this);

        txtName = (EditText) findViewById(R.id.txtName);
        txtReName = (EditText) findViewById(R.id.txtReName);
        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.btnSubmit).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnView).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                ContentValues values = new ContentValues();
                values.put("name", txtName.getText().toString());
                accountMaster.create(values);
                break;
            case R.id.btnUpdate:
                ContentValues values1 = new ContentValues();
                values1.put("name", txtReName.getText().toString());
                accountMaster.update(values1, "name = ?", new String[]{txtName.getText().toString()});
                break;
            case R.id.btnDelete:
                accountMaster.delete("name = ? ", new String[]{txtName.getText().toString()});
                break;
            case R.id.btnView:
               startActivity(new Intent(this,ListMember.class));

                break;
        }
    }
}
