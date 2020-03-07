package recipe.app;


import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RecentPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_pg);

        configureRecentsBacktoHomeButton();
    }

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
