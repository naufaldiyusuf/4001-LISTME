package android.example.listme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Pemasukkan extends AppCompatActivity {

    TextView bulan, pemasukan, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukkan);

        bulan = (TextView) findViewById(R.id.isiNotePemasukkan_editText);
        pemasukan = (TextView) findViewById(R.id.isiJmlPemasuk_editText);
        note = (TextView) findViewById(R.id.isiNotePemasukkan_editText);

        Intent tes2 = new Intent(Pemasukkan.this, MainActivity.class);
        startActivity(tes2);
        tes2.putExtra("bulan", "pemasukan1");
        tes2.putExtra("pemasukan", "pemasukan2");
        tes2.putExtra("note", "pemasukan3");

    }
    //commend push
    //error
}