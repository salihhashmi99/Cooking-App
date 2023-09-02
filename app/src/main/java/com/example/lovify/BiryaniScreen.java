package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.lovify.databinding.ActivityBiryaniScreenBinding;
import com.example.lovify.databinding.ActivityBurgerScreenBinding;

public class BiryaniScreen extends AppCompatActivity {
    ActivityBiryaniScreenBinding binding;
    ViewPager Viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBiryaniScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Viewpager = findViewById(R.id.vpgr);
        ImageAdapter adapter = new ImageAdapter(this);
        Viewpager.setAdapter(adapter);

        binding.toolBar.imgViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu(v);
            }
        });
    }

    //to make the menu button invisible
    private void showPopMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                MenuItem menuItem = item.getSubMenu().findItem(R.id.imgViewMenu);
                menuItem.setVisible(false);
                return true;
            }
        });
    }

        class ImageAdapter extends PagerAdapter {
            private Context context;
            private int[] imgid=new int[]{};

            public ImageAdapter(Context context1) {
                context=context1;
            }

            @Override
            public int getCount() {
                return imgid.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView img=new ImageView(context);
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setImageResource(imgid[position]);
                container.addView(img,0);
                return img;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((ImageView)object);
            }
        }
    }