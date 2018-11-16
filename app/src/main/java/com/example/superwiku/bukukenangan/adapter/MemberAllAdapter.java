package com.example.superwiku.bukukenangan.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.superwiku.bukukenangan.DetailActivity;
import com.example.superwiku.bukukenangan.Member;
import com.example.superwiku.bukukenangan.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class MemberAllAdapter extends RecyclerView.Adapter<MemberAllAdapter.MemberAllHolder>{
    private  List<Member>memberss;
    private Activity activity;

    public MemberAllAdapter(List<Member> memberss, Activity activity) {
        this.memberss = memberss;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MemberAllHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(activity).inflate(R.layout.rv_item,viewGroup,false);
        return new MemberAllHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAllHolder memberAllHolder, final int i) {
        memberAllHolder.namanya.setText(memberss.get(i).getNama());
        Picasso.with(activity).load(memberss.get(i).getFoto1()).into(memberAllHolder.fotonya);
        memberAllHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member=memberss.get(i);
                Intent intent=new Intent(activity,DetailActivity.class);
                intent.putExtra(DetailActivity.KEY_ACTIVITY, member);
                view.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return memberss.size();
    }

    static class MemberAllHolder extends RecyclerView.ViewHolder{
        TextView namanya;
        ImageView fotonya;
        public MemberAllHolder(@NonNull View itemView) {
            super(itemView);
            namanya=(TextView)itemView.findViewById(R.id.txt_nama);
            fotonya=(ImageView)itemView.findViewById(R.id.img_foto);
        }
    }
}
