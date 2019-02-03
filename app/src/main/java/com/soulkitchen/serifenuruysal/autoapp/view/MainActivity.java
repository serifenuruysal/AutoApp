package com.soulkitchen.serifenuruysal.autoapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.soulkitchen.serifenuruysal.autoapp.R;
import com.soulkitchen.serifenuruysal.autoapp.databinding.MainActivityBinding;
import com.soulkitchen.serifenuruysal.autoapp.viewModel.SelectionViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {
    MainActivityBinding binding;
    List<String> mainTypes = new ArrayList<String>();
    List<String> manufacturer = new ArrayList<String>();
    List<String> buildDate = new ArrayList<String>();
    ArrayAdapter<String> manufacturerAdapter;
    ArrayAdapter<String> mainTypesAdapter;
    ArrayAdapter<String> cbuildDateAdapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new SelectionViewModel());
        binding.getViewModel().getManufacturer(0);
        binding.setLifecycleOwner(this);

        binding.mySpinnerM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 if (position != -1)
                    binding.getViewModel().getMainTypes(manufacturer.get(position));

                mainTypes.clear();
                mainTypesAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, mainTypes);
                mainTypesAdapter.notifyDataSetChanged();
                binding.mySpinnerMt.setHint("Select a Main Type");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.mySpinnerMt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != -1)
                    binding.getViewModel().getBuildDates(mainTypes.get(position));

                buildDate.clear();

                cbuildDateAdapte = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, buildDate);
                cbuildDateAdapte.notifyDataSetChanged();
                binding.mySpinnerBd.setHint("Select a Build Date");
                binding.mySpinnerBd.setSelection(0);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.getViewModel().getManufacturerMap().observe(this, new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> it) {

                Iterator iterator = it.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    manufacturer.add(me2.getValue().toString());

                }
                manufacturerAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, manufacturer);
                binding.mySpinnerM.setAdapter(manufacturerAdapter);

            }
        });

        binding.getViewModel().getMainTypesMap().observe(this, new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> it) {
                Iterator iterator = it.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    mainTypes.add(me2.getValue().toString());

                }
                mainTypesAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, mainTypes);
                binding.mySpinnerMt.setAdapter(mainTypesAdapter);
            }
        });

        binding.getViewModel().getBuildDateMap().observe(this, new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> it) {
                Iterator iterator = it.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    buildDate.add(me2.getValue().toString());

                }
                cbuildDateAdapte = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, buildDate);
                binding.mySpinnerBd.setAdapter(cbuildDateAdapte);

            }
        });



    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
