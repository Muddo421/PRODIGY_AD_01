package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    String currentInput = "";
    String currentOperator = "";
    double firstOperand = 0;
    boolean operatorClicked = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.screen);

        // Number buttons
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDecimal = findViewById(R.id.btnDecimal);

        // Operator buttons
        Button btnADD = findViewById(R.id.btnADD);
        Button btnSUB = findViewById(R.id.btnSUB);
        Button btnMULTI = findViewById(R.id.btnMULTI);
        Button btnDIV = findViewById(R.id.btnDIV);
        Button btnEQUAL = findViewById(R.id.btnEQUAL);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnDEL = findViewById(R.id.btnDEL);


        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (operatorClicked) {
                    currentInput = "";
                    operatorClicked = false;
                }
                currentInput += button.getText();
                resultTextView.setText(currentInput);
            }
        };

        btn0.setOnClickListener(numberClickListener);
        btn1.setOnClickListener(numberClickListener);
        btn2.setOnClickListener(numberClickListener);
        btn3.setOnClickListener(numberClickListener);
        btn4.setOnClickListener(numberClickListener);
        btn5.setOnClickListener(numberClickListener);
        btn6.setOnClickListener(numberClickListener);
        btn7.setOnClickListener(numberClickListener);
        btn8.setOnClickListener(numberClickListener);
        btn9.setOnClickListener(numberClickListener);
        btnDecimal.setOnClickListener(numberClickListener);


        // Set OnClickListener for operator buttons
        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                currentOperator = button.getText().toString();
                firstOperand = Double.parseDouble(currentInput);
                operatorClicked = true;
            }
        };

        btnADD.setOnClickListener(operatorClickListener);
        btnSUB.setOnClickListener(operatorClickListener);
        btnMULTI.setOnClickListener(operatorClickListener);
        btnDIV.setOnClickListener(operatorClickListener);

        // Set OnClickListener for "=" button
        btnEQUAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double secondOperand = Double.parseDouble(currentInput);
                double result =0;
                switch (currentOperator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        result = firstOperand / secondOperand;
                        break;
                }
                resultTextView.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
                firstOperand = 0;
                currentOperator = "";
                operatorClicked = false;
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput = "";
                firstOperand = 0;
                currentOperator = "";
                operatorClicked = false;
                resultTextView.setText("0");
            }
        });

        // Set OnClickListener for "Del" button
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    resultTextView.setText(currentInput);
                }
            }
        });
    }
}