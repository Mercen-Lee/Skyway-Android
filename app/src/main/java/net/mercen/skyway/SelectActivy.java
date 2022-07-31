package net.mercen.skyway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class SelectActivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Button nextbtn1 = findViewById(R.id.nextbtn1);
        nextbtn1.setVisibility(View.INVISIBLE);
        Spinner daedae = (Spinner) findViewById(R.id.daedae_spinner);
        Spinner joongdae = (Spinner) findViewById(R.id.joongdae_spinner);
        Spinner ban = (Spinner) findViewById(R.id.ban_spinner);
        Spinner joe = (Spinner) findViewById(R.id.joe_spinner);
        LinearLayout joonglinear = findViewById(R.id.joonglinear);
        joonglinear.setVisibility(View.INVISIBLE);
        LinearLayout banlinear = findViewById(R.id.banlinear);
        banlinear.setVisibility(View.INVISIBLE);
        LinearLayout joelinear = findViewById(R.id.joelinear);
        joelinear.setVisibility(View.INVISIBLE);

        daedae.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String infor = daedae.getSelectedItem().toString();
                if(infor.equals("선택안함")){
                    joonglinear.setVisibility(View.INVISIBLE);
                } else {
                    joonglinear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        joongdae.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String infor = joongdae.getSelectedItem().toString();
                if(infor.equals("선택안함")){
                    banlinear.setVisibility(View.INVISIBLE);
                } else {
                    banlinear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ban.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String infor = ban.getSelectedItem().toString();
                if(infor.equals("선택안함")){
                    joelinear.setVisibility(View.INVISIBLE);
                    nextbtn1.setVisibility(View.INVISIBLE);
                } else {
                    joelinear.setVisibility(View.VISIBLE);
                    nextbtn1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        nextbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NameActivity.class);
                String daestr = (String) daedae.getSelectedItem();
                String jngstr = (String) joongdae.getSelectedItem();
                String banstr = (String) ban.getSelectedItem();
                String joestr = (String) joe.getSelectedItem();
                intent.putExtra("daedae",daestr);
                intent.putExtra("joongdae",jngstr);
                intent.putExtra("ban",banstr);
                intent.putExtra("joe",joestr);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
    }
}