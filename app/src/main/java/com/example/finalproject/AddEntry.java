package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddEntry extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DAY = "param1";
    private static final String TIME = "param2";
    private static final String LOCATION = "param3";
    private static final String MOOD = "param4";
    private static final String THOUGHTS = "param5";

    private String day, time, location, mood, thoughts;
    private Button button2, addButton;
    private DatabaseHelper databaseHelper;
    private EditText vDay, vTime, vLocation, vMood, vThoughts;
    private List<JournalData> entriesList;
    private ListAdapter adapter;

    public AddEntry() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper = new DatabaseHelper(getContext());
        entriesList = databaseHelper.getAllEntries();
        if (getArguments() != null) {
            day = getArguments().getString(DAY);
            time = getArguments().getString(TIME);
            location = getArguments().getString(LOCATION);
            mood = getArguments().getString(MOOD);
            thoughts = getArguments().getString(THOUGHTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_entry, container, false);

        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        addButton = view.findViewById(R.id.addEntry);
        addButton.setOnClickListener(this);

        vDay = view.findViewById(R.id.editText);
        vTime = view.findViewById(R.id.editText2);
        vLocation = view.findViewById(R.id.editText3);
        vMood = view.findViewById(R.id.editText4);
        vThoughts = view.findViewById(R.id.editText6);

        adapter = new ListAdapter(entriesList);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            Navigation.findNavController(v).navigate(R.id.action_add_entry_to_view_entries);
        }

        if (v.getId() == R.id.addEntry) {
            String day = vDay.getText().toString();
            String time = vTime.getText().toString();
            String location = vLocation.getText().toString();
            String mood = vMood.getText().toString();
            String thoughts = vThoughts.getText().toString();

            if (!day.isEmpty() && !time.isEmpty() && !location.isEmpty() && !mood.isEmpty() && !thoughts.isEmpty()) {
                databaseHelper.insertData(day, time, location, mood, thoughts);
                entriesList.clear();
                entriesList.addAll(databaseHelper.getAllEntries());
                adapter.notifyDataSetChanged();

                vDay.setText("");
                vTime.setText("");
                vLocation.setText("");
                vMood.setText("");
                vThoughts.setText("");
            }
        }
    }
}