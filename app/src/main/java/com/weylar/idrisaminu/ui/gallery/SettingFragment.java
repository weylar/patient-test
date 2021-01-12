package com.weylar.idrisaminu.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.weylar.idrisaminu.R;

public class SettingFragment extends Fragment {

    private SettingViewModel settingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        final EditText usernameEdit = root.findViewById(R.id.username_edittext);
        final EditText noOfPatient = root.findViewById(R.id.no_of_patient_edit);
        final EditText maxPatient = root.findViewById(R.id.max_patient_edit);
        final Button save = root.findViewById(R.id.save);

        settingViewModel.getUsername().observe(getViewLifecycleOwner(), usernameEdit::setText);
        settingViewModel.getNoOfPatient().observe(getViewLifecycleOwner(), integer -> {noOfPatient.setText(integer.toString());} );
        settingViewModel.getMaxPatient().observe(getViewLifecycleOwner(),integer -> {maxPatient.setText(integer.toString());});

        save.setOnClickListener(v -> {
           settingViewModel.setUsername(usernameEdit.getText().toString());
           settingViewModel.setNoOfPatient(Integer.parseInt(noOfPatient.getText().toString()));
           settingViewModel.setMaxPatient(Integer.parseInt(maxPatient.getText().toString()));
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_LONG).show();
        });
        return root;
    }
}