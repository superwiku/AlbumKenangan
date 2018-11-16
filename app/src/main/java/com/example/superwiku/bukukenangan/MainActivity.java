package com.example.superwiku.bukukenangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.superwiku.bukukenangan.adapter.MemberAllAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Member> members;
    private MemberAllAdapter memberAllAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv_all);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent=getIntent();
        members=(List<Member>)intent.getSerializableExtra("datanya");
        memberAllAdapter=new MemberAllAdapter(members,MainActivity.this);
        recyclerView.setAdapter(memberAllAdapter);

    }
}
