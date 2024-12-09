package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewEntries extends Fragment implements View.OnClickListener {
    private Button button3, button4;
    private DatabaseHelper databaseHelper;
    private List<JournalData> entriesList;
    private ListAdapter adapter;

    public ViewEntries() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext());
        entriesList = databaseHelper.getAllEntries();
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

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new ListAdapter(entriesList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onResume() {
        super.onResume();
        entriesList.clear();
        entriesList.addAll(databaseHelper.getAllEntries());
        adapter.notifyDataSetChanged();
    }
}