package com.c10ddt21f1021.mysatayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Third extends AppCompatActivity {

    CheckBox NI,KK,C,O;
    RadioGroup rg;
    RadioButton TA,DI;
    Button next;
    String Name,Phone,Dining="";
    int Ayam,Daging,Kambing;
    Double HAayam,HDaging,HKambing,HNI,NKK,HC,HO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        NI=findViewById(R.id.cbnasiimpit);
        KK=findViewById(R.id.cbkuahkacang);
        C=findViewById(R.id.cbcucumber);
        O=findViewById(R.id.cbonion);
        rg=findViewById(R.id.rgdining);
        TA=findViewById(R.id.rbtakeaway);
        DI=findViewById(R.id.rbdinein);
        next=findViewById(R.id.button);

        Bundle b=getIntent().getExtras();
        Name=b.getString("Nama");
        Phone=b.getString("PhoneNum");
        Ayam=b.getInt("Ayam");
        Daging=b.getInt("Daging");
        Kambing=b.getInt("Kambing");
        HAayam=b.getDouble("HAayam");
        HDaging=b.getDouble("HDaging");
        HKambing=b.getDouble("HKambing");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NI.isChecked())
                {
                    HNI=2.00;
                }
                else if (!NI.isChecked())
                {
                    HNI=0.00;
                }
                if (KK.isChecked())
                {
                    NKK=2.00;
                }
                else if (!KK.isChecked())
                {
                    NKK=0.00;
                }
                if (C.isChecked())
                {
                    HC=1.00;
                }
                else if (!C.isChecked())
                {
                    HC=0.00;
                }
                if (O.isChecked())
                {
                    HO=0.50;
                }
                else if (!O.isChecked())
                {
                    HO=0.00;
                }
                if(TA.isChecked()){
                    Dining="Take Away";
                }
                else if(DI.isChecked()){
                    Dining="Dine In";
                }
                if(Dining.equals("")){
                    Toast.makeText(Third.this, "Please choose Your Dining Option", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i= new Intent(getApplicationContext(),Final.class);
                    Bundle b=new Bundle();
                    b.putString("Nama",Name);
                    b.putString("PhoneNum",Phone);
                    b.putInt("Ayam",Ayam);
                    b.putInt("Daging",Daging);
                    b.putInt("Kambing",Kambing);
                    b.putDouble("HAayam",HAayam);
                    b.putDouble("HDaging",HDaging);
                    b.putDouble("HKambing",HKambing);
                    b.putDouble("HNI",HNI);
                    b.putDouble("NKK",NKK);
                    b.putDouble("HC",HC);
                    b.putDouble("HO",HO);
                    b.putString("Dining",Dining);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
}