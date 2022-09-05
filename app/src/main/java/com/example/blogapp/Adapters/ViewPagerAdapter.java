package com.example.blogapp.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import  androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import  android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.blogapp.R;

import kotlinx.coroutines.JobKt;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    private int images[]={
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,

    };
    private String titles[]={
            "Learn",
            "Create",
            "Enjoy"
    };
    private String desc[]={
            "How to Code",
            "Innovative Solutions",
            "A GREAT environment"
    };


    @Override
    public int getCount(){
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object){
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_pager,container,false);

        //init views
        ImageView imageView = v.findViewById(R.id.imgViewPager);
        TextView txtTitle = v.findViewById(R.id.txtTitleViewPager);
        TextView txtDesc = v.findViewById(R.id.txtTitleDescViewPager);

        imageView.setImageResource(images[position]);
        txtTitle.setText(titles[position]);
        txtDesc.setText(desc[position]);


        container.addView(v);
        return v;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((LinearLayout)object);
    }

}
