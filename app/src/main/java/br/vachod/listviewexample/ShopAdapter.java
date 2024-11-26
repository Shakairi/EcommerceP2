package br.vachod.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class ShopAdapter extends ArrayAdapter<ShopItem> {

    public ShopAdapter(Context context, ArrayList<ShopItem> shopItems) {
        super(context, 0, shopItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shop_item, parent, false);
        }

        ShopItem currentItem = getItem(position);

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemTitle = convertView.findViewById(R.id.item_title);
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        RatingBar itemRatingBar = convertView.findViewById(R.id.item_rating_bar);

        itemImage.setImageResource(currentItem.getImageResId());
        itemTitle.setText(currentItem.getTitle());
        itemPrice.setText(currentItem.getPrice());

        Random random = new Random();
        float randomRating = 2.5f + random.nextFloat() * 2.5f;
        itemRatingBar.setRating(randomRating);

        return convertView;
    }
}
