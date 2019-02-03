package com.soulkitchen.serifenuruysal.autoapp.viewModel;

import com.soulkitchen.serifenuruysal.autoapp.api.ApiClient;
import com.soulkitchen.serifenuruysal.autoapp.models.AutoResponse;

import java.util.HashMap;
import java.util.Map;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by S.Nur Uysal on 3.02.2019.
 */
public class SelectionViewModel  extends ViewModel implements Observable {
    String selectedMainType = "";
    String selectedManufacturer = "";
    MutableLiveData<HashMap<String, String>> mainTypesMap = new MutableLiveData<HashMap<String, String>>();
    MutableLiveData<HashMap<String, String>> manufacturerMap = new MutableLiveData<HashMap<String, String>>();
    MutableLiveData<HashMap<String, String>> buildDateMap = new MutableLiveData<HashMap<String, String>>();

    public SelectionViewModel() {
    }

    public MutableLiveData<HashMap<String, String>> getBuildDateMap() {
        return buildDateMap;
    }

    public MutableLiveData<HashMap<String, String>> getMainTypesMap() {
        return mainTypesMap;
    }

    public MutableLiveData<HashMap<String, String>> getManufacturerMap() {
        return manufacturerMap;
    }


    public void getManufacturer(int page) {
        ApiClient.getInstance().getManufacturer(0, 100).enqueue(new Callback<AutoResponse>() {

            @Override
            public void onResponse(Call<AutoResponse> call, retrofit2.Response<AutoResponse> response) {
                if (response != null && response.body() != null) {
                    AutoResponse result = response.body();
                    HashMap<String, String> map = result.getWkda();
                    manufacturerMap.setValue(map);

                }
            }

            @Override
            public void onFailure(Call<AutoResponse> call, Throwable t) {
            }
        });
    }

    public void getMainTypes(String value) {

        for (Map.Entry<String, String> entry : manufacturerMap.getValue().entrySet()) {
            if (entry.getValue().equals(value)) {
                selectedManufacturer = entry.getKey();
                break;
            }
        }
        ApiClient.getInstance().getMainTypes(0, 50, selectedManufacturer).enqueue(new Callback<AutoResponse>() {

            @Override
            public void onResponse(Call<AutoResponse> call, retrofit2.Response<AutoResponse> response) {
                if (response != null && response.body() != null) {
                    AutoResponse result = response.body();
                    HashMap<String, String> map = result.getWkda();
                    mainTypesMap.setValue(map);

                }
            }

            @Override
            public void onFailure(Call<AutoResponse> call, Throwable t) {
            }
        });
    }


    public void getBuildDates(String value) {

        for (Map.Entry<String, String> entry : mainTypesMap.getValue().entrySet()) {
            if (entry.getValue().equals(value)) {
                selectedMainType = entry.getKey();
                break;
            }
        }
        ApiClient.getInstance().getBuildDates(selectedManufacturer, selectedMainType).enqueue(new Callback<AutoResponse>() {

            @Override
            public void onResponse(Call<AutoResponse> call, retrofit2.Response<AutoResponse> response) {
                if (response != null && response.body() != null) {
                    AutoResponse result = response.body();
                    HashMap<String, String> map = result.getWkda();
                    buildDateMap.setValue(map);
                }
            }

            @Override
            public void onFailure(Call<AutoResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

}
