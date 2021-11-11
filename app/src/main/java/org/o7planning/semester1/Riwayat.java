package org.o7planning.semester1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Riwayat extends AppCompatActivity {
    ListView simpleList;
    Game soal=new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riwayat);


        simpleList=findViewById(R.id.simpleList);
        Intent y= getIntent();
        ArrayList values= y.getStringArrayListExtra("jawaban");
        ArrayAdapter jawabanadapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,values);
        simpleList.setAdapter(jawabanadapter);
        System.out.println(soal.getJawaban());
    }

}
