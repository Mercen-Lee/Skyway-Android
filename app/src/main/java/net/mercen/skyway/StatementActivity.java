package net.mercen.skyway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatementActivity extends AppCompatActivity {
    String state = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        Intent intent = getIntent();
        String soldiername = intent.getStringExtra("name");
        TextView ing = findViewById(R.id.ing);
        ing.setText(soldiername+"병사님은\n현재 "+state+"중!");
        Button workbtn = findViewById(R.id.work_state);
        Button otjbtn = findViewById(R.id.ojt_state);
        Button vacbtn = findViewById(R.id.vacation_state);
        Button waitbtn = findViewById(R.id.wait_state);
        workbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = workbtn.getText().toString();
                ing.setText(soldiername+"병사님은\n현재 "+state+"중!");
            }
        });
        otjbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = otjbtn.getText().toString();
                ing.setText(soldiername+"병사님은\n현재 "+state+"중!");
            }
        });
        vacbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = vacbtn.getText().toString();
                ing.setText(soldiername+"병사님은\n현재 "+state+"중!");
            }
        });
        waitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = waitbtn.getText().toString();
                ing.setText(soldiername+"병사님은\n현재 "+state+"중!");
            }
        });
    }
}