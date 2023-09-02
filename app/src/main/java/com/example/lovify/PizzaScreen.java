package com.example.lovify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovify.databinding.ActivityPizzaScreenBinding;

public class PizzaScreen extends AppCompatActivity {
    ActivityPizzaScreenBinding binding;
    ViewPager viewPager;
    TextView txtPizza, txtRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPizzaScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtPizza=findViewById(R.id.txtpasta);
        txtRecipe=findViewById(R.id.txtPastaRecipe);

        //set Image Adapter in View Pager
        viewPager=findViewById(R.id.vpgr);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    class ImageAdapter extends PagerAdapter{
        private Context context;
        private int[] imgid= new int[]{};

        public ImageAdapter(Context context1){
            context=context1;
        }

        @Override
        public int getCount(){
            return imgid.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object){
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
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
            container.removeView((ImageView)object);
        }

    }
}