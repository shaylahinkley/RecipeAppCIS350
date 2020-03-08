package recipe.app;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/**
 * A class that builds the Stock Page screen of the Android App. It allows the user to add
 * an ingredient with its quantity to the list of stuff that is currently in the stock(pantry)
 * of the user. In future release, if the ingredient already exists, it will change the quantity.
 * Also, it will work with the actual database in future release.
 * See: activity_stock_pg.xml
 *
 * @author Shayla Hinkley
 */
public class StockPg extends AppCompatActivity {

    /** Instance variable of the Ingredients class */
    private Ingredients ingredient;

    /** Instance variable of the Inventory class */
    private Inventory myInventory;

    /** Private ArrayList that is used to display the different ingredients in the TextView for the User to see */
    private ArrayList<String> myArrayList = new ArrayList<String>();

    /** The quantity of the ingredient that is added to the stock */
    private String quantity;

    /**The name of ingredient that is added to the stock */
    private String nameOfIngredient;

    /** The TextView that allows the stock to be outputted to the screen once the user adds ingredients */
    private TextView textView;


    /**
     * Method that builds and creates the Stock Page. It also adds ingredients
     * to the ArrayList to be outputted to the screen once the user clicks the
     * add to stock button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_pg);
        configureStockBackHomeBtn();


        textView = (TextView) findViewById(R.id.stockTextView);
        Button addToStockBtn = (Button) findViewById(R.id.addToStockBtn);
        final EditText quantityText = (EditText) findViewById(R.id.quantityEditText);
        final EditText nameIngredientText = (EditText) findViewById(R.id.nameOfIngredientEditText);
        addToStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myArrayList.add(quantityText.getText().toString() + " " + nameIngredientText.getText().toString());
                    textView.setText(textView.getText().toString() + myArrayList.get(myArrayList.size() -1 ) + "\n");
//
//                ingredient = new Ingredients(quantityText.getText().toString(), nameIngredientText.getText().toString());
//
//                if(myInventory.getFridge() != null) {
//                    if (myInventory.getFridge().contains(ingredient)) {
//                        //error message, its in fridge, change quantity if user wants
//                    } else {
//                        myInventory.addToFridge(quantityText.getText().toString(), nameIngredientText.getText().toString());
//                    }
//                }
//
//                textView.setText(textView.getText().toString() + myInventory.getFridge().get(myInventory.getFridge().size() - 1) + "\n" );
            }
        });
    }

    /**
     * Method that configures a button that allows the user to switch
     * back to the Main Activity (Home) Page when clicked
     */
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

