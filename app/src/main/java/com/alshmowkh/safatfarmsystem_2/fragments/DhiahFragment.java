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
import com.alshmowkh.safatfarmsystem_2.builders.SafatBuilder;
import com.alshmowkh.safatfarmsystem_2.fields.Dhiah;
import com.alshmowkh.safatfarmsystem_2.fields.Field;
import com.alshmowkh.safatfarmsystem_2.viewers.RecycleAdapter;

import java.util.List;

public class DhiahFragment extends Fragment {
    View view;
    Context context;
    List<Dhiah> dhiahs;

    public DhiahFragment(SafatBuilder builder) {
        dhiahs = builder.getDhiahs();

    }

//    public DhiahFragment(){
////        Toast.makeText(getContext(),"برع تي تي", Toast.LENGTH_LONG).show();
//        System.out.println("برع تي تي");
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dhiah, container, false);
        showList(dhiahs);
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentManager manager = getParentFragmentManager();

        Toast.makeText(view.getContext(), manager.getBackStackEntryCount() + "", Toast.LENGTH_LONG).show();
    }

    private void showList(List<Dhiah> dhiahs) {
        RecyclerView recycleDhiah;
        recycleDhiah = view.findViewById(R.id.recycleDhiahFrag);
//        System.out.println("contexxxxxxxxxxxxt"+recycleDhiah );
//        recycleDhiah.setLayoutManager(layoutManager);
//        recycleDhiah.addItemDecoration( new ItemDecorationy(this,R.drawable.divider));
//        DividerItemDecoration decoration = new
//                DividerItemDecoration(recycleDhiah.getContext(),
//                DividerItemDecoration.VERTICAL);

//        decoration.setDrawable(getDrawable(R.drawable.divider));
//        recycleDhiah.addItemDecoration(decoration);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycleDhiah.setLayoutManager(layoutManager);

        RecycleAdapter.onItemClickListener fieldListener = null;
        fieldListener = new RecycleAdapter.onItemClickListener() {
            @Override
            public void onItemClicked(Field field) {
//                Toast.makeText(getContext(),field.getName(),Toast.LENGTH_LONG).show();
                showGacimFragment((Dhiah) field);

            }
        };

        recycleDhiah.setAdapter(new RecycleAdapter(getActivity(), dhiahs, fieldListener));
    }

    private void showGacimFragment(Dhiah dhiah) {
        Fragment gacimFragment = new GacimFragment(dhiah);
        FragmentManager manager =getActivity(). getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction = transaction.replace(R.id.framelayout,gacimFragment );
        transaction.addToBackStack("gacims");
        int v = transaction.commit();
    }
}