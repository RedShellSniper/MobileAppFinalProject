package com.example.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewEntries extends Fragment implements View.OnClickListener {
    private JournalData[] journalData;

    // the fragment initialization parameters
    private static final String DAY = "param1";
    private static final String TIME = "param2";
    private static final String LOCATION = "param3";
    private static final String MOOD = "param4";
    private static final String THOUGHTS = "param5";

    public ViewEntries(JournalData[] journalData) {
        this.journalData = journalData;
    }

    private String day, time, location, mood, thoughts;
    private Button button3, button4;

    public ViewEntries() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View view = inflater.inflate(R.layout.fragment_view_entries, container, false);
        button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            Navigation.findNavController(v).navigate(R.id.action_view_entries_to_add_entry);
        }

        if (v.getId() == R.id.button4) {
            Navigation.findNavController(v).navigate(R.id.action_view_entries_to_view_journal_statistics);
        }
    }
}