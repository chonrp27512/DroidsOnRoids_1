package com.example.radek.droidsonroids_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Radek on 2016-07-25.
 */
public class DayResourceAdapter extends RecyclerView.Adapter<DayResourceAdapter.ViewHolder>{

    private List<DayResource> agendaResource;
    private Context context;

    public DayResourceAdapter(Context context, List<DayResource> agendaResource){
        this.agendaResource = agendaResource;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.rec_view_day_simple_layout, viewGroup, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.app.setText(agendaResource.get(i).app);
        viewHolder.topic.setText(agendaResource.get(i).topic);
        viewHolder.name.setText(agendaResource.get(i).name);
        viewHolder.plan.setText(agendaResource.get(i).plan);
    }

    @Override
    public int getItemCount() {
        return agendaResource==null?0:agendaResource.size();
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return context;
    }

    public void setResource(List<DayResource> list){
        agendaResource = list;
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView topic;
        public TextView name;
        public TextView app;
        public TextView plan;

        public ViewHolder(View v) {
            super(v);
            topic = (TextView) v.findViewById(R.id.dayTopicTextView);
            name = (TextView) v.findViewById(R.id.dayNameTextView);
            app = (TextView) v.findViewById(R.id.dayAppTextView);
            plan = (TextView) v.findViewById(R.id.dayPlanTextView);
        }
    }
}
