package com.example.smoathapplication.models.home.adapter;

import android.content.Context;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.modelapi.MovieModel;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferAdapterViewHolder> {

    //region Variables
    List<MovieModel> offerModelList;
    OfferAdapterClickListeners offerAdapterClickListeners;
    Context context;
    //endregion

    //region Constructor

    public OfferAdapter(List<MovieModel> offerModelList, OfferAdapterClickListeners offerAdapterClickListeners) {
        this.offerModelList = offerModelList;
        this.offerAdapterClickListeners = offerAdapterClickListeners;
    }

    //endregion

    @NonNull
    @Override
    public OfferAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_list_item, viewGroup, false);
        context = viewGroup.getContext();
        return new OfferAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapterViewHolder offerAdapterViewHolder, int position) {
        Glide.with(context).applyDefaultRequestOptions(new RequestOptions()
                .placeholder(R.drawable.ic_downloading).error(R.drawable.ic_error))
                .load(offerModelList.get(position).getImage().getMedium())
                .into(offerAdapterViewHolder.offerListItemImageViewImage);
        offerAdapterViewHolder.offerListItemTextName.setText(offerModelList.get(position).getName());
        if (!offerModelList.get(position).getGenres().get(0).equals(""))
            offerAdapterViewHolder.offerListItemTextCategory.setText(offerModelList.get(position).getGenres().get(0));
    }

    @Override
    public int getItemCount() {
        return offerModelList.size();
    }

    public void updateList(List<MovieModel> offerModelList) {
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

    //region Interface
    public interface OfferAdapterClickListeners {
        void onOfferListItemCardMainContainerLongClickListener(MovieModel movieModel, int position);
    }
    //endregion


    //region View holder
    class OfferAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

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

            offerListItemCardMainContainer.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            offerAdapterClickListeners.onOfferListItemCardMainContainerLongClickListener(offerModelList.get(getAdapterPosition()), getAdapterPosition());
            return false;
        }
    }
    //endregion
}
