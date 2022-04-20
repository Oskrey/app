package com.example.app;

public class Triangle {

    public double perimeter(double a, double b, double c){
        double P = a + b + c;
        return P;
    }

    public boolean isExist(double a, double b, double c){
        Boolean isExist = false;
        if((a<b+c)&&(b<a+c)&&(c<a+b))
            isExist = true;
        return isExist;
    }

    public double square(double a, double b, double c){
        double p = (a + b + c)/2;
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return  S;
    }

}
