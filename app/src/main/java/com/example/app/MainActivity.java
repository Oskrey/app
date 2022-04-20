package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  String inputFine(Double db)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.#№##");
        String str = decimalFormat.format(db);
        return str;
    }

    public void ButtonOnClick(View view){
        double a, b, c, P, S ;
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

        a = Double.parseDouble(editTextA.getText().toString());
        b = Double.parseDouble(editTextB.getText().toString());
        c = Double.parseDouble(editTextC.getText().toString());

        Triangle triangle = new Triangle();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);

        if (!checkPerimeter.isChecked() && !checkSquare.isChecked())
        {
            alertBuilder.setMessage("Выберите операцию: найти площадь и/или периметр").setTitle("Подсказка").show();
        }

        if (!triangle.isExist(a,b,c))
        {
            alertBuilder.setMessage("Треугольника с заданными параметрами не существует!")
                    .setCancelable(false)
                    .setIcon(R.drawable.triangle_error)
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel())
                    .setTitle("Ошибка").setIcon(R.drawable.triangle_error).show();
        }

        if (checkPerimeter.isChecked() && checkSquare.isChecked() && triangle.isExist(a,b,c))
        {
            P = triangle.perimeter(a, b, c);
            S = triangle.square(a, b, c);
            alertBuilder.setMessage("Периметр: "+ inputFine(P) +"\n"+"Площадь: "+ inputFine(S))
                    .setTitle("Периметр и площадь").show();
        }

        if (checkPerimeter.isChecked() && triangle.isExist(a,b,c))
        {
            P = triangle.perimeter(a, b, c);
            alertBuilder.setMessage("Периметр: "+ inputFine(P)).setTitle("Периметр").show();
        }

        if (checkSquare.isChecked() && triangle.isExist(a,b,c))
        {
            S = triangle.square(a, b, c);
            alertBuilder.setMessage("Площадь: "+ inputFine(S)).setTitle("Площадь").show();
        }

    }
}