package com.example.app;

public class Triangle {

    public int Perimeter(int a, int b, int c){
        int P = a + b + c;
        return P;
    }

    public boolean Exist(int a, int b, int c){
        Boolean _triangleExist = false;
        if((a<b+c)&&(b<a+c)&&(c<a+b))
            _triangleExist = true;
        return _triangleExist;
    }

    public int Square(int a, int b, int c){
        double p = (a + b + c)/2;
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return (int) S;
    }
}
