package ydh.gtbrain.yourdiethelper.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ydh.gtbrain.yourdiethelper.R;

public class Main_diet extends Fragment {

    Spinner spinner;
    Button b_calculate;
    View v;
    String[] data = {"one", "two", "three", "four", "five"};
    SharedPreferences sPref;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v =inflater.inflate(R.layout.fragment_main_diet,container,false);
        spinner = (Spinner) v.findViewById(R.id.s_chooseDiet);
        b_calculate = (Button) v.findViewById(R.id.b_calculateDiet);
        sPref = getActivity().getSharedPreferences("MyDateBase",getActivity().MODE_PRIVATE);
        editor=sPref.edit();

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);//simple_spinner_dropdown_item
        spinner.setAdapter(adapter);
        spinner.setPrompt("Title");

        if(sPref.getInt("ChoosedDietPosition", -1) != -1)
        {
            spinner.setSelection(sPref.getInt("ChoosedDietPosition", -1));
        }
        else
        {
            spinner.setSelection(1);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {

                editor.putString("ChoosedDiet", "Diet " + spinner.getSelectedItem().toString());
                editor.putInt("ChoosedDietPosition", spinner.getSelectedItemPosition());
                editor.commit();
                Toast.makeText(getContext(), "Your diet is: " + sPref.getString("ChoosedDiet", "nothing"), Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO calculating diet
                Toast.makeText(getContext(), "Your diet is: " + sPref.getString("ChoosedDiet", "nothing"), Toast.LENGTH_SHORT).show();
            }
        };
        b_calculate.setOnClickListener(oclBtnOk);

        return v;
    }

}
