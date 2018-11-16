package com.example.superwiku.bukukenangan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.superwiku.bukukenangan.Member;
import com.example.superwiku.bukukenangan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KenanganFragment extends Fragment {
    private TextView txtPesan, txtKesan;
    private Member member;
    private Bundle bundle;


    public KenanganFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        member = (Member) bundle.getSerializable("mmmember");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_kenangan, container, false);
        txtPesan=(TextView)view.findViewById(R.id.txt_pesan);
        txtKesan=(TextView)view.findViewById(R.id.txt_kesan);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtPesan.setText(member.getPesan());
        txtKesan.setText(member.getKesan());
    }
}
