package recipe.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Class that allows pop up windows to be used when
 * in the search section of the app. This class controls the aspects
 * of the screen when an item from the searched item list is pressed
 */
public class Pop extends Activity {
    @Override
    protected void onCreate(final Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.searchpopwindow);

        DisplayMetrics dm =  new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));
    }
}
