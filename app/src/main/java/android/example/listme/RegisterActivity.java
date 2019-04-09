package android.example.listme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    TextView masuk;
    EditText nama, email, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        masuk = (TextView) findViewById(R.id.login);
        nama = findViewById(R.id.reg_name);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        register = (Button) findViewById(R.id.reg_create_btn);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, login.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Nama harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Email harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this,"Password harus diisi" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.getText().toString().length() <6){
                    Toast.makeText(RegisterActivity.this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show();
                    return;
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(RegisterActivity.this, login.class));
                            finish();
                        }else {
                            Toast.makeText(RegisterActivity.this, task.getResult().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}