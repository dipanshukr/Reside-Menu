package com.kumar.dipanshu.residemenu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kumar.dipanshu.residemenu.Fragments.ContentFragment;
import com.kumar.dipanshu.residemenu.Fragments.FirstMenuFragment;
import com.kumar.dipanshu.residemenu.Fragments.SecondMenuFragment;
import com.kumar.dipanshu.residemenu.ResideTransformation.HorizontalReside;
import com.kumar.dipanshu.residemenu.ResideTransformation.VerticalReside;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);

        //setting fragment pager adapter
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragments(new FirstMenuFragment());
        myPagerAdapter.addFragments(new ContentFragment());
        myPagerAdapter.addFragments(new SecondMenuFragment());


        //set adapter to vewpager instance
        viewPager.setAdapter(myPagerAdapter);


        viewPager.setPageTransformer(true,new VerticalReside());
        viewPager.setCurrentItem(1);    //page shown to user when he opened the app
    }


    //method called when user clicked on menu fragment layouts
    public void showPage(View view){
        viewPager.setCurrentItem(1);
    }

}