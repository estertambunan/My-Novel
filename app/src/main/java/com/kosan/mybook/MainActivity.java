package com.kosan.mybook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Book> list;
    final String STATE_TITLE="state_string";
    private String title = "My Novel";
    final String STATE_LIST ="state_list";
    final String STATE_MODE ="state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null){
            setActionBarTitle("My Novel");
            list.addAll(BookData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Book> stateList= savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }

    }
    private void showSelectedBook(Book book){
        Toast.makeText(this, "Favorite Novel" + book.getNama(), Toast.LENGTH_SHORT).show();
    }
    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListBookAdapter listBookAdapter = new ListBookAdapter(this);
        listBookAdapter.setListBook(list);
        rvCategory.setAdapter(listBookAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v){
            showSelectedBook(list.get(position));

        }
    });
}
private void showRecyclerGrid(){
    rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
    GridBookAdapter gridBookAdapter = new GridBookAdapter(this);
    gridBookAdapter.setListBook(list);
    rvCategory.setAdapter(gridBookAdapter);

    ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
        @Override
        public void onItemClicked(RecyclerView recyclerView, int position, View v){
            showSelectedBook(list.get(position));
        }
    });
}
private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewBookAdapter cardViewBookAdapter = new CardViewBookAdapter(this);
        cardViewBookAdapter.setListBook(list);
        rvCategory.setAdapter(cardViewBookAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        String title = null;
        switch (selectedMode){
            case R.id.action_list:
                title = "My Novel";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "My Novel";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title ="My Novel";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
