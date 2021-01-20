package com.kosan.mybook;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewBookAdapter extends RecyclerView.Adapter<CardViewBookAdapter.CardViewViewHolder>{

    private Context context;
    private ArrayList<Book> listBook;

    public CardViewBookAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<Book> getListBook(){
        return listBook;
    }
    public void setListBook(ArrayList<Book> listBook){
        this.listBook=listBook;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_book, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewBookAdapter.CardViewViewHolder cardViewViewHolder, int i) {
final Book b = getListBook().get(i);
        Glide.with(context)
                .load(b.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(b.getNama());
        cardViewViewHolder.tvPengarang.setText(b.getPengarang());
        cardViewViewHolder.btnDetail.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                //Toast.makeText(context, "Favorite" + getListBook().get(position).getNama(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DescBookActivity.class);
                intent.putExtra("photo", b.getPhoto());
                intent.putExtra("name", b.getNama());
                intent.putExtra("pengarang", b.getPengarang());
                intent.putExtra("desc", b.getDesc());

                context.startActivity(intent);
            }

        }));
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback(){
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite" + getListBook().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
            }));
        cardViewViewHolder.imgPhoto.setOnClickListener(new View.OnClickListener(){

        @Override
            public void onClick(View v){
           // Intent intent = new Intent(context, DescBookActivity.class);
           // intent.putExtra("photo", b.getPhoto());
          //  intent.putExtra("name", b.getNama());
           // intent.putExtra("pengarang", b.getPengarang());
           // intent.putExtra("desc", b.getDesc());

           // context.startActivity(intent);
        }

        });
    }


    @Override
    public int getItemCount() {
        return getListBook().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvPengarang;
        Button btnFavorite, btnDetail;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.img_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPengarang = itemView.findViewById(R.id.tv_item_pengarang);
            btnFavorite =itemView.findViewById(R.id.btn_set_favorite);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
