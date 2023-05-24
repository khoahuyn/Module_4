package com.controller.Service;


public class ComputerServiceimpl implements ComputerService {
    @Override
    public double calculate(double number1, double number2, String calculation) {
        switch (calculation){
            case "+":
                return number1+number2;
            case "-":
                return number1-number2;
            case "*":
                return number1*number2;
            case "/":
                return number1/number2;
        }
        return 0;
    }
}
