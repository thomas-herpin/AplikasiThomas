package edu.uph.m23si2.thomasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kalkulator_activity extends AppCompatActivity {

    EditText edtNilaiA, edtNilaiB;
    Button btnTambah, btnKali, btnBagi;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNilaiA = findViewById(R.id.edtNilaiA);
        edtNilaiB = findViewById(R.id.edtNilaiB);
        txtHasil = findViewById(R.id.txtHasil);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    private void hitung(char operator) {
        String strNilaiA = edtNilaiA.getText().toString();
        String strNilaiB = edtNilaiB.getText().toString();

        int nilaiA = Integer.parseInt(strNilaiA);
        int nilaiB = Integer.parseInt(strNilaiB);
        int hasil = 0;

        switch (operator) {
            case '+':
                hasil = nilaiA + nilaiB;
                break;
            case '*':
                hasil = nilaiA * nilaiB;
                break;
            case '/':
                if (nilaiB != 0) {
                    hasil = nilaiA / nilaiB;
                } else {
                    txtHasil.setText("Tidak bisa dibagi 0");
                    return;
                }
                break;
        }

        txtHasil.setText(String.valueOf(hasil));
    }
}