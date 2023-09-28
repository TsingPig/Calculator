package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView _resultTv, _solutionTv;
    MaterialButton _buttonC, _buttonLeftBracket, _buttonRightBracket;
    MaterialButton _buttonDivide, _buttonMultiply, _buttonPlus, _buttonMinus, _buttonEqual;
    MaterialButton _button0, _button1, _button2, _button3, _button4, _button5, _button6, _button7, _button8, _button9;
    MaterialButton _buttonAC, _buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //从R文件绑定TextView和Id
        _resultTv =findViewById(R.id.result_tv);
        _solutionTv =findViewById(R.id.solution_tv);


        assignId(_buttonC,R.id.button_c);
        assignId(_buttonLeftBracket,R.id.button_left_bracket);
        assignId(_buttonRightBracket,R.id.button_right_bracket);

        assignId(_buttonDivide,R.id.button_divide);
        assignId(_buttonMultiply,R.id.button_multiply);
        assignId(_buttonPlus,R.id.button_plus);
        assignId(_buttonMinus,R.id.button_minus);
        assignId(_buttonEqual,R.id.button_equal);

        assignId(_button0, R.id.button_0);assignId(_button1, R.id.button_1);
        assignId(_button2, R.id.button_2);assignId(_button3, R.id.button_3);
        assignId(_button4, R.id.button_4);assignId(_button5, R.id.button_5);
        assignId(_button6, R.id.button_6);assignId(_button7, R.id.button_7);
        assignId(_button8, R.id.button_8);assignId(_button9, R.id.button_9);


        assignId(_buttonAC, R.id.button_ac);
        assignId(_buttonDot, R.id.button_dot);

    }

    //实现View.OnClickListener接口

    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton) view;
//        _solutionTv.setText(buttonText);

        String buttonText=button.getText().toString();
        String dataToCalculate=_solutionTv.getText().toString();
//        switch (buttonText){
//            case "AC":
//                _solutionTv.setText("");
//                _resultTv.setText("0");
//                return;
//                break;
//            case "=":
//                break;
//        }
        if(buttonText.equals("AC")){   //全部清空
            _solutionTv.setText("");
            _resultTv.setText("0");
            return;
        }
        if(buttonText.equals("C") ){
            if(dataToCalculate.length()==0){    //已经清空
              //Toast
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }else{
                dataToCalculate=dataToCalculate.substring(0,dataToCalculate.length()-1);    //回退
            }
        }else{
            dataToCalculate+=buttonText;    //将输入的字符追加进表达式
        }
        _solutionTv.setText(dataToCalculate);
    }

    //将按钮与XML布局Id关联，并将按钮的点击事件监听器设置为MainActivity
    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

//    String getResult(String data){
//        // Customize the Toast
//
//
//    }
}