package com.kosan.mybook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Book> listBook;

    public ListBookAdapter(Context context){
        this.context = context;
    }
    public ArrayList<Book> getListBook() {

        return listBook;
    }
    public void setListBook(ArrayList<Book> listBook){
        this.listBook = listBook;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_book, viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final Book b = getListBook().get(position);

        holder.tvName.setText(getListBook().get(position).getNama());
        holder.tvPengarang.setText(getListBook().get(position).getPengarang());
        Glide.with(context)
                .load(getListBook().get(position).getPhoto())
                .into(holder.imgPhoto);

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescBookActivity.class);
                intent.putExtra("photo", b.getPhoto());
                intent.putExtra("name", b.getNama());
                intent.putExtra("pengarang", b.getPengarang());
                intent.putExtra("desc", b.getDesc());

                context.startActivity(intent);
            }

        });
    }


    @Override
    public int getItemCount() {
        return getListBook().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPengarang;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPengarang = itemView.findViewById(R.id.tv_item_pengarang);
            imgPhoto= itemView.findViewById(R.id.img_photo);
        }
    }
}
