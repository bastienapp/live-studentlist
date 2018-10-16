package fr.wildcodeschool.averagestudent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentModel> {

    public StudentAdapter(Context context, ArrayList<StudentModel> students) {
        super(context, 0, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // récupérer l'élément que je veux afficher
        StudentModel studentModel = getItem(position);

        // vérifier si la ligne a déjà été crée
        if (convertView == null) {
            // récupérer le layout de la ligne à afficher
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }

        // récupérer les éléments de la vue dans lequel je veux ajouter les données
        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvAverage = convertView.findViewById(R.id.tv_average);

        // ajouter dans la vue les données
        tvName.setText(studentModel.getName());
        tvAverage.setText(String.valueOf(studentModel.getAverage()));

        // retourner la ligne qui contient les données
        return convertView;
    }
}
