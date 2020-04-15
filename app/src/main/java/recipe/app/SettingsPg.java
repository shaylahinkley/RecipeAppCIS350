package recipe.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


/**
 * A class that builds the Settings screen of the Android App.
 * It allows the user to set their name and preferences.
 * In future releases, allergies will be added to filter out different recipes.
 * Maybe even more personalized experiences
 * will be added in future release based off settings.
 * See: activity_settings_xml
 *
 * @author Shayla Hinkley
 */
public class SettingsPg extends AppCompatActivity {

    /** instance variable that stores the name of the user. */
    private String name;

    /**
     * Method that creates and builds the Settings Page.
     * @param savedInstanceState - ADD STUFF HERE
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_pg);

        configureSettingsBackHomeBtn();

//        final HelperVariables helper = new HelperVariables();
        Button saveSettingsBtn = (Button) findViewById(R.id.saveSettingsBtn);
        final EditText nameText = (EditText) findViewById(R.id.editTextName);
//        nameText.setText(helper.getName());
        nameText.setText(this.name);
        saveSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                helper.setName(nameText.getText().toString());
                    name = nameText.getText().toString();
                    nameText.setText(nameText.getText().toString());
////                nameText.setText(nameText.getText().toString());
//                nameText.setText(helper.getName());
            }
        });
//        editTextName = (EditText) findViewById(R.id.editTextName);
//        Button saveSettingsBtn = (Button) findViewById(R.id.settingsBtn);
//        saveSettingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                mainActivity.setName(editTextName.getText().toString());
////                editTextName.setText(mainActivity.getName());
//                editTextName.setText(editTextName.getText().toString());
//
//            }
//        });

    }

    /**
     * Method that sets the name of the user.
     * @param newName String of the user's name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Method that gets the name of the user.
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that configures a button that allows the user
     * to switch back to the home page when the button is clicked.
     */
    public void configureSettingsBackHomeBtn() {
        Button settingsBackHomeBtn = (Button) findViewById(R.id.settingsBackHomeBtn);
        settingsBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                finish();
            }
        });
    }

    /**
     * Configures the save name button.
     */
    public void configureSaveBtn() {
       Button saveSettingsBtn = (Button) findViewById(R.id.settingsBtn);
       saveSettingsBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(final View v) {
//               mainActivity.setName(editTextName.getText().toString());
//               editTextName.setText(mainActivity.getName());
           }
       });
    }
}

