package com.newdeveloper.simplecalculator;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static char x='1';
    public static TextView T;
    public static double result = 0.1, M = 0;
    StringBuilder str = new StringBuilder();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculator(View v) {

        Button b = (Button) v;
        T = (TextView) findViewById(R.id.textView2);
        if (v.getId() == R.id.buttonC) {
            str.delete(0, str.length());
            result = 0.1;
            x = '1';
            T.setText("0");
        }

        if (v.getId() == R.id.buttonback && str.length() > 0 && result != 0.0) {
            str.deleteCharAt(str.length() - 1);
            T.setText(str);
        }
        if(v.getId() == R.id.buttonback && x=='\0')
        {
            Toast.makeText(this,"YOU CAN'T EDIT RESULT",Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.buttonM && str.length() > 0 && x == '\0') {
            M = Double.parseDouble(str.toString());
            Toast.makeText(this,"SAVE THIS RESULT INTO M",Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.buttonM && x != '\0') {
            str.insert(0, Double.toString(M));
            T.setText(str);
            if (x == '1') x = '\0';
        }

        if (v.getId() == R.id.buttondot || v.getId() == R.id.button0 || v.getId() == R.id.button1 || v.getId() == R.id.button2 || v.getId() == R.id.button3 || v.getId() == R.id.button4 || v.getId() == R.id.button5 || v.getId() == R.id.button6 || v.getId() == R.id.button7 || v.getId() == R.id.button8 || v.getId() == R.id.button9) {
            str.insert(str.length(), b.getText().toString());
            T.setText(str);
        }

        if (v.getId() == R.id.plus ) {
            if(str.length()>0)result = Double.parseDouble(str.toString());
            str.delete(0, str.length());
            x = '+';
        }

        if (v.getId() == R.id.minus) {
            if(str.length()>0)result = Double.parseDouble(str.toString());
            str.delete(0, str.length());
            x = '-';
        }

        if (v.getId() == R.id.multi) {
            if(str.length()>0)result = Double.parseDouble(str.toString());
            str.delete(0, str.length());
            x = '*';
        }

        if (v.getId() == R.id.divi ) {
            if(str.length()>0)result = Double.parseDouble(str.toString());
            str.delete(0, str.length());
            x = '/';
        }

        if (v.getId() == R.id.buttonequal && str.length() > 0 && result != 0) {
            if (x == '+') result += Double.parseDouble(str.toString());
            if (x == '-') result -= Double.parseDouble(str.toString());
            if (x == '*') result *= Double.parseDouble(str.toString());
            if (x == '/') result /= Double.parseDouble(str.toString());

            str.delete(0, str.length());
            str.insert(0, Double.toString(result));
            T.setText(str);
            result = 0.0;
            x = '\0';
        }
    }

}
