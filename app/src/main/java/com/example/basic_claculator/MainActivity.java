package com.example.basic_claculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_add, btn_sub, btn_mul, btn_div;
    EditText editText1, editText2;
    TextView textView;

    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_div = findViewById(R.id.btn_div);
        btn_mul = findViewById(R.id.btn_mul);

        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);

        textView = findViewById(R.id.answer);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);


    }

    public Integer getIntFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        Integer num1 = getIntFromEditText(editText1);
        Integer num2 = getIntFromEditText(editText2);


        switch (view.getId()) {
            case R.id.btn_add:
                textView.setText("Answer = " + (num1 + num2));
                break;

            case R.id.btn_sub:
                textView.setText("Answer = " + (num1 - num2));
                break;

            case R.id.btn_mul:
                textView.setText("Answer = " + (num1 * num2));
                break;

            case R.id.btn_div:
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText("Answer = " + ((float) num1 / num2));
                }
                break;
        }
    }
}
