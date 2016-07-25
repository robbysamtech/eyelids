package com.c4d.mobile.widgets;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Robert on 7/3/2016.
Test Kinjal
 */
public class SlidingWidgets
{
    private ImageButton buttons[] = null;
    private int initialPositionX = 0;

    public SlidingWidgets(ImageButton buttons[])
    {
        this.buttons = buttons;

    }

    public void animate(View v, FrameLayout layout)
    {
        int positionStartX = buttons[0].getLeft();
        int positionStartY = buttons[0].getTop();

        //Toast.makeText(v.getContext(),"Start position - "+positionStartY, Toast.LENGTH_LONG).show();

        for(int i=0; i < buttons.length; i++)
        {
            int newPositionX = positionStartX;//+ (buttons[i-1].getWidth()*i)+(10*i)
           // int newPositionY = positionStartY;//S+ (i==0?0:20);

            int newPositionY = positionStartY = (buttons[0].getTop()+(i==0?0:i*20))+(i==0?0:(buttons[i].getHeight()*i));


           // buttons[i].setTop(newPositionX);
           // buttons[i].setLeft(newPositionY);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(newPositionX,newPositionY, buttons[i].getWidth(),buttons[i].getHeight());

            buttons[i].setLayoutParams(params);



            layout.removeView(buttons[i]);
            layout.addView(buttons[i]);

            //layout.requestLayout();

           // Toast.makeText(v.getContext(),buttons[i].toString(), Toast.LENGTH_SHORT).show();



           // Toast.makeText(v.getContext(),"Changing1 values - "+positionStartY, Toast.LENGTH_LONG).show();
        }


        Toast.makeText(v.getContext(),"Run complete", Toast.LENGTH_LONG).show();
    }


}
