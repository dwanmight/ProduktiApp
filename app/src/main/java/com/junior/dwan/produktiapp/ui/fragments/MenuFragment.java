package com.junior.dwan.produktiapp.ui.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junior.dwan.produktiapp.R;

/**
 * Created by Might on 15.10.2016.
 */

public class MenuFragment extends Fragment {
TextView tvMeal,tvMilkProd,tvVeget,tvNight, tvfowlMeat,tvEggs,tvBerries,tvFruits,tvFish,tvGrocery,tvHoney,tvMushrooms,tvSeedling,tvTrees,tvWine,tvOther;
TextView [] massCategory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_menu,container,false);
        Typeface keys = Typeface.createFromAsset(getActivity().getAssets(),   getString(R.string.digit_keyboard_font_tatiana));
        ViewGroup keyboardArea = (ViewGroup)v.findViewById(R.id.digit_keyboard_layout);
        initializeTVCategory(v);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),getString(R.string.digit_keyboard_font_tatiana));
        for (TextView tvCategory:massCategory){
                    tvCategory.setTypeface(typeface);
        }


        return v;

    }

    private void initializeTVCategory(View v) {
        tvMeal=(TextView)v.findViewById(R.id.category_tv_meal);
        tvMilkProd=(TextView)v.findViewById(R.id.category_tv_milk);
        tvVeget=(TextView)v.findViewById(R.id.category_tv_veget);
        tvNight=(TextView)v.findViewById(R.id.category_tv_night);
        tvfowlMeat =(TextView)v.findViewById(R.id.category_tv_fowlMeat);
        tvEggs=(TextView)v.findViewById(R.id.category_tv_eggs);
        tvFruits=(TextView)v.findViewById(R.id.category_tv_fruits);
        tvBerries=(TextView)v.findViewById(R.id.category_tv_berries);
        tvFish=(TextView)v.findViewById(R.id.category_tv_fish);
        tvGrocery=(TextView)v.findViewById(R.id.category_tv_grocery);
        tvHoney=(TextView)v.findViewById(R.id.category_tv_honey);
        tvMushrooms=(TextView)v.findViewById(R.id.category_tv_mushrooms);
        tvSeedling=(TextView)v.findViewById(R.id.category_tv_seedling);
        tvTrees=(TextView)v.findViewById(R.id.category_tv_trees);
        tvWine=(TextView)v.findViewById(R.id.category_tv_wine);
        tvOther=(TextView)v.findViewById(R.id.category_tv_other);
        massCategory=new TextView[]{tvMeal,tvMilkProd,tvVeget,tvNight, tvfowlMeat,tvEggs,tvBerries,tvFruits,tvFish,tvGrocery,tvHoney,tvMushrooms,tvSeedling,tvTrees,tvWine,tvOther};
    }

    public void setFont(ViewGroup group, Typeface font) {
        int count = group.getChildCount();
        View v;
        for(int i = 0; i < count; i++) {
            v = group.getChildAt(i);
            if(v instanceof TextView) {
                ((TextView)v).setTypeface(font);
            } else if(v instanceof ViewGroup) {
                setFont((ViewGroup) v, font);
            }
        }
    }



}