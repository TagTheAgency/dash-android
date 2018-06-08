package com.tagtheagecy.dash;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class DashActivity extends Activity {

    final Random rnd = new Random();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);

        setContentView(R.layout.activity_dash);

        final ImageView img = (ImageView) findViewById(R.id.imageView);

        final String str = "img_" + (rnd.nextInt(24) + 1);
        img.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable",  getApplicationContext())));

        img.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeLeft() {
                showNewImage(img);
            }
            @Override
            public void onSwipeRight() {
                showNewImage(img);
            }
        });
    }

    private void showNewImage(ImageView img) {
        final String str = "img_" + (rnd.nextInt(24) + 1);
        img.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable",  getApplicationContext())));
    }


    protected final static int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name " + resName);
        } else {
            return ResourceID;
        }
    }
}
