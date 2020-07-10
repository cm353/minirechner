package com.example.minirechner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText field1;
    private EditText field2;
    private TextView field3;
    private CalculatorViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 =  findViewById(R.id.editTextNumber1);
        field2 =  findViewById(R.id.editTextNumber2);
        field3 =  findViewById(R.id.editTextResult);
        mViewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(mViewModel.getIndex()!=0)
            field3.setText(mViewModel.getResult().toString());
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
            this.storeUserInput();
            mViewModel.setResult(CalculatorUtil.add(mViewModel.getNumber1(),mViewModel.getNumber2()));
            field3.setText(mViewModel.getResult().toString());
            mViewModel.count();
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void mySubtract(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.setResult(CalculatorUtil.subtract(mViewModel.getNumber1(), mViewModel.getNumber2()));
            field3.setText(mViewModel.getResult().toString());
            mViewModel.count();
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myMultiply(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.setResult(CalculatorUtil.multiply(mViewModel.getNumber1(), mViewModel.getNumber2()));
            field3.setText(mViewModel.getResult().toString());
            mViewModel.count();
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myDivide(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.setResult(CalculatorUtil.divide(mViewModel.getNumber1(), mViewModel.getNumber2()));
            field3.setText(mViewModel.getResult().toString());
            mViewModel.count();
        } catch (ArithmeticException e) {
            field3.setText(getResources().getText(R.string.errorDivBy0));
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void mySave(View v) {
        mViewModel.setMemory(mViewModel.getResult());
    }

    public void myLoad(View v) {
        field2.setText(mViewModel.getMemory().toString());
        mViewModel.setNumber2(mViewModel.getMemory());
    }

    public void myDelete(View v) {
        mViewModel.setMemory(0.0);
        field3.setText(getResources().getText(R.string.delete));
    }

    public void storeUserInput(){
        mViewModel.setNumber1(this.editTextToDouble(field1));
        mViewModel.setNumber2(this.editTextToDouble(field2));
    }

}

