package com.nopalyer.CalculadoraBizurada;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//importa lib
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPercent,btnPlus,btnMinus,btnMultiply,btnDivision,btnEqual,btnClear,btnDot;
    TextView tvScreen;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //referencia os botões
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);

        btnEqual = findViewById(R.id.btnEqual);

        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnPercent = findViewById(R.id.btnPercent);

        //input e output

        tvScreen = findViewById(R.id.tvScreen);

        //funções dos botões
        btnClear.setOnClickListener(v -> {
            tvScreen.setText("");
        });

        btn0.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "0");
        });

        btn1.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "1");
        });

        btn2.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "2");
        });

        btn3.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "3");
        });

        btn4.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "4");
        });

        btn5.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "5");
        });

        btn6.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "6");
        });

        btn6.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "6");
        });

        btn7.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "7");
        });

        btn8.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "8");
        });

        btn9.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "9");
        });

        btnPlus.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "+");
        });


        btnMinus.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "-");
        });

        btnMultiply.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "×");
        });

        btnDivision.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "÷");
        });

        btnDot.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + ".");
        });

        btnPercent.setOnClickListener(v -> {
            process = tvScreen.getText().toString();
            tvScreen.setText(process + "%");
        });

        //botão de igual
        btnEqual.setOnClickListener(v -> {
            process = tvScreen.getText().toString();

            process = process.replaceAll("×","*");
            process = process.replaceAll("%","/100");
            process = process.replaceAll("÷","/");

            Context rhino = Context.enter();

            rhino.setOptimizationLevel(-1);

            String finalResult = "";

            //biblioteca rhino entra em uso
            try {
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
            }catch (Exception e){
                finalResult="0";
            }

            tvScreen.setText(finalResult);
        });


    }
}
