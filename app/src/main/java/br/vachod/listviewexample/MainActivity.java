package br.vachod.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<ShopItem> shopItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView shopListView = findViewById(R.id.shop_list_view);

        shopItems = new ArrayList<>();
        shopItems.add(new ShopItem("Capa para celular", "R$10.00", "Descrição 1",R.drawable.image1));
        shopItems.add(new ShopItem("KIT 24 meias", "R$55.99", "Descrição 2",R.drawable.image2));

        ShopAdapter adapter = new ShopAdapter(this, shopItems);
        shopListView.setAdapter(adapter);


        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "Item clicado: posição = " + position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("item_title", shopItems.get(position).getTitle());
                intent.putExtra("item_price", shopItems.get(position).getPrice());
                intent.putExtra("item_description", shopItems.get(position).getDescription());
                intent.putExtra("item_image", shopItems.get(position).getImageResId());
                startActivity(intent);
            }
        });
    }
}

