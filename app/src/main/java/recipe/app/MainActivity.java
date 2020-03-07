package recipe.app;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureFavoritesBtn();
        configureStockBtn();
        configureRecentsBtn();
        configureSettingsBtn();
    }

    public void configureFavoritesBtn() {
        Button favoritesBtn = (Button) findViewById(R.id.favoritesBtn);
        favoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, FavoritesPg.class));
            }
        });
    }

    public void configureStockBtn() {
        Button stockBtn = (Button) findViewById(R.id.stockBtn);
        stockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, StockPg.class));
            }
        });
    }

    public void configureRecentsBtn() {
        Button recentsBtn = (Button) findViewById(R.id.recentsBtn);
        recentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, RecentPg.class));
            }
        });
    }

    public void configureSettingsBtn() {
        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(MainActivity.this, SettingsPg.class));
            }
        });
    }
}
