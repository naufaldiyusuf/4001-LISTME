package android.example.listme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    TextView register;
    EditText email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(login.this, MainActivity.class));
            finish();
        }

        register = (TextView) findViewById(R.id.register);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    return;
                }
                if (password.getText().toString().length() <6){
                    return;
                }
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(login.this, MainActivity.class));
                        finish();
                    }
                });


            }
        });
//menyambung firebase

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, RegisterActivity.class));
            }
        });

    }
}