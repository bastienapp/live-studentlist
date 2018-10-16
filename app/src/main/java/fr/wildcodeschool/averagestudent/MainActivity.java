package fr.wildcodeschool.averagestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.bt_send);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName = findViewById(R.id.et_name);
                EditText etNote1 = findViewById(R.id.et_note1);
                EditText etNote2 = findViewById(R.id.et_note2);
                EditText etNote3 = findViewById(R.id.et_note3);
                String name = etName.getText().toString();
                String note1Str = etNote1.getText().toString();
                String note2Str = etNote2.getText().toString();
                String note3Str = etNote3.getText().toString();
                if (name.isEmpty() || note1Str.isEmpty()
                        || note2Str.isEmpty() || note3Str.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "No !", Toast.LENGTH_SHORT).show();
                } else {
                    int note1 = Integer.parseInt(note1Str);
                    int note2 = Integer.parseInt(note2Str);
                    int note3 = Integer.parseInt(note3Str);
                    // TODO enregistrer dans Firebase
                }
            }
        });

        Button btStudentList = findViewById(R.id.bt_studentlist);
        btStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO aller vers la liste des étudiants
                Intent goToStudentList = new Intent(MainActivity.this, StudentListActivity.class);
                startActivity(goToStudentList);
            }
        });
    }
}
