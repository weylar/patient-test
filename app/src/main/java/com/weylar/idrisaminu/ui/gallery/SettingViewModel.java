package com.weylar.idrisaminu.ui.gallery;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.weylar.idrisaminu.data.Util.Constants;

public class SettingViewModel extends AndroidViewModel {

    private MutableLiveData<String> username;
    private MutableLiveData<Integer> noOfPatient;
    private MutableLiveData<Integer> maxPatient;
    private SharedPreferences prefs;

    public SettingViewModel(Application application) {
        super(application);
        username = new MutableLiveData<>();
        noOfPatient = new MutableLiveData<>();
        maxPatient = new MutableLiveData<>();

        prefs = application.getSharedPreferences("my_app", Context.MODE_PRIVATE);
    }

    public LiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String userName){
        this.username.postValue(userName);
    }

    public void setNoOfPatient(int noOfPerson){
        this.noOfPatient.postValue(noOfPerson);
    }

    public LiveData<Integer> getNoOfPatient() {
        return noOfPatient;
    }

    public void setMaxPatient(int maxPatient){
        this.maxPatient.postValue(maxPatient);
    }

    public LiveData<Integer> getMaxPatient() {
        return maxPatient;
    }
}