package recipe.app;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


/**
 * A class that builds the Settings screen of the Android App. It allows the user to set their
 * name and preferences. In future releases, allergies will be added to filter out different recipes.
 * Maybe even more personalized experiences will be added in future release based off settings.
 * See: activity_settings_xml
 *
 * @author Shayla Hinkley
 * @version 1.0
 */
public class SettingsPg extends AppCompatActivity {

    /**
     * Method that creates and builds the Settings Page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_pg);

        configureSettingsBackHomeBtn();
    }

    /**
     * Method that configures a button that allows the user
     * to switch back to the home page when the button is clicked
     */
    public void configureSettingsBackHomeBtn() {
        Button settingsBackHomeBtn = (Button) findViewById(R.id.settingsBackHomeBtn);
        settingsBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

