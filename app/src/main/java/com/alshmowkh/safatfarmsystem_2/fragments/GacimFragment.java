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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alshmowkh.safatfarmsystem_2.R;
import com.alshmowkh.safatfarmsystem_2.fields.Dhiah;
import com.alshmowkh.safatfarmsystem_2.fields.Field;
import com.alshmowkh.safatfarmsystem_2.fields.Gacim;
import com.alshmowkh.safatfarmsystem_2.viewers.RecycleAdapter;

import java.util.List;

public class GacimFragment extends Fragment {

    View view;
    Context context;
    List<Gacim> gacims;

    public GacimFragment(Dhiah dhiah) {
        gacims = dhiah.getGacims();
        System.out.println(dhiah.getName());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dhiah, container, false);
        showList(gacims);
        return view;
    }

    private void showList(List<Gacim> gacims) {
        RecyclerView recycleDhiah;
        recycleDhiah = view.findViewById(R.id.recycleDhiahFrag);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycleDhiah.setLayoutManager(layoutManager);

        RecycleAdapter.onItemClickListener fieldListener = null;
        fieldListener = field -> {
            showAppFragment((Gacim) field);
        };
        recycleDhiah.setAdapter(new RecycleAdapter(getActivity(), gacims, fieldListener));
    }

    private void showAppFragment(Gacim gacim) {



        Fragment appFragment = new AppendixFragment(gacim);
        FragmentManager manager =getActivity(). getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction = transaction.replace(R.id.framelayout,appFragment );
        transaction.addToBackStack("appendixes");
        int v = transaction.commit();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentManager manager = getParentFragmentManager();

        Toast.makeText(view.getContext(), manager.getBackStackEntryCount() + "", Toast.LENGTH_LONG).show();
    }
}
