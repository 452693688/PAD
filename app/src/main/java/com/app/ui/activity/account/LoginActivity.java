package com.app.ui.activity.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.ui.activity.R;
import com.app.ui.activity.action.BaseBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseBarActivity {

    @Bind(R.id.login_account_et)
    EditText loginAccountEt;
    @Bind(R.id.login_password_et)
    EditText loginPasswordEt;
    @Bind(R.id.login_password_save_tv)
    TextView loginPasswordSaveTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_password_save_tv, R.id.login_password_forget_tv, R.id.login_in_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_password_save_tv:
                break;
            case R.id.login_password_forget_tv:
                break;
            case R.id.login_in_tv:
                break;
        }
    }
}
