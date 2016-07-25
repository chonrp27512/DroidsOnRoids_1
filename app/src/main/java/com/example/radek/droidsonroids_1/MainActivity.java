package com.example.radek.droidsonroids_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private DayResourceAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<DayResource> agendaDataList;
    private OnSuccessListener onSuccessListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAgendaData();
        initRecyclerView();
    }

    private void getAgendaData(){
        BootcampDayApiManager apiManager = new BootcampDayApiManager();
        apiManager.processAgendaData(new OnSuccessListener() {
            @Override
            public void onDataRead(List<DayResource> resourceList) {
                agendaDataList = resourceList;
                mAdapter = new DayResourceAdapter(getApplicationContext(),resourceList);
                mRecyclerView.setAdapter(mAdapter);
                Toast.makeText(MainActivity.this, "ONDATAREAD", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DayResourceAdapter(getApplicationContext(), agendaDataList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
