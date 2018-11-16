package com.example.superwiku.bukukenangan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.superwiku.bukukenangan.Member;
import com.example.superwiku.bukukenangan.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataDiriFragment extends Fragment {

    private TextView txtNamaDetail,alamatDetail,desaDetail,kecDetail,kabDetail,ttlDetail,hobiDetail;
    private ImageView imgDetail;
    private Member member;
    private Bundle bundle;


    public DataDiriFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        member = (Member) bundle.getSerializable("mmember");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_data_diri, container, false);
        txtNamaDetail=(TextView)view.findViewById(R.id.txt_nama_detail);
        alamatDetail=(TextView)view.findViewById(R.id.txt_kampung);
        desaDetail=(TextView)view.findViewById(R.id.txt_desa);
        kecDetail=(TextView)view.findViewById(R.id.txt_kec);
        kabDetail=(TextView)view.findViewById(R.id.txt_kab);
        ttlDetail=(TextView)view.findViewById(R.id.txt_ttl);
        hobiDetail=(TextView)view.findViewById(R.id.txt_hobi);
        imgDetail=(ImageView)view.findViewById(R.id.img_foto_detail);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtNamaDetail.setText(member.getNama());
        alamatDetail.setText(member.getAlamat());
        desaDetail.setText(member.getDesa());
        kecDetail.setText(member.getKec());
        kabDetail.setText(member.getKab());
        ttlDetail.setText(member.getTtl());
        hobiDetail.setText(member.getHobi());
        Picasso.with(getContext()).load(member.getFoto4()).into(imgDetail);

    }
}
