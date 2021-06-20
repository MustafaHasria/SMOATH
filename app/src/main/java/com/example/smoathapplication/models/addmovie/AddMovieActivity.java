package com.example.smoathapplication.models.addmovie;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.smoathapplication.R;
import com.example.smoathapplication.models.home.model.MovieModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class AddMovieActivity extends AppCompatActivity {

    //region Components
    ImageView addMovieImageViewImage;

    EditText addMovieEditTextName;
    EditText addMovieEditTextCategory;
    EditText addMovieEditTextRating;
    EditText addMovieEditTextDuration;

    Button addMovieButtonAdd;

    //endregion

    //region Variables
    Bitmap bitmapImage;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        addMovieImageViewImage = findViewById(R.id.add_movie_image_view_image);
        addMovieEditTextName = findViewById(R.id.add_movie_edit_text_name);
        addMovieEditTextCategory = findViewById(R.id.add_movie_edit_text_category);
        addMovieEditTextRating = findViewById(R.id.add_movie_edit_text_rating);
        addMovieEditTextDuration = findViewById(R.id.add_movie_edit_text_duration);
        addMovieButtonAdd = findViewById(R.id.add_movie_button_add);

        addMovieImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
            }
        });

        addMovieButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieModel movieModel = new MovieModel("fasdfas", addMovieEditTextName.getText().toString(), addMovieEditTextDuration.getText().toString(), Float.parseFloat(addMovieEditTextRating.getText().toString()));
                List<MovieModel> movieModelList = Paper.book().read("MOVIES_LIST", new ArrayList<>());
                movieModelList.add(movieModel);
                Paper.book().write("MOVIE_LIST", movieModelList);
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else chooseImage();
    }

    private void chooseImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 15);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 15) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                addMovieImageViewImage.setImageBitmap(bitmapImage);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}