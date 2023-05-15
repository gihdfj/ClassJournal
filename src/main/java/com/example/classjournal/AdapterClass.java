package com.example.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classjournal.databinding.RowClassBinding;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.HolderClass>{

    private Context context;
    private ArrayList<ModelCategory> classArrayList;
    private RowClassBinding binding;
    public AdapterClass(Context context, ArrayList<ModelCategory> classArrayList)
    {
        this.context = context;
        this.classArrayList = classArrayList;
    }

    @NonNull
    @Override
    public HolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RowClassBinding.inflate(LayoutInflater.from(context),parent,false);
        return new HolderClass(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderClass holder, int position) {
        ModelCategory model = classArrayList.get(position);
        String id = model.getId();
        String category = model.getCategory();
        String uid = model.getUid();
        long timestamp = model.getTimestamp();

        holder.categoryTv.setText(category);

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+category, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HolderClass extends RecyclerView.ViewHolder{
        TextView categoryTv;
        ImageButton deleteBtn;
        public HolderClass(@NonNull View itemView) {
            super(itemView);
            categoryTv = binding.categoryTv;
            deleteBtn = binding.deleteBtn;

        }
    }
}
