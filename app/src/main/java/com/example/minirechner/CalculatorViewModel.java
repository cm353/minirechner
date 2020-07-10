package com.example.minirechner;

import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private Double number1 = 0.0;
    private Double number2 = 0.0;
    private Double result = 0.0;
    private Double memory = 0.0;
    private int index = 0;

    public Double getNumber1() {
        return number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public Double getResult() {
        return result;
    }

    public Double getMemory() {
        return memory;
    }

    public int getIndex() {
        return index;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public void count(){
        index++;
    }

}
