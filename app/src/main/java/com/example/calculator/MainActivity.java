package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operator;
    private int value1 = 0;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result_text_view);
    }

    public void onNumberClicked(View view) {
        Button b = (Button) view;
        String number = b.getText().toString();

        String current = (String) resultTextView.getText();

        resultTextView.setText(current + number);
    }

    public void onOperatorClicked(View view) {
        Button b = (Button) view;
        operator = b.getText().toString();
        value1 = Integer.parseInt((String) resultTextView.getText());
        // reset text view
        resultTextView.setText("");
        resultTextView.setHint(value1 + " " + operator + " ");
    }

    public void onEqualClicked(View view) {
        // Save value2
        int value2 = Integer.parseInt((String) resultTextView.getText());

        switch (operator) {
            case "+":
                int result = value1 + value2;
                resultTextView.setText(Integer.toString(result));
                break;
            default:
                Log.d("MyApp", "I don't know");
                break;
        }
    }
}
