package recipe.app;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * A class that builds the Favorites screen of the Android App.
 * It allows the user to view their favorite recipes in the app.
 * This will be fully functioning in future releases
 * See: activity_favorites_pg.xml
 *
 * @author Shayla Hinkley
 * @version 1.0
 */
public class FavoritesPg extends AppCompatActivity {

    /**
     * Method that builds and creates the Favorites Page.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_pg);

        configureFavBacktoHomeButton();
    }

    /**
     * Method that configures a button that allows
     * the user to navigate back to the home page when the button is clicked.
     */
    public void configureFavBacktoHomeButton() {
        Button favBackHomeBtn = (Button) findViewById(R.id.favBackHomeBtn);
        favBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                finish();
            }
        });
    }
}
