package com.example.simplerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder>{
    ArrayList<User> users;
    LayoutInflater inflater;
    ItemClickListener listener;

    public CustomRecycleAdapter(Context context, ArrayList<User> users, ItemClickListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.users = users;
        this.listener = listener;
    }

    // Возвращает объект ViewHolder, который будет хранить данные по одному объекту State
    @Override
    public CustomRecycleAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CustomViewHolder(view);
    }

    // Выполняет привязку объекта ViewHolder к объекту State по определенной позиции
    @Override
    public void onBindViewHolder(@NonNull CustomRecycleAdapter.CustomViewHolder holder, int position) {
        User user = users.get(position);
        switch (user.getSex()) {
            case MAN: holder.ivUserpic.setImageResource(R.drawable.user_man); break;
            case WOMAN: holder.ivUserpic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: holder.ivUserpic.setImageResource(R.drawable.user_unknown); break;
        }
        holder.tvName.setText(user.getName());
        holder.tvPhone.setText(user.getPhoneNumber());
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(user);
            }
        });

    }

    // Возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        final ImageView ivUserpic;
        final TextView tvName, tvPhone;
        ConstraintLayout cl;

        public CustomViewHolder(View view) {
            super(view);
            ivUserpic = view.findViewById(R.id.userpic);
            tvName = view.findViewById(R.id.name);
            tvPhone = view.findViewById(R.id.phone);

            // Работающее, но класс не должен быть public static
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d("mytag", users.get(getAdapterPosition()).getName());
//                }
//            });
            cl = view.findViewById(R.id.recycle_view_layout);
        }

        public void bind (@NonNull User user) {
            switch (user.getSex()) {
                case MAN: this.ivUserpic.setImageResource(R.drawable.user_man); break;
                case WOMAN: this.ivUserpic.setImageResource(R.drawable.user_woman); break;
                case UNKNOWN: this.ivUserpic.setImageResource(R.drawable.user_unknown); break;
            }
            this.tvName.setText(user.getName());
            this.tvPhone.setText(user.getPhoneNumber());
        }
    }


}
