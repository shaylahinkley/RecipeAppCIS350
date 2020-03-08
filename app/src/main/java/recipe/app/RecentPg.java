package recipe.app;


import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * A class that builds the Recents Page. The Recents Page displays recent recipes that were
 * viewed by the user. This functionality will be finalized in future release.
 * See: activity_recent_pg.xml
 *
 * @author Shayla Hinkley
 * @version 1.0
 */
public class RecentPg extends AppCompatActivity {

    /**
     * Method that builds and creates the Recents page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_pg);

        configureRecentsBacktoHomeButton();
    }

    /**
     * Method that configures a button that allows
     * the user to navigate back to the home page
     * when the button is pressed.
     */
    public void configureRecentsBacktoHomeButton() {
        Button recentsBackHomeBtn = (Button) findViewById(R.id.recentsBacktoHomeBtn);
        recentsBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
