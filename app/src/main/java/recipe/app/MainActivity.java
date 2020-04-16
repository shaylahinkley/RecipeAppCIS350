package recipe.app;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.InputStream;
import java.util.Scanner;

/**
 * A class that builds the main screen of the Android App.
 * It initializes all the buttons and allows the user
 * to navigate between pages.
 * See: activity_main.xml
 *
 * @author Shayla Hinkley
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method that builds the main page.
     *
     * @param savedInstanceState - reference to
     *                           Bundle Objecct that allows restore
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        //method that loads the theme from a file
        try {
            InputStream fav = openFileInput("theme.txt");
            Scanner scr = new Scanner(fav);
            setTheme(scr.nextInt());
            fav.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //loads the page and creates it
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configures the buttons on the page
        configureFavoritesBtn();
        configureStockBtn();
        configureRecentsBtn();
        configureSettingsBtn();
    }

    /**
     * Method that configures the Favorites button that
     * allows the user to change to the Favorites page.
     */
    public void configureFavoritesBtn() {
        Button favoritesBtn = (Button) findViewById(R.id.favoritesBtn);
        favoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(MainActivity.this, FavoritesPg.class));
            }
        });
    }

    /**
     * Method that configures the Stock Page button that
     * allows the user to change to the Stock Page.
     */
    public void configureStockBtn() {
        Button stockBtn = (Button) findViewById(R.id.stockBtn);
        stockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(MainActivity.this, StockPg.class));
            }
        });
    }

    /**
     * Method that configures the Recents Button that
     * allows the user to change to the Recents Page.
     */
    public void configureRecentsBtn() {
        Button recentsBtn = (Button) findViewById(R.id.recentsBtn);
        recentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(MainActivity.this, SearchPage.class));
            }
        });
    }

    /**
     * Method that configures the Settings Button
     * that allows the user to change to the Settings Page.
     */
    public void configureSettingsBtn() {
        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivityForResult(new Intent(
                        MainActivity.this, SettingsPg.class), 1);
                recreate();
            }
        });
    }

    /** Method that checks if the activity
     * that sent you back to the home(main) screen is
     * settings, then it recreates the activity
     * according to the theme.
     * @param requestCode current theme
     * @param resultCode what the theme should be
     * @param data data to prove it
     */
    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            this.recreate();
        }
    }
}
