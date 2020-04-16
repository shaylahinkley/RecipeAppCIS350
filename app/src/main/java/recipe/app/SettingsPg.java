package recipe.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;


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

    /**Private button that saves settings*/
    private Button saveSettingsBtn;

    /**int representing the theme enum code*/
    private int themeNum;

    /**
     * Method that creates and builds the Settings Page.
     * @param savedInstanceState - ADD STUFF HERE
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        try {
            InputStream fav = openFileInput("theme.txt");
            Scanner scr = new Scanner(fav);
            themeNum = scr.nextInt();
            fav.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTheme(themeNum);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_pg);

        saveSettingsBtn = (Button) findViewById(R.id.saveSettingsBtn);

        configureSettingsBackHomeBtn();
        configureSaveBtn();

        final EditText nameText = (EditText) findViewById(R.id.editTextName);

        nameText.setText(this.name);
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

       saveSettingsBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(final View v) {
               System.out.println("click");
               try {
                   FileOutputStream fileOutputStream = openFileOutput("theme.txt", MODE_PRIVATE);
                   PrintWriter printWriter = new PrintWriter(fileOutputStream);

                   if(themeNum == android.R.style.Theme_Black_NoTitleBar){
                       themeNum = android.R.style.Theme_Light_NoTitleBar;
                   }else{
                       themeNum = android.R.style.Theme_Black_NoTitleBar;
                   }
                   printWriter.println(themeNum);

                   printWriter.flush();
                   printWriter.close();
                   fileOutputStream.close();

               } catch (Exception e) {
                   e.printStackTrace();
               }
               finish();
           }
       });
    }


}

