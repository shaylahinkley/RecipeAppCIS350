package recipe.app;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_pg);

        configureSettingsBackHomeBtn();
    }
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

