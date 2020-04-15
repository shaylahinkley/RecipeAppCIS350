package recipe.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Class that allows pop up windows to be used when
 * in the search section of the app. This class controls the aspects
 * of the screen when an item from the searched item list is pressed
 */
public class Pop extends Activity {

    /**Instance variable that allows the cookbook recipe to add things to the pop view */
   private Cookbook recipe;

   /**Instance variable that pulls the clicked recipe name to enable information to be pushed to pop view */
   private RecentPg search;

    @Override
    protected void onCreate(final Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.searchpopwindow);

        DisplayMetrics dm =  new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));

        //gets the string name of the recipe clicked and displays it in the text view
        Bundle bundle = getIntent().getExtras();
        String clickedName = bundle.getString("detail");
        TextView textView = (TextView) findViewById(R.id.searchPopTextView);

        //allows the textview to scroll if text is longer than size of text view
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(clickedName);
    }
}
