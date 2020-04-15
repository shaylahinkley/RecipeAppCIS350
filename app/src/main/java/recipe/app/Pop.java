package recipe.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Class that builds the pop up windows when a
 * recipe is pressed in the settings/recents page.
 * This class controls the aspects of the screen
 * when an item from the searched item list is pressed
 *
 * @author Shayla Hinkley
 */
public class Pop extends Activity {

    /**Instance variable that allows the
     * cookbook recipe to add things to the pop view */
   private Cookbook recipe;

   /**Instance variable that pulls the
    * clicked recipe name to enable information to be pushed to pop view */
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

        //takes the list view clicked name and moves all white space to find the file name
        String strippedName = clickedName.replaceAll("\\s+", "");
        strippedName = strippedName + "_recipe";
        String text = "";

        //adds the text from the file onto the pop up text view
        try {
            InputStream is = getAssets().open(strippedName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        textView.setText(text);
    }
}
