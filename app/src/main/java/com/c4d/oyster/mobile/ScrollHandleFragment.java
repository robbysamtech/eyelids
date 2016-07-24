package com.c4d.oyster.mobile;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.c4d.mobile.widgets.SlidingWidgets;

/**
 * Created by Robert on 7/22/2016.
 */
public class ScrollHandleFragment extends Fragment
{
    private ImageButton[] buttons;
    private SlidingWidgets slidingWidgets = null;
    private View scrollView = null;
    ImageButton peopleButton = null;
    ImageButton groupButton = null;
    ImageButton otherButton = null;
    ImageButton scrollButton = null;
    private boolean collapsed = true;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


        peopleButton = (ImageButton) view.findViewById(R.id.buttonPeople);
        groupButton = (ImageButton) view.findViewById(R.id.buttonGroup);
        otherButton = (ImageButton) view.findViewById(R.id.buttonOther);
        scrollButton = (ImageButton) view.findViewById(R.id.scroll);

        buttons = new ImageButton[]
                {

                        peopleButton, groupButton, otherButton,scrollButton
                };

        scrollButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            scrollTheButtons();
        }
    });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        scrollView = inflater.inflate(R.layout.scroll_handle, container, false);

        return scrollView;
    }

    private void scrollTheButtons()
    {
        Toast.makeText(this.getContext(),"Clicked", Toast.LENGTH_LONG).show();

        animate();

//        if(slidingWidgets != null)
//        slidingWidgets.animate(v, (FrameLayout) getView().findViewById(R.id.action_buttons));
    }



    public void animate()
    {
        if(collapsed) {
            expand();
            collapsed = false;
        }
        else {
            collapse();
            collapsed = true;
        }
    }

    public void expand()
    {
        final FrameLayout layout = (FrameLayout) scrollView;
        final int positionStartX = buttons[0].getLeft();
        final int positionStartY = buttons[0].getTop();
        final Activity activity = getActivity();
        Thread t = new Thread() {
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i < buttons.length; i++) {
                            int newPositionX = positionStartX;
                            //int newPositionY =  (buttons[0].getTop() + (i == 0 ? 0 : i * 5)) + (i == 0 ? 0 : (buttons[0].getHeight() * i));

                            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                            params.setMargins(newPositionX, (i*65), buttons[i].getWidth(), buttons[i].getHeight());
                            buttons[i].setLayoutParams(params);
                            layout.removeView(buttons[i]);
                            layout.addView(buttons[i]);


                            int smallMoveTimes = buttons[i-1].getHeight()+5;
                            System.out.print(smallMoveTimes);

                            for(int j=0;j<smallMoveTimes; j++)
                            {
                                int bu = buttons[0].getTop();
                                int newPositionY = ((i-1)*65)+((j+1));
                                System.out.print(newPositionY);
                                params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                                params.setMargins(newPositionX, newPositionY, buttons[i].getWidth(), buttons[i].getHeight());
                                buttons[i].setLayoutParams(params);
                                layout.removeView(buttons[i]);
                                layout.addView(buttons[i]);
                                layout.requestLayout();


                            }

                    }
                }});
            }
        };

        t.start();
    }

    public void collapse()
    {
        final FrameLayout layout = (FrameLayout) scrollView;
        final int positionStartX = buttons[0].getLeft();
        final int positionStartY = buttons[0].getTop();
        final Activity activity = getActivity();

        Thread t = new Thread() {
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < buttons.length; i++) {
                            int newPositionX = positionStartX;
                            int newPositionY = positionStartY;
                            if (i == (buttons.length - 1)) {
                                newPositionY = newPositionY + buttons[0].getHeight() + 5;
                            }

                            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                            params.setMargins(newPositionX, newPositionY, buttons[i].getWidth(), buttons[i].getHeight());
                            buttons[i].setLayoutParams(params);
                            layout.removeView(buttons[i]);
                            layout.addView(buttons[i]);
                            layout.requestLayout();
                        }
                    }
                });
            }
        };
    t.start();
    }

}



