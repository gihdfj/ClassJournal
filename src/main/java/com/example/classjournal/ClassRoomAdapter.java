package com.example.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClassRoomAdapter extends RecyclerView.Adapter<ClassRoomAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<ClassRoom> classRoomList;

    ClassRoomAdapter(Context context, List<ClassRoom> classRoomList )
    {
        this.classRoomList = classRoomList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_class, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassRoom myclass = classRoomList.get(position);
        holder.classname.setText(myclass.getClassname());
        holder.number_of_students.setText(Integer.toString(myclass.getNumber_of_students()));
    }

    @Override
    public int getItemCount() {
        return classRoomList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView classname, number_of_students;
        public ViewHolder(View view)
        {
            super(view);
            classname=view.findViewById(R.id.categoryTv);
            number_of_students=view.findViewById(R.id.categoryNum);
        }
    }

}
