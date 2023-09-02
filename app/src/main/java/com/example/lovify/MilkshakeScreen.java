package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lovify.databinding.ActivityMilkshakeScreenBinding;

public class MilkshakeScreen extends AppCompatActivity {
    ActivityMilkshakeScreenBinding binding;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMilkshakeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager=findViewById(R.id.vpgr);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    class ImageAdapter extends PagerAdapter {
        private Context context;
        private int[] img_id = new int[]{};

        public ImageAdapter(Context context1){
            context=context1;
        }

        @Override
        public int getCount() {
            return img_id.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView img = new ImageView(context);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setImageResource(img_id[position]);
            container.addView(img,0);
            return img;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView)object);
        }
    }
}