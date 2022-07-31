package net.mercen.skyway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView welcomement = findViewById(R.id.welcomement);
        Intent intent = getIntent();
        String dae_name = intent.getStringExtra("daedae");
        String jng_name = intent.getStringExtra("joongdae");
        String ban_name = intent.getStringExtra("ban");
        String joe_name = intent.getStringExtra("joe");
        String solname = intent.getStringExtra("solname");
        String solnum = intent.getStringExtra("solnum");
        if(joe_name.equals("선택안함")){
            welcomement.setText(dae_name+"\n"+jng_name+"\n"+ban_name+"\n"+solnum+"기\n"+solname+" 병사님 환영합니다!");
        } else {
            welcomement.setText(dae_name+"\n"+jng_name+"\n"+ban_name+"\n"+joe_name+"\n"+solnum+"기\n"+solname+" 병사님 환영합니다!");
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (getApplicationContext(), StatementActivity.class);
                intent.putExtra("name",solname);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        },2000);
    }
}