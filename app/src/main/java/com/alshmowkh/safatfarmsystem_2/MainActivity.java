package com.alshmowkh.safatfarmsystem_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alshmowkh.safatfarmsystem_2.builders.SafatBuilder;
import com.alshmowkh.safatfarmsystem_2.fields.Dhiah;
import com.alshmowkh.safatfarmsystem_2.fragments.DhiahFragment;
import com.alshmowkh.safatfarmsystem_2.viewers.ItemDecorationy;
import com.alshmowkh.safatfarmsystem_2.viewers.RecycleAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start();
    }

    void start() {
        SafatBuilder builder = SafatBuilder.build();
        List<Dhiah> dhiahs = builder.getDhiahs();
        //System.out.println("عدد الظياع"+dhiahs.size());
//        showList(dhiahs);
        showDhiahFragment(builder);
    }

    private void showDhiahFragment(SafatBuilder builder) {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction=transaction.replace(R.id.framelayout,new DhiahFragment(builder));
//        transaction.addToBackStack("dhiah");
        int v=transaction.commit();
    }

    private void showList(List<Dhiah> dhiahs) {
        RecyclerView recycleDhiah = findViewById(R.id.recycleDhiah);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycleDhiah.setLayoutManager(layoutManager);
//        recycleDhiah.addItemDecoration( new ItemDecorationy(this,R.drawable.divider));
//        DividerItemDecoration decoration = new
//                DividerItemDecoration(recycleDhiah.getContext(),
//                DividerItemDecoration.VERTICAL);

//        decoration.setDrawable(getDrawable(R.drawable.divider));
//        recycleDhiah.addItemDecoration(decoration);
//        recycleDhiah.setAdapter(new RecycleAdapter(this, dhiahs));

    }
}