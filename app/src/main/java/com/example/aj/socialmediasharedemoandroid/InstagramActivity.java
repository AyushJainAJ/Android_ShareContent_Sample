package com.example.aj.socialmediasharedemoandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class InstagramActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        //Action Picker Intent.
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");       //Required for opening gallery
        startActivityForResult(photoPickerIntent, 1);
    }

    //Once the Photo picker activity is over
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        //If an image was selected
        if (resultCode == RESULT_OK) {
            final Uri imageUri = imageReturnedIntent.getData(); //gets URI of image selected

            Intent share = new Intent(Intent.ACTION_SEND);

            share.setType("image/*");   //Defines which applications can be used to send the image

            share.putExtra(Intent.EXTRA_STREAM, imageUri);

            // Broadcast the Intent.
            startActivity(Intent.createChooser(share, "Share using"));
        }
    }
}
