package br.vachod.listviewexample;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = findViewById(R.id.detail_title);
        TextView contentTextView = findViewById(R.id.detail_content);
        ImageView detailImageView = findViewById(R.id.detail_image);

        String shopTitle = getIntent().getStringExtra("item_title");
        String shopPrice = getIntent().getStringExtra("item_price");
        int shopImage = getIntent().getIntExtra("item_image", R.drawable.image1);

        titleTextView.setText(shopTitle);
        contentTextView.setText(shopPrice);
        detailImageView.setImageResource(shopImage);

    }
}
