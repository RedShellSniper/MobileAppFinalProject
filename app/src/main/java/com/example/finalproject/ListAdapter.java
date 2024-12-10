package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<JournalData> journalDataList;

    public ListAdapter(List<JournalData> journalDataList) {
        this.journalDataList = journalDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_entries, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JournalData journalData = journalDataList.get(position);

        holder.textViewDay.setText(journalData.getDay());
        holder.textViewTime.setText(journalData.getTime());
        holder.textViewLocation.setText(journalData.getLocation());
        holder.textViewMood.setText(journalData.getMood());
        holder.textViewThoughts.setText(journalData.getThoughts());
    }

    @Override
    public int getItemCount() { return journalDataList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDay, textViewTime, textViewLocation, textViewMood, textViewThoughts;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewDay = itemView.findViewById(R.id.textViewDay);
            this.textViewTime = itemView.findViewById(R.id.textViewTime);
            this.textViewLocation = itemView.findViewById(R.id.textViewLocation);
            this.textViewMood = itemView.findViewById(R.id.textViewMood);
            this.textViewThoughts = itemView.findViewById(R.id.textViewThoughts);
            linearLayout = itemView.findViewById(R.id.LinearLayout);
        }
    }
}
