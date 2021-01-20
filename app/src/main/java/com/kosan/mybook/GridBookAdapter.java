package com.kosan.mybook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridBookAdapter extends RecyclerView.Adapter<GridBookAdapter.GridViewHolder> {

    private ArrayList<Book> listBook;
    private Context context;

    public GridBookAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Book> getListBook()
    {
       return listBook;
    }
    public void setListBook(ArrayList<Book> listBook){
        this.listBook = listBook;
    }



    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_book,parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        final Book b = getListBook().get(position);

        Glide.with(context)
                .load(getListBook().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context,DescBookActivity.class);
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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
