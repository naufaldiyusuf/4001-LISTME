package android.example.listme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pengeluaran extends AppCompatActivity {

    TextView bulan, pengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);
    bulan = (TextView) findViewById(R.id.isiBulanPengeluaraan_editText);
    pengeluaran = (TextView) findViewById(R.id.isiJmlPengeluaran_editText);

    Intent tes3 = new Intent(Pengeluaran.this, MainActivity.class);
        startActivity(tes3);
        tes3.putExtra("bulan", "pengeluaran1");
        tes3.putExtra("pengeluaran", "pengeluaran2");
        //
    }
}
