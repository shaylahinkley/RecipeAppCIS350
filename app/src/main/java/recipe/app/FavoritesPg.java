package recipe.app;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FavoritesPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_pg);

        configureFavBacktoHomeButton();
    }

    public void configureFavBacktoHomeButton() {
        Button favBackHomeBtn = (Button) findViewById(R.id.favBackHomeBtn);
        favBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
