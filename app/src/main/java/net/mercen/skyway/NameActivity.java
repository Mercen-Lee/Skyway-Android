package net.mercen.skyway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    boolean name_yes = false;
    boolean num_yes = false;
    String getname;
    String getnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Button nextbtn = findViewById(R.id.nextbtn2);
        nextbtn.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String dae_name = intent.getStringExtra("daedae");
        String jng_name = intent.getStringExtra("joongdae");
        String ban_name = intent.getStringExtra("ban");
        String joe_name = intent.getStringExtra("joe");
        EditText soldiernum = findViewById(R.id.soldiernum);
        EditText soldiername = findViewById(R.id.soldiername);
        soldiernum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int before, int i2) {
                 if(soldiernum.getText().toString().length() != 0){
                     num_yes = true;
                 } else {
                     num_yes = false;
                 }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(num_yes&&name_yes){
                    nextbtn.setVisibility(View.VISIBLE);
                    getname = soldiername.getText().toString();
                    getnum = soldiernum.getText().toString();
                } else {
                    nextbtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        soldiername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(soldiername.getText().toString().length() != 0){
                    name_yes = true;
                } else {
                    name_yes = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(num_yes&&name_yes){
                    nextbtn.setVisibility(View.VISIBLE);
                    getname = soldiername.getText().toString();
                    getnum = soldiernum.getText().toString();
                } else {
                    nextbtn.setVisibility(View.INVISIBLE);
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                intent.putExtra("daedae",dae_name);
                intent.putExtra("joongdae",jng_name);
                intent.putExtra("ban",ban_name);
                intent.putExtra("joe",joe_name);
                intent.putExtra("solname",getname);
                intent.putExtra("solnum",getnum);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
    }
}