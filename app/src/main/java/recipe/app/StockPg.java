package recipe.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that builds the Stock Page screen of the Android App.
 * It allows the user to add an ingredient with its quantity to the
 * list of stuff that is currently in the stock(pantry) of the user.
 * In future release, if the ingredient already exists,
 * it will change the quantity.
 * Also, it will work with the actual database in future release.
 * See: activity_stock_pg.xml
 *
 * @author Shayla Hinkley
 */
public class StockPg extends AppCompatActivity {

    /** Instance variable of the Inventory class. */
    private Inventory myInventory;

    /** Private ArrayList that is used to display the different
     * ingredients in the TextView for the User to see. */
    private ArrayList<String> myArrayList;

    /**
     * Button that searches for recipes based on stock.
     */
    private Button searchButton;

    /**
     * Method that builds and creates the Stock Page. It also adds ingredients
     * to the ArrayList to be outputted to the screen once the user clicks the
     * add to stock button.
     * @param savedInstanceState Current state
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        try {
            InputStream fav = openFileInput("theme.txt");
            Scanner scr = new Scanner(fav);
            setTheme(scr.nextInt());
            fav.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_pg);

        myInventory = new Inventory();
        myArrayList = new ArrayList<String>();
        searchButton = findViewById(R.id.searchButton);
        configureStockBackHomeBtn();

        try {
            for (String str : getAssets().list("")) {
                if (str.contains("recipe")) {
                    myInventory.addToCookbook(getAssets().open(str));
                }
            }
        System.out.println(myInventory.getMyCookbook() +  "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream stock = openFileInput("test3.txt");
            Scanner scr = new Scanner(stock);
            while (scr.hasNextLine()) {
                myArrayList.add(scr.nextLine());
                // System.out.println(items);
            }

            stock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adding stock list view id
        ListView stockListView = (ListView) findViewById(R.id.stockListView);

        //array adapter for the array list of stock items
        // to put into the list view
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, myArrayList);
        stockListView.setAdapter(arrayAdapter);


        //id for the add to stock button
        Button addToStockBtn = (Button) findViewById(R.id.addToStockBtn);


        //id for the edit text areas of quantity and name ingredient text
        final EditText nameIngredientText = (
                EditText) findViewById(R.id.nameOfIngredientEditText);

        //adds a listener to the add to stock button to take action
        addToStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                myArrayList.add(nameIngredientText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });


        //Searched recipes based on stock
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ArrayList<Recipe> r = myInventory.getMyCookbook().getRecipes();
                ArrayList<Ingredients> ingredientsArrayList = new ArrayList<>();
                for (String s : myArrayList) {
                    ingredientsArrayList.add(new Ingredients("", s));
                }

                //sends information to the pop activity class
                Intent intent = new Intent(StockPg.this, Pop.class);
                intent.putExtra("detail", myInventory.
                        findRecipe(ingredientsArrayList)
                        .getName().replace(" ", "") +  "_recipe");
                System.out.println(myInventory.findRecipe(ingredientsArrayList).
                        getName().replace(" ", "") + "_recipe");

                //starts the activity
                startActivity(intent);
            }
        });

        //removing item from arraylist on the
        // screen when user holds a long click
        stockListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent,
                                           final View view,
                                           final int position, final long id) {
                myArrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
               Toast.makeText(getBaseContext(),
                       "Item deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /**
     * Method that configures a button that allows the user to switch
     * back to the Main Activity (Home) Page when clicked.
     */
    public void configureStockBackHomeBtn() {
        Button stockBackHomeBtn = (Button) findViewById(R.id.stockBackHomeBtn);
        stockBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput(
                            "test3.txt", MODE_PRIVATE);
                    PrintWriter printWriter = new PrintWriter(fileOutputStream);

                    for (String s : myArrayList) {
                        printWriter.println(s);
                        System.out.println(s);
                    }

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

