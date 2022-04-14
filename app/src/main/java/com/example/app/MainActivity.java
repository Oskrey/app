package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonOnClick(View view){
        int a, b, c, P, S;
        CheckBox checkSquare = findViewById(R.id.checkBox);
        CheckBox checkPerimeter = findViewById(R.id.checkBox2);

        EditText editTextA = findViewById(R.id.editTextTextPersonName);
        EditText editTextB = findViewById(R.id.editTextTextPersonName2);
        EditText editTextC = findViewById(R.id.editTextTextPersonName3);

        if (editTextA.getText().length() == 0)
            editTextA.setText("0");
        if (editTextB.getText().length() == 0)
            editTextB.setText("0");
        if (editTextC.getText().length() == 0)
            editTextC.setText("0");

        a = Integer.parseInt(editTextA.getText().toString());
        b = Integer.parseInt(editTextB.getText().toString());
        c = Integer.parseInt(editTextC.getText().toString());

        Triangle triangle = new Triangle();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);

        if (!checkPerimeter.isChecked() && !checkSquare.isChecked())
        {
            alertBuilder.setMessage("Выберите операцию: найти площадь и/или периметр");
            AlertDialog alert = alertBuilder.create();
            alert.setTitle("Подсказка");
            alert.show();
        }
        else
        {
            if (!triangle.Exist(a,b,c))
            {
                alertBuilder.setMessage("Треугольника с заданными параметрами не существует!")
                        .setCancelable(false)
                        .setIcon(R.drawable.triangle_error)
                        .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.setTitle("Ошибка");
                alertDialog.setIcon(R.drawable.triangle_error);
                alertDialog.show();
            }

            if (checkPerimeter.isChecked() && checkSquare.isChecked() && triangle.Exist(a,b,c))
            {
                P = triangle.Perimeter(a, b, c);
                S = triangle.Square(a, b, c);
                alertBuilder.setMessage("Периметр: "+ P +"\n"+"Площадь: "+ S);
                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Периметр и площадь");
                alert.show();
            }
            else
            {
                if (checkPerimeter.isChecked() && triangle.Exist(a,b,c))
                {
                    P = triangle.Perimeter(a, b, c);
                    alertBuilder.setMessage("Периметр: "+ P);
                    AlertDialog alert = alertBuilder.create();
                    alert.setTitle("Периметр");
                    alert.show();
                }

                if (checkSquare.isChecked() && triangle.Exist(a,b,c))
                {
                    S = triangle.Square(a, b, c);
                    alertBuilder.setMessage("Площадь: "+ S);
                    AlertDialog alert = alertBuilder.create();
                    alert.setTitle("Площадь");
                    alert.show();
                }
            }
        }
    }
}