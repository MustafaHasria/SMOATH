package com.example.smoathapplication.models.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoathapplication.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder> {

    //region Variables

    //endregion

    @NonNull
    @Override
    public CategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_item, viewGroup, false);
        return new CategoryAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterViewHolder offerAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //region View holder
    class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {

        //region Components
        CardView offerListItemCardMainContainer;
        TextView offerListItemTextName;
        TextView offerListItemTextCategory;
        TextView offerListItemTextDuration;
        TextView offerListItemTextRating;
        //endregion

        public CategoryAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            offerListItemCardMainContainer = itemView.findViewById(R.id.offer_list_item_card_main_container);
            offerListItemTextCategory = itemView.findViewById(R.id.offer_list_item_text_category);
            offerListItemTextName = itemView.findViewById(R.id.offer_list_item_text_name);
            offerListItemTextDuration = itemView.findViewById(R.id.offer_list_item_text_duration);
            offerListItemTextRating = itemView.findViewById(R.id.offer_list_item_text_rating);
        }
    }
    //endregion
}
