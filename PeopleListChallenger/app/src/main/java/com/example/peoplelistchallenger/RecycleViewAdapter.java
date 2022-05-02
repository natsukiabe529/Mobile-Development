package com.example.peoplelistchallenger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<PersonalInformation> personalInformationList;
    Context context;

    public RecycleViewAdapter(List<PersonalInformation> personalInformationList, Context context) {
        this.personalInformationList = personalInformationList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_personal, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_personalName.setText(personalInformationList.get(position).getName());
        holder.tv_phoneNumber.setText(String.valueOf(personalInformationList.get(position).getPhone()));
        Glide.with(this.context).load(personalInformationList.get(position).getImageURL()).into(holder.iv_personalPicture);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send the control to the EditOneItem activity
                Intent intent = new Intent(context, AddEditOne.class);
                intent.putExtra("id", personalInformationList.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personalInformationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_personalPicture;
        TextView tv_personalName, tv_phoneNumber;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_personalPicture = itemView.findViewById(R.id.iv_personalPicture);
            tv_personalName = itemView.findViewById(R.id.tv_personalName);
            tv_phoneNumber = itemView.findViewById(R.id.tv_phoneNumber);
            parentLayout = itemView.findViewById(R.id.oneLinePersonalLayout);
        }
    }
}
