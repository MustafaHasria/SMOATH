package com.example.smoathapplication.models.home.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.model.MovieModel;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferAdapterViewHolder> {

    //region Variables
    List<MovieModel> offerModelList;
    //endregion

    //region Constructor

    public OfferAdapter(List<MovieModel> offerModelList) {
        this.offerModelList = offerModelList;
    }

    //endregion

    @NonNull
    @Override
    public OfferAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_list_item, viewGroup, false);
        return new OfferAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapterViewHolder offerAdapterViewHolder, int position) {
        offerAdapterViewHolder.offerListItemTextName.setText(offerModelList.get(position).getName());
        offerAdapterViewHolder.offerListItemTextCategory.setText(offerModelList.get(position).getCategory());
        offerAdapterViewHolder.offerListItemTextDuration.setText(offerModelList.get(position).getDuration());
        offerAdapterViewHolder.offerListItemTextRating.setText(String.valueOf(offerModelList.get(position).getRating()));
        offerAdapterViewHolder.offerListItemImageViewImage.setImageBitmap(StringToBitMap(offerModelList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return offerModelList.size();
    }

    public void updateList(List<MovieModel> offerModelList){
        this.offerModelList.clear();
        this.offerModelList = offerModelList;
        notifyDataSetChanged();
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    //region View holder
    class OfferAdapterViewHolder extends RecyclerView.ViewHolder {

        //region Components
        CardView offerListItemCardMainContainer;
        TextView offerListItemTextName;
        TextView offerListItemTextCategory;
        TextView offerListItemTextDuration;
        TextView offerListItemTextRating;
        ImageView offerListItemImageViewImage;
        //endregion

        public OfferAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            offerListItemCardMainContainer = itemView.findViewById(R.id.offer_list_item_card_main_container);
            offerListItemTextCategory = itemView.findViewById(R.id.offer_list_item_text_category);
            offerListItemTextName = itemView.findViewById(R.id.offer_list_item_text_name);
            offerListItemTextDuration = itemView.findViewById(R.id.offer_list_item_text_duration);
            offerListItemTextRating = itemView.findViewById(R.id.offer_list_item_text_rating);
            offerListItemImageViewImage = itemView.findViewById(R.id.offer_list_item_image_view_image);
        }
    }
    //endregion
}
