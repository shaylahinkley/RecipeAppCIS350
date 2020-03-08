package recipe.app;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * A class that builds the main screen of the Android App. It initializes all the buttons and allows the user
 * to navigate between pages.
 * See: activity_main.xml
 *
 * @author Shayla Hinkley
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
//
//    private String name = "John/Jane Doe Doe";
//    private int age;

    /**
     * Method that builds the main page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureFavoritesBtn();
        configureStockBtn();
        configureRecentsBtn();
        configureSettingsBtn();
    }

    /**
     * Method that configures the Favorites button that
     * allows the user to change to the Favorites page
     */
    public void configureFavoritesBtn() {
        Button favoritesBtn = (Button) findViewById(R.id.favoritesBtn);
        favoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, FavoritesPg.class));
            }
        });
    }

    /**
     * Method that configures the Stock Page button that
     * allows the user to change to the Stock Page
     */
    public void configureStockBtn() {
        Button stockBtn = (Button) findViewById(R.id.stockBtn);
        stockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, StockPg.class));
            }
        });
    }

    /**
     * Method that configures the Recents Button that
     * allows the user to change to the Recents Page
     */
    public void configureRecentsBtn() {
        Button recentsBtn = (Button) findViewById(R.id.recentsBtn);
        recentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, RecentPg.class));
            }
        });
    }

    /**
     * Method that configures the Settings Button
     * that allows the user to change to the Settings Page
     */
    public void configureSettingsBtn() {
        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, SettingsPg.class));
            }
        });
    }

//    public void setName(String name) {
//        this.name = name;
//    }
////
////    public void setAge(int age) {
////        this.age = age;
////    }
////
//    public String getName() {
//        return this.name;
//    }
}
