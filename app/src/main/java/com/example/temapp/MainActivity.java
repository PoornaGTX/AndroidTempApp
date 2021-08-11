package com.example.temapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCal=findViewById(R.id.btnCal);
    }

    protected void onResume(){
        super.onResume();

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTemp();

            }
        });

    } //end of onResume

    private void calculateTemp(){

        EditText et = findViewById(R.id.etTemp);
        String temp = et.getText().toString();

        if(temp.equals("") ){
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        }

        else{

            Float TempNumber=0.0f;
            Boolean error=Boolean.FALSE;

            Float answer = 0.0f;

            try{
                TempNumber=  Float.parseFloat(temp);
            }
            catch(NumberFormatException e){
                Toast.makeText(this, "invalid entry", Toast.LENGTH_LONG).show();
                error=true;
            }

            if(!error){

                RadioGroup rg = findViewById(R.id.rgTemp);
                int id = rg.getCheckedRadioButtonId();

                TextView tv =findViewById(R.id.tvSult);


                if(id==R.id.rbCel){

                    answer=convertFahrenheitToCelcius(TempNumber);

                }
                else{
                    answer=convertCelciusToFahrenheit(TempNumber);
                }

                tv.setText(answer+"");

            }
        }



        }

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }








}