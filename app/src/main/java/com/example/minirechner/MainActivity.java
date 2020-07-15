package com.example.minirechner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.pm.ActivityInfo;
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
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
            mViewModel.add();
            field3.setText(mViewModel.getResult().toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void mySubtract(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.subtract();
            field3.setText(mViewModel.getResult().toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myMultiply(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.multiply();
            field3.setText(mViewModel.getResult().toString());
        } catch (NumberFormatException e) {
            field3.setText(getResources().getText(R.string.errorNumberFormat));
        }
    }

    public void myDivide(View v) {
        this.hideKeyboard(v);
        try {
            this.storeUserInput();
            mViewModel.divide();
            field3.setText(mViewModel.getResult().toString());
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
        if(mViewModel.getMemory()!=null) {
            field1.setText(mViewModel.getMemory().toString());
            mViewModel.setNumber1(mViewModel.getMemory());
        } else {
            field3.setText(getResources().getText(R.string.memoryEmpty));
        }
    }

    public void myDelete(View v) {
        mViewModel.setMemory(null);
        field3.setText(getResources().getText(R.string.delete));
    }

    public void storeUserInput(){
        mViewModel.setNumber1(this.editTextToDouble(field1));
        mViewModel.setNumber2(this.editTextToDouble(field2));
    }

    public void myDeleteUserInput(View v) {
        mViewModel.setNumber1(null);
        mViewModel.setNumber2(null);
        field1.setText("");
        field2.setText("");
        field3.setText("");
    }
}

