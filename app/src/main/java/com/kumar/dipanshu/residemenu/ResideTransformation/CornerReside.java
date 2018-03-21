package com.kumar.dipanshu.residemenu.ResideTransformation;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.kumar.dipanshu.residemenu.R;

public class CornerReside implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        //Hiding those pages which are way off-screen to the left or to the right.
        if (position < -1) {
            page.setAlpha(0);

        }
        else if (position > 1) {
            page.setAlpha(0);

        }
        else {
            page.setAlpha(1);

        }


        if (page.getId() == R.id.menuFirst) {
            //putting fragment to the start of the screen
            page.setTranslationX(-position * page.getWidth());

        }
        else if (page.getId() == R.id.contentPage) {
            //putting fragment to the start of the screen
            page.setTranslationX(-position * page.getWidth());

            //when we swipe to left this code applied
            if (position < 0) {

                //first we do scaling to 50%
                float scale = Math.max(0.5f, 1 - Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaHeight = page.getHeight() - scale * page.getHeight();
                float deltaWidth = page.getWidth() - scale * page.getWidth();

                //move the fragment to top
                page.setTranslationY(+deltaHeight / 2);
                //place the fragment to the start of the screen and move the fragment to left
                page.setTranslationX(-position * page.getWidth() - deltaWidth / 2);

            }
            //when we swipe to right this code applied
            else if (position > 0) {

                //first we do scaling to 50%
                float scale = Math.max(0.5f, 1 - Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaHeight = page.getHeight() - scale * page.getHeight();
                float deltaWidth = page.getWidth() - scale * page.getWidth();

                //move the fragment to bottom
                page.setTranslationY(-deltaHeight / 2);
                //place the fragment to the start of the screen and move the fragment to right
                page.setTranslationX(-position * page.getWidth() + deltaWidth / 2);

            }

        }
        else if (page.getId() == R.id.menuSecond) {
            //putting fragment to the start of the screen
            page.setTranslationX(-position * page.getWidth());

        }

    }
}