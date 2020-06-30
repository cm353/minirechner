package com.example.minirechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText field1;
    EditText field2;
    TextView field3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 =  findViewById(R.id.editTextNumber1);
        field2 =  findViewById(R.id.editTextNumber2);
        field3 =  findViewById(R.id.editTextResult);
    }

    public void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public  Double editTextToDouble(EditText field) throws NumberFormatException {
        return Double.parseDouble(field.getText().toString().replace(",", "."));
    }

    public void myAdd(View v) {
        this.hideKeyboard(v);
        try {
            Double result = CalculatorUtil.add(this.editTextToDouble(field1), this.editTextToDouble(field2));
            field3.setText(result.toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void mySubtract(View v) {
        this.hideKeyboard(v);
        try {
            Double result = CalculatorUtil.subtract(this.editTextToDouble(field1), this.editTextToDouble(field2));
            field3.setText(result.toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myMultiply(View v) {
        this.hideKeyboard(v);
        try {
            Double result = CalculatorUtil.multiply(this.editTextToDouble(field1), this.editTextToDouble(field2));
            field3.setText(result.toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myDivide(View v) {
        this.hideKeyboard(v);
        try {
            Double result = CalculatorUtil.divide(this.editTextToDouble(field1), this.editTextToDouble(field2));
            field3.setText(result.toString());
        } catch (ArithmeticException e) {
            field3.setText(getResources().getText(R.string.errorDivBy0));
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

}

