package com.alshmowkh.safatfarmsystem_2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alshmowkh.safatfarmsystem_2.R;
import com.alshmowkh.safatfarmsystem_2.fields.Gacim;
import com.alshmowkh.safatfarmsystem_2.fields.Moalaga;
import com.alshmowkh.safatfarmsystem_2.viewers.RecycleAdapter;

import java.util.List;

public class AppendixFragment extends Fragment {
    View view;
    Context context;
    List<Moalaga> appendixes;
    public AppendixFragment(Gacim gacim) {
        appendixes=gacim.getAppendixes();
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dhiah, container, false);
        showList(appendixes);
        return view;
    }

    private void showList(List<Moalaga> gacims) {
        RecyclerView recycleDhiah;
        recycleDhiah= view.findViewById(R.id.recycleDhiahFrag);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycleDhiah.setLayoutManager(layoutManager);

        RecycleAdapter.onItemClickListener fieldListener=null;
        fieldListener= field -> {
//            Gacim gacim=(Gacim) field;
//            Fragment appFragment=new AppendixFragment(gacim);
//            getActivity().getSupportFragmentManager()
//                    .beginTransaction().replace(R.id.framelayout,appFragment)
//                    .commit();
            Toast.makeText(getContext(),field.getName(),Toast.LENGTH_LONG).show();
        };
        recycleDhiah.setAdapter(new RecycleAdapter(getActivity(), gacims,fieldListener));
    }
}
