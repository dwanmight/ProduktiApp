package com.junior.dwan.produktiapp.ui.activities;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junior.dwan.produktiapp.R;
import com.junior.dwan.produktiapp.ui.fragments.MyOfficeFragment;
import com.junior.dwan.produktiapp.ui.fragments.MenuFragment;
import com.junior.dwan.produktiapp.utils.TabsPagerAdapter;

/**
 * Created by Might on 19.10.2016.
 */

public class TabActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
//        int actionBarTitleId = Resources.getSystem().getIdentifier("toolbar_title", "id", "android");
//        if (actionBarTitleId > 0) {
//            TextView title = (TextView) findViewById(actionBarTitleId);
//            if (title != null) {
//                title.setTextColor(Color.YELLOW);
//                title.setTextSize(40);
//                title.setGravity(Gravity.RIGHT);
//                Typeface font_sketch = Typeface.createFromAsset(getAssets(), "TatianaCTTNormal.ttf");
//                title.setTypeface(font_sketch);
//
//            }
//        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        Typeface typefaceTitle = Typeface.createFromAsset(getAssets(), getString(R.string.digit_keyboard_font_tatiana));
//        mTitle.setTypeface(typefaceTitle);
        setSupportActionBar(toolbar);
        customizeToolbar(toolbar);


//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setupFontTab();

    }


    public void customizeToolbar(Toolbar toolbar) {
        // Save current title and subtitle
        final CharSequence originalTitle = toolbar.getTitle();
        final CharSequence originalSubtitle = toolbar.getSubtitle();
        // Temporarily modify title and subtitle to help detecting each
        toolbar.setTitle("title");
        toolbar.setSubtitle("subtitle");

        for(int i = 0; i < toolbar.getChildCount(); i++){
            View view = toolbar.getChildAt(i);

            if(view instanceof TextView){
                TextView textView = (TextView) view;


                if(textView.getText().equals("title")){
                    // Customize title's TextView
                    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.MATCH_PARENT);
                    params.gravity = Gravity.CENTER_HORIZONTAL;
                    textView.setLayoutParams(params);

                    // Apply custom font using the Calligraphy library
                    Typeface typeface = Typeface.createFromAsset(getAssets(), getString(R.string.digit_keyboard_font_tatiana));
                    textView.setTypeface(typeface);

                } else if(textView.getText().equals("subtitle")){
                    // Customize subtitle's TextView
                    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.MATCH_PARENT);
                    params.gravity = Gravity.CENTER_HORIZONTAL;
                    textView.setLayoutParams(params);

                    // Apply custom font using the Calligraphy library
                    Typeface typeface = Typeface.createFromAsset(getAssets(), getString(R.string.digit_keyboard_font_tatiana));
                    textView.setTypeface(typeface);
                }
            }

            // Restore title and subtitle
            toolbar.setTitle(originalTitle);
            toolbar.setSubtitle(originalSubtitle);
        }
    }


    private void setupFontTab() {
        Typeface tf = Typeface.createFromAsset(getAssets(), getString(R.string.digit_keyboard_times_new_roman));
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tf);
                }
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new MenuFragment(), getString(R.string.tab_name_category));
        adapter.addFragment(new MyOfficeFragment(), getString(R.string.tab_name_my_office));
        viewPager.setAdapter(adapter);
    }

    public void setFont(ViewGroup group, Typeface font) {
        int count = group.getChildCount();
        View v;
        for (int i = 0; i < count; i++) {
            v = group.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(font);
            } else if (v instanceof ViewGroup) {
                setFont((ViewGroup) v, font);
            }
        }
    }
}