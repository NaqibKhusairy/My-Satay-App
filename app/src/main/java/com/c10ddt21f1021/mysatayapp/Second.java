package com.c10ddt21f1021.mysatayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    EditText name,phone,PAyam,PDaging,PKambing;
    CheckBox ayam,daging,kambing;
    Button next;
    String Name,Phone;
    int Ayam,Daging,Kambing;
    Double HAayam,HDaging,HKambing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name=findViewById(R.id.etname);
        phone=findViewById(R.id.etphone);
        PAyam=findViewById(R.id.etayam);
        PDaging=findViewById(R.id.etdaging);
        PKambing=findViewById(R.id.etkambing);
        ayam=findViewById(R.id.cbayam);
        daging=findViewById(R.id.cbdaging);
        kambing=findViewById(R.id.cbkambing);
        next=findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=name.getText().toString();
                Phone=phone.getText().toString();
                if(ayam.isChecked()){
                    Ayam=Integer.parseInt(PAyam.getText().toString());
                    HAayam=Ayam*0.60;
                }
                else if (!ayam.isChecked()){
                    Ayam=0;
                    HAayam=Ayam*0.60;
                }
                if(daging.isChecked()){
                    Daging=Integer.parseInt(PDaging.getText().toString());
                    HDaging=Daging*0.70;
                }
                else if (!daging.isChecked()){
                    Daging=0;
                    HDaging=Daging*0.70;
                }
                if(kambing.isChecked()){
                    Kambing=Integer.parseInt(PKambing.getText().toString());
                    HKambing=Kambing*0.90;
                }
                else if (!kambing.isChecked()){
                    Kambing=0;
                    HKambing=Kambing*0.90;
                }

                Intent i= new Intent(getApplicationContext(),Third.class);
                Bundle b=new Bundle();
                b.putString("Nama",Name);
                b.putString("PhoneNum",Phone);
                b.putInt("Ayam",Ayam);
                b.putInt("Daging",Daging);
                b.putInt("Kambing",Kambing);
                b.putDouble("HAayam",HAayam);
                b.putDouble("HDaging",HDaging);
                b.putDouble("HKambing",HKambing);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}