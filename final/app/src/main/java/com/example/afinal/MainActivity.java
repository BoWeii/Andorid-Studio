package com.example.afinal;

import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.LinkedList;
import java.util.Stack;

class PostfixEvaluation {
    public static double cal(String temp ,double data) {
        Stack<Double> operands = new Stack<Double>();
        String[] strArr = temp.split(" ");
        for(String str : strArr) {
            double right=0,left=0,value=0;
            if (str.trim().equals("")) {
                continue;
            }
            switch (str) {
                case "x":
                    operands.push(data);
                    break;
                case "e":
                    operands.push(Math.E);
                    break;
                case "π":
                    operands.push(Math.PI);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    right = operands.pop();
                    left = operands.pop();

                    switch(str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        case"^":
                            value = Math.pow(left,right);
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                case "A":
                case "C":
                case "L":
                case "S":
                case "T":
                    right = operands.pop();

                    value = 0;
                    switch(str) {
                        case"A":
                            value = Math.abs(right);
                            break;
                        case"C":
                            value = Math.cos(right);
                            break;
                        case"L":
                            value = Math.log(right);
                            break;
                        case"S":
                            value = Math.sin(right);
                            break;
                        case"T":
                            value = Math.tan(right);
                            break;

                        default:
                            break;
                    }
                    operands.push(value);
                    break;

                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }
        return operands.pop();
    }
}
//////////////////////////////////////////////////////////////////////////////////////
class Infix {
    private static int priority(char c) {
        if(c=='+' || c=='-')
            return 1;
        else if(c=='*' || c=='/')
            return 2;
        else if(c=='^')
            return 3;
        else if(c=='A' || c=='C' || c=='L' || c=='S' || c=='T')
            return 4;
        else
            return 0;
        //  return c == '+' || c == '-' ? 1 : c == '*' || c == '/' ? 2 : 0;
    }

    private static String toPostfix(String infix, boolean isPost) {
        String expr = isPost ?
                infix : new StringBuffer(infix).reverse().toString();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        char toStack = isPost ? '(' : ')';
        char toOutput = isPost ? ')' : '(';
        for (char c : expr.toCharArray()) {
            if (c == toStack) {

                stack.add(c);
            } else if ("+-*/^ACLST".indexOf(c) != -1) {
                while (!stack.isEmpty() &&
                        priority(stack.getLast()) >= priority(c)) {
                    output.append(' ');
                    output.append(stack.removeLast());
                }
                // stack.add('z');
                output.append(' ');
                stack.add(c);
            } else if (c == toOutput) {
                while (stack.getLast() != toStack) {
                    output.append(' ');
                    output.append(stack.removeLast());
                }
                //  stack.add('w');
                stack.removeLast();
            } else {
                //  output.append('a');
                output.append(c);
            }
        }
        while (!stack.isEmpty()) {
            output.append(' ');
            output.append(stack.removeLast());
        }
        return isPost ? output.toString() : output.reverse().toString();
    }

    public static String toPostfix(String infix) {
        return toPostfix(infix, true);
    }
}

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series1;
    private EditText content;
    private KeyboardTEMPHelper helper;
    private KeyboardView keyboard;
    private TextView show1,show2,show3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = findViewById(R.id.editText);
        //show1=findViewById(R.id.textView);
        //show2=findViewById(R.id.textView2);
        //show3=findViewById(R.id.textView3);
        keyboard = findViewById(R.id.keyboard_temp);
        //初始化KeyboardView
        helper = new KeyboardTEMPHelper(MainActivity.this, keyboard);
        //设置editText与KeyboardView绑定
        helper.setEditText(content);
        helper.setCallBack(new KeyboardTEMPHelper.KeyboardCallBack() {
            @Override
            public void keyCall(int code) {
                //回调键盘监听，根据回调的code值进行处理
            }
        });
        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //多条件判断，防止重复显示
                if (content.hasFocus() && !helper.isVisibility() && event.getAction() == MotionEvent.ACTION_DOWN) {
                    helper.show();
                }
                return false;
            }
        });


    }
    public void draw(View view) {
        double x, y;
        x = -50;
        GraphView graph = findViewById(R.id.graph);
        series1 = new LineGraphSeries<>();
        String INFIX = content.getText().toString();
        INFIX = INFIX.replace("abs","A");
        INFIX = INFIX.replace("sin","S");
        INFIX = INFIX.replace("cos","C");
        INFIX = INFIX.replace("tan","T");
        INFIX = INFIX.replace("ln","L");
       //  INFIX="(x^2)+3";
        String POSTFIX = "48";
        POSTFIX = Infix.toPostfix(INFIX);
        //show1.setText(INFIX);
        //show2.setText(POSTFIX);
        if(!INFIX.isEmpty())
        {
            for (int i = -50; i < 1000; i++) {
                x=x+0.1;
                y = PostfixEvaluation.cal(POSTFIX,x);
                //show3.setText(Double.toString(y));
                series1.appendData(new DataPoint(x, y), true, 999);
            }
        }
        graph.removeAllSeries();
        graph.addSeries(series1);
        graph.getViewport().setMinX(-50);
        graph.getViewport().setMaxX(50);
        graph.getViewport().setMinY(-50.0);
        graph.getViewport().setMaxY(50.0);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollableY(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
    }
}
