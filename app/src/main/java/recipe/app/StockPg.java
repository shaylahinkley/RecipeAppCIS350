package recipe.app;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StockPg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_pg);

        configureStockBackHomeBtn();
    }
    public void configureStockBackHomeBtn() {
        Button stockBackHomeBtn = (Button) findViewById(R.id.stockBackHomeBtn);
        stockBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

