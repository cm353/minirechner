package com.example.minirechner;

import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private Double number1 = null;
    private Double number2 = null;
    private Double result = null;
    private Double memory = null;
    private int index = 0;

    public Double getResult() {
        return result;
    }

    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public int getIndex() {
        return index;
    }

    private void count(){
        index++;
    }

    public void add() throws IllegalArgumentException {
        if(this.checkIfNull())
            throw new IllegalArgumentException();
        result = CalculatorUtil.add(number1, number2);
        this.count();
    }

    public void subtract () throws IllegalArgumentException {
        if(this.checkIfNull())
            throw new IllegalArgumentException();
        result = CalculatorUtil.subtract(number1, number2);
        this.count();
    }

    public void multiply() throws IllegalArgumentException {
        if(this.checkIfNull())
            throw new IllegalArgumentException();
        result = CalculatorUtil.multiply(number1, number2);
        this.count();
    }

    public void divide() throws ArithmeticException, IllegalArgumentException {
        if(this.checkIfNull())
            throw new IllegalArgumentException();
        result = CalculatorUtil.divide(number1, number2);
        this.count();
    }

    public  boolean checkIfNull() {
        return number1 == null || number2 == null;
    }

}
