package com.example.gamesapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamesapplication.R;
import com.example.gamesapplication.model.DataTeams;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    List<DataTeams> dataTeams;

    public TeamAdapter(List<DataTeams> dataTeams) {
        this.dataTeams = dataTeams;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataTeams dataTeam = dataTeams.get(position);
        holder.nom.setText(dataTeam.getFullName() + " " + dataTeam.getAbbreviation());
        holder.city.setText(dataTeam.getCity());
        holder.abrev.setText(dataTeam.getName());
        holder.division.setText(dataTeam.getDivision());
        holder.conference.setText(dataTeam.getConference());
    }

    @Override
    public int getItemCount() {
        return dataTeams.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom, city, abrev, division, conference;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            abrev = itemView.findViewById(R.id.abrev);
            division = itemView.findViewById(R.id.division);
            conference = itemView.findViewById(R.id.conference);
        }
    }
}
