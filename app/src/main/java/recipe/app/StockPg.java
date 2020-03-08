package recipe.app;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StockPg extends AppCompatActivity {
    private Ingredients ingredient;
    private Inventory myInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_pg);

        configureStockBackHomeBtn();
        addIngredientFromEditText();
//        myInventory = new Inventory();
//        if(myInventory.getFridge().size() > 0) {
//            displayStock();
//        }
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

    public void addIngredientFromEditText() {
        Button addToStockBtn = (Button) findViewById(R.id.addToStockBtn);
        addToStockBtn.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                EditText quantityText = (EditText) findViewById(R.id.quantityEditText);
                String quantityStringFromEditText = quantityText.getText().toString();
                EditText nameIngredient = (EditText) findViewById(R.id.nameOfIngredientEditText);
                String nameIngredientStringFromEditText = nameIngredient.getText().toString();

                if(quantityStringFromEditText.contentEquals("") || quantityStringFromEditText.contentEquals("Quantity")) {
                    //please enter quantity error message
                }

                if(nameIngredientStringFromEditText.contentEquals("") || nameIngredientStringFromEditText.contentEquals("Name of Ingredient")) {
                    //please enter name of ingredient error message
                }

                ingredient = new Ingredients(quantityStringFromEditText, nameIngredientStringFromEditText);


                for(int i = 0; i < myInventory.getFridge().size() - 1; i++) {
                    if(myInventory.getFridge().contains(ingredient)) {
                        //make an error that is saying add to the fridge if user whats the change the quantity, allow them too
                    } else {
                        myInventory.addToFridge(quantityStringFromEditText, nameIngredientStringFromEditText);
                        displayStock();
                    }
                }
            }
        });

    }

    public void displayStock() {
        Object[] arr = myInventory.getFridge().toArray();
        ArrayAdapter adapter = new ArrayAdapter<String>(StockPg.this,R.layout.activity_stock_pg, (String[]) arr);
        ListView listViewStock = (ListView) findViewById(R.id.listViewStock);
        listViewStock.setAdapter(adapter);
    }
}

