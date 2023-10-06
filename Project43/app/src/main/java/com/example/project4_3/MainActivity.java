package com.example.project4_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Edit1, Edit2;
    TextView TextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit1 = findViewById(R.id.Edit1);
        Edit2 = findViewById(R.id.Edit2);
        TextResult = findViewById(R.id.TextResult);

        Button BtnAdd = findViewById(R.id.BtnAdd);
        Button BtnSub = findViewById(R.id.BtnSub);
        Button BtnMul = findViewById(R.id.BtnMul);
        Button BtnDiv = findViewById(R.id.BtnDiv);
        Button BtnRemainder = findViewById(R.id.BtnRemainder);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        BtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        BtnRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('%');
            }
        });
    }

    private void calculate(char operation) {
        String num1 = Edit1.getText().toString();
        String num2 = Edit2.getText().toString();

        if(num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "값을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

            double result = 0;

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = number1 / number2;
                    break;
                case '%':
                    if (number2 == 0) {
                        Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = number1 % number2;
                    break;
            }

            TextResult.setText("계산 결과 : " + result);

        } catch (Exception e) {
            Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
