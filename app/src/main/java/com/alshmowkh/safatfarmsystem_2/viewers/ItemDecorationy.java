package com.alshmowkh.safatfarmsystem_2.viewers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.alshmowkh.safatfarmsystem_2.MainActivity;

public class ItemDecorationy extends RecyclerView.ItemDecoration {
    Context context;
    Drawable divider;
    public ItemDecorationy(Context context, int divider) {
        this.context=context;
        this.divider= ContextCompat.getDrawable(context,divider);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int left=parent.getPaddingLeft();
        int right=parent.getWidth() - parent.getPaddingRight();

        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams)child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+divider.getIntrinsicHeight();
            divider.setBounds(left,top,right,bottom);
            divider.draw(c);
        }
    }
}
