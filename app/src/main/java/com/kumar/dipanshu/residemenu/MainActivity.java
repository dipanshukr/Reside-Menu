package com.kumar.dipanshu.residemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kumar.dipanshu.residemenu.Fragments.ContentFragment;
import com.kumar.dipanshu.residemenu.Fragments.FifthMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.FirstMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.FourthMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.SecondMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.SixthMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.ThirdMenuFragment;
import com.kumar.dipanshu.residemenu.ResideTransformation.CornerReside;
import com.kumar.dipanshu.residemenu.ResideTransformation.HorizontalReside;
import com.kumar.dipanshu.residemenu.ResideTransformation.VerticalReside;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);

        //setting fragment pager adapter
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());


        intent = getIntent();
        String option = intent.getStringExtra(Constant.OPTION);

        switch (option) {
            case Constant.HORIZONTAL_RESIDE:
                //adding fragments for Horizontal Reside menu
                myPagerAdapter.addFragments(new FirstMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new SecondMenuFragment());

                viewPager.setPageTransformer(true, new HorizontalReside());
                break;
            case Constant.VERTICAL_RESIDE:
                //adding fragments for Vertical Reside menu
                myPagerAdapter.addFragments(new ThirdMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new FourthMenuFragment());

                viewPager.setPageTransformer(true, new VerticalReside());
                break;
            case Constant.CORNER_RESIDE:
                //adding fragments for Vertical Reside menu
                myPagerAdapter.addFragments(new FifthMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new SixthMenuFragment());

                viewPager.setPageTransformer(true, new CornerReside());
                break;
        }

        //set adapter to vewpager instance
        viewPager.setAdapter(myPagerAdapter);

        viewPager.setCurrentItem(1);    //page shown to user when he opened the app
    }


    //method called when user clicked on menu fragment layouts
    public void showPage(View view){
        viewPager.setCurrentItem(1);
    }

}