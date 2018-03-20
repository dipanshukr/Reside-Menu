package com.kumar.dipanshu.residemenu.ResideTransformation;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.kumar.dipanshu.residemenu.R;

public class HorizontalReside implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {

        //Hiding those pages which are way off-screen to the left or to the right.
        if (position < -1) {
            page.setAlpha(0);

        } else if (position > 1) {
            page.setAlpha(0);

        } else {
            page.setAlpha(1);

        }


        if (page.getId() == R.id.menuFirst){
            page.setTranslationX(-position*page.getWidth());
        }
        else if (page.getId() == R.id.contentPage){
            if (position < 0){
                float scale = Math.max(0.5f,1-Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaWidth = page.getWidth() - scale*page.getWidth();

                page.setTranslationX(-position*page.getWidth() - deltaWidth/2);
            }
            else if (position > 0){
                float scale = Math.max(0.5f,1-Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);

                float deltaWidth = page.getWidth() - scale*page.getWidth();
                page.setTranslationX((1-position)*page.getWidth() - scale*page.getWidth() - deltaWidth/2);
            }
        }
        else if (page.getId() == R.id.menuSecond){
            page.setTranslationX(-position*page.getWidth());
        }

    }

}