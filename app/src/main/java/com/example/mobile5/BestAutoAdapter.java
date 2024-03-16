package com.example.mobile5;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BestAutoAdapter extends RecyclerView.Adapter<BestAutoAdapter.BestAutoViewHolder> {

    private List<BestAuto> bestAutoList;

    public BestAutoAdapter(List<BestAuto> bestAutoList) {
        this.bestAutoList = bestAutoList;
    }

    @NonNull
    @Override
    public BestAutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_auto_item, parent, false);
        return new BestAutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestAutoViewHolder holder, int position) {
        BestAuto bestAuto = bestAutoList.get(position);
        holder.imageView.setImageResource(bestAuto.getImageResource());
        holder.textView.setText(bestAuto.getText());
    }

    @Override
    public int getItemCount() {
        return bestAutoList.size();
    }

    public static class BestAutoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public BestAutoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.best_auto_image);
            textView = itemView.findViewById(R.id.best_auto_name);
        }
    }
}

