package com.weylar.idrisaminu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.weylar.idrisaminu.R;
import com.weylar.idrisaminu.data.Util.Constants;
import com.weylar.idrisaminu.model.Gender;
import com.weylar.idrisaminu.model.Patient;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.list);
        final FloatingActionButton fab = root.findViewById(R.id.fab);
        final EditText fullName = root.findViewById(R.id.fullname);
        final EditText age = root.findViewById(R.id.age);
        final EditText email = root.findViewById(R.id.email);
        final RadioGroup gender = root.findViewById(R.id.gender);
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        Toast.makeText(getContext(), "Welcome " +
                getContext().getSharedPreferences("my_app", Context.MODE_PRIVATE)
                        .getString(Constants.USERNAME, " ") , Toast.LENGTH_LONG).show();

        fab.setOnClickListener( v -> {
            Gender genderV;
            switch (gender.getCheckedRadioButtonId()){
                case R.id.male:
                    genderV = Gender.MALE;
                    break;
                case R.id.female:
                    genderV = Gender.FEMALE;
                    break;
                case R.id.other:
                    genderV = Gender.OTHERS;
                default:
                    genderV = Gender.MALE;
            }
            Patient patient = new Patient(fullName.getText().toString(),
                    Integer.parseInt(age.getText().toString()),
                    email.getText().toString(), genderV);

            textView.append("Full name: " + patient.getName() + "\nEmail: "+  patient.getEmail() + "\nAge: " +
                    patient.getAge() + "\nGender: " + patient.getGender().name() + "\n");
        });

        return root;
    }
}