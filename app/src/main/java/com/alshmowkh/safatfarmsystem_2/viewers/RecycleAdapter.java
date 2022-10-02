package com.alshmowkh.safatfarmsystem_2.viewers;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.alshmowkh.safatfarmsystem_2.R;
import com.alshmowkh.safatfarmsystem_2.fields.Dhiah;
import com.alshmowkh.safatfarmsystem_2.fields.Field;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {


    public interface onItemClickListener {
        void onItemClicked(Field field);
    }

    List<Field> fields;
    Context context;
    onItemClickListener itemListener;

    public RecycleAdapter(Context context, List fields,onItemClickListener fieldListener) {
        this.fields = fields;
        this.context = context;
        itemListener=fieldListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);
//        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dhiah,parent);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Field dhiah = fields.get(position);
        holder.dh_name.setText(dhiah.getName());
        holder.dh_id.setText(dhiah.getId() + "");
        holder.area.setText(dhiah.getAreaBeta() + "");
        holder.almonds.setText(dhiah.getAlmonds() + "");
        holder.gaats.setText(dhiah.getGaats() + "");
//        holder.img.setImageResource(R.drawable.resistor);

        holder.itemView.setOnClickListener(v -> itemListener.onItemClicked(dhiah));
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dh_name;
        ImageView img;
        TextView dh_id;
        TextView almonds;
        TextView gaats;
        TextView area;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dh_name = itemView.findViewById(R.id.dhName);
            dh_id = itemView.findViewById(R.id.dhId);
            area = itemView.findViewById(R.id.area);
            almonds = itemView.findViewById(R.id.almonds);
            gaats = itemView.findViewById(R.id.gaats);
            img = itemView.findViewById((R.id.image));

        }
    }
}
