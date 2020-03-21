package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.CompoundButton;
import android.widget.ImageButton;

import android.widget.Switch;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ToggleButton tb1;
    private Switch switch1;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn17;
    TextView text2;
    ImageButton btn16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = (ToggleButton) findViewById(R.id.tb1);
        switch1 = (Switch) findViewById(R.id.switch1);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (ImageButton) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);

        text2 = (TextView) findViewById(R.id.text2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(new click());
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);

        tb1.setOnCheckedChangeListener(this);
        switch1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = text2.getText().toString();
        switch (v.getId()) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btn10:

                text2.setText(input + ((Button) v).getText());
                break;

            case R.id.btn11:
            case R.id.btn12:
            case R.id.btn13:
            case R.id.btn14:

                text2.setText(input + " " + ((Button) v).getText() + " ");
                break;

            case R.id.btn16:
                text2.setText("");
                break;
        }
    }

    class click implements View.OnClickListener {
        public void onClick(View v) {
            getResult();
        }
    }

    private void getResult() {
        String str1 = text2.getText().toString();
        if (str1 == null || str1.equals("")) {
            return;
        }
        if (!str1.contains(" ")) {
            return;
        }

        double result = 0;
        String s1 = str1.substring(0, str1.indexOf(" "));
        String op = str1.substring(str1.indexOf(" ") + 1, str1.indexOf(" ") + 2);
        String s2 = str1.substring(str1.indexOf(" ") + 3);
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        if (op.equals("+")) {
            result = d1 + d2;
        } else if (op.equals("-")) {
            result = d1 - d2;
        } else if (op.equals("×")) {
            result = d1 * d2;
        } else if (op.equals("÷")) {
            if (d2 == 0) {
                result = 0;
            } else {
                result = d1 / d2;
            }
        }
        str1 = "";
        text2.setText(str1 + result);

        if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {//如果两个整数且不是除法运算
            int r = (int) result;  //则结果转为整数
            str1 = "";
            text2.setText(str1 + r);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.tb1:
                if (compoundButton.isChecked())
                    Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                if (compoundButton.isChecked())
                    Toast.makeText(this, "开关:ON", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "开关:OFF", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}