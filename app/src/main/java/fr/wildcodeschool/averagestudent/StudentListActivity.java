package fr.wildcodeschool.averagestudent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        final ArrayList<StudentModel> students = new ArrayList<>();
        ListView lvStudent = findViewById(R.id.lv_student);

        final StudentAdapter adapter = new StudentAdapter(StudentListActivity.this, students);
        lvStudent.setAdapter(adapter);

        // accès à la base de données
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // je pointe vers ma référence "student"
        DatabaseReference myRef = database.getReference("student");
        // je lis toutes les données contenues dans "student"
        myRef.orderByChild("average").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // dataSnapshot contient toutes les données

                // pour chaque étudiant
                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                    // ajouter mes étudiants à ma liste
                    StudentModel student
                            = studentSnapshot.getValue(StudentModel.class);
                    students.add(student);
                }
                Collections.reverse(students);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
