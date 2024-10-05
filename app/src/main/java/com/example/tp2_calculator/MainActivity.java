package com.example.tp2_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;
    private EditText texte1,texte2;
    private RadioButton r1,r2,r3,r4;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.res), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        texte1=findViewById(R.id.editText1);
        texte2=findViewById(R.id.editText2);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        res=findViewById(R.id.res);
        b=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }});}

    private void calculate() {
        if (texte1.getText().toString().isEmpty()||texte2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Champs vide",Toast.LENGTH_SHORT).show();
            return;}
        int num1=Integer.parseInt(texte1.getText().toString());
        int num2=Integer.parseInt(texte2.getText().toString());
        int result=0;
        if (r1.isChecked()) {
            result=num1+num2;
        } else if (r2.isChecked()) {
            result=num1-num2;
        } else if (r3.isChecked()) {
            result=num1*num2;
        } else if (r4.isChecked()) {
            if (num2 != 0) {
                result=num1/num2;
            } else {
                Toast.makeText(this,"Division par zéro est impossible !", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this,"Veuillez sélectionner une opération !", Toast.LENGTH_SHORT).show();
            return;}
        res.setText(String.valueOf(result));
    }
}