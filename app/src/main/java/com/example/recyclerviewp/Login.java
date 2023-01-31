package com.example.recyclerviewp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    TextView textView;
    EditText loginText, passwordText;
    Button btnlogin;

    public static String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindesign);

        textView = (TextView) findViewById(R.id.textview);
        loginText = (EditText) findViewById(R.id.login);
        passwordText = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.buttonlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = loginText.getText().toString();
                String password = passwordText.getText().toString();
                Log.d(TAG, "onClick:username " + username + "password" + password);

                if (username.equals("user") && (password.equals("123456"))) {

                    Toast.makeText(Login.this, "Done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
