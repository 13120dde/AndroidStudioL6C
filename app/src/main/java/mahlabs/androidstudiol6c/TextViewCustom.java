package mahlabs.androidstudiol6c;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by 13120dde on 2017-10-06.
 */

public class TextViewCustom extends android.support.v7.widget.AppCompatTextView{


    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void colorize(){
        new AsyncColorChanger().execute();
    }

    private class AsyncColorChanger extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... integers) {
            int y=0;
            while(y<200){
                try {
                    Thread.sleep(50);
                    Integer color = Color.argb(255, new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
                    publishProgress(color);
                    y++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            publishProgress(0);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            TextViewCustom.this.setBackgroundColor(values[0]);
        }
    }


}
