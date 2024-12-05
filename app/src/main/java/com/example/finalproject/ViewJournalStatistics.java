package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewJournalStatistics#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewJournalStatistics extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DAY = "param1";
    private static final String TIME = "param2";
    private static final String LOCATION = "param3";
    private static final String MOOD = "param4";
    private static final String THOUGHTS = "param5";

    private String day, time, location, mood, thoughts;
    private Button button5;
    //private TextView stat1, stat2, stat3;

    public ViewJournalStatistics() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewJournalStatistics.
     */

    public static ViewJournalStatistics newInstance(String param1, String param2, String param3, String param4, String param5) {
        ViewJournalStatistics fragment = new ViewJournalStatistics();
        Bundle args = new Bundle();
        args.putString(DAY, param1);
        args.putString(TIME, param2);
        args.putString(LOCATION, param3);
        args.putString(MOOD, param4);
        args.putString(THOUGHTS, param5);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_view_journal_statistics, container, false);
        button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button5) {
            Navigation.findNavController(v).navigate(R.id.action_view_journal_statistics_to_view_entries);
        }
    }
}