package com.c10ddt21f1021.mysatayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Final extends AppCompatActivity {

    TextView Output;
    Button Submit;
    String Name,Phone,Dining;
    int Ayam,Daging,Kambing;
    Double HAayam,HDaging,HKambing,HNI,NKK,HC,HO,EC,SubTotal,ST,TACHARGE,NetTotl;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Output=findViewById(R.id.textView4);
        Submit=findViewById(R.id.button);

        Bundle b=getIntent().getExtras();
        Name=b.getString("Nama");
        Phone=b.getString("PhoneNum");
        Ayam=b.getInt("Ayam");
        Daging=b.getInt("Daging");
        Kambing=b.getInt("Kambing");
        HAayam=b.getDouble("HAayam");
        HDaging=b.getDouble("HDaging");
        HKambing=b.getDouble("HKambing");
        HNI=b.getDouble("HNI");
        NKK=b.getDouble("NKK");
        HC=b.getDouble("HC");
        HO=b.getDouble("HO");
        Dining=b.getString("Dining");
        EC=HNI+NKK+HC+HO;
        SubTotal=HAayam+HDaging+HKambing+HKambing+EC;
        ST=SubTotal*0.06;
        if(Dining.equals("Take Away"))
        {
            TACHARGE=2.00;
        }
        else{
            TACHARGE=0.00;
        }
        NetTotl=SubTotal+ST+TACHARGE;
        Output.setText("-------------------------------------------------------------------------" +
                "\n-------------------------------------------------------------------------" +
                "\n\t***"+Dining+"***" +
                "\n-------------------------------------------------------------------------" +
                "\n-------------------------------------------------------------------------" +
                "\nName : "+Name+"\nPhone Number : "+Phone+"\nSatay Ayam : "+Ayam+" Pieces" +
                "\nPrice : RM "+String.format("%.2f",HAayam)+"\nSatay Daging : "+Daging+" Pieces" +
                "\nPrice : RM "+String.format("%.2f",HDaging)+"\nSatay Kambing : "+Kambing+" Pieces" +
                "\nPrice : RM "+String.format("%.2f",HKambing)+"\nExtra Charge : RM "+String.format("%.2f",EC)+
                "\n-------------------------------------------------------------------------" +
                "\n-------------------------------------------------------------------------" +
                "\nSub Total : RM "+String.format("%.2f",SubTotal)+"\nService Tac @ 6% : RM "+String.format("%.2f",ST)+
                "\nTake Away Charge : RM "+String.format("%.2f",TACHARGE)+
                "\n-------------------------------------------------------------------------" +
                "\n-------------------------------------------------------------------------" +
                "\nNet Total : RM "+String.format("%.2f",NetTotl)+
                "\n-------------------------------------------------------------------------" +
                "\n-------------------------------------------------------------------------" );

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Final.this, "Order Submited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}