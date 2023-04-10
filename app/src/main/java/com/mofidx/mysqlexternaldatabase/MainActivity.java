package com.mofidx.mysqlexternaldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mofidx.mysqlexternaldatabase.receyclerViewUtils.MyRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);

        DataBaseAccess db = DataBaseAccess.getInstance(this);

        ArrayList<nasheed> nasheedArrayList = new ArrayList<>();
        db.open();
        nasheedArrayList = db.getAllNasheedfromDatbase();
        db.close();



        MyRecyclerAdapter adapter = new MyRecyclerAdapter(nasheedArrayList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }
}