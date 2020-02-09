package com.hackdroid.alertlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String email, password;
    EditText emailInput, passwordInput;
    Button loginAlert, login, close;
    String TAG = MainActivity.class.getSimpleName();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO :: Init View
        loginAlert = findViewById(R.id.loginAlert);
        loginAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Login Alert Button Cliked");
                showAlert();

            }
        });
    }

    private void showAlert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this,
                R.style.alertTheme);
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.login_layout, null);
        alert.setView(view);
        alert.setCancelable(false);
        //*View Init*//
        emailInput = view.findViewById(R.id.emailInput);
        passwordInput = view.findViewById(R.id.passInput);
        login = view.findViewById(R.id.login);
        close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Required field missing", Toast.LENGTH_SHORT).show();
                } else {
                    //login
                    Log.d(TAG, "onClick: " + email + "Password" + password);
                }
            }
        });
        alertDialog = alert.create();
        alertDialog.show();
    }
}
