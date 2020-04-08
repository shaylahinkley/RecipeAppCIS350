package recipe.app;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private ArrayList<String> myArrayList;

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

        myInventory = new Inventory();
        myArrayList = new ArrayList<String>();
        configureStockBackHomeBtn();

        try {
            for (String str : getAssets().list("")){
                if(str.contains("test")) {
                    myInventory.addToCookbook(getAssets().open(str));
                }
            }
        System.out.println(myInventory.getMyCookbook() +  "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream stock = openFileInput("test.txt");
            Scanner scr = new Scanner(stock);
            while(scr.hasNextLine()){
                myArrayList.add(scr.nextLine());
                // System.out.println(items);
            }

            stock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //adding stock list view id
        ListView stockListView = (ListView) findViewById(R.id.stockListView);

        //array adapter for the array list of stock items to put into the list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArrayList);
        stockListView.setAdapter(arrayAdapter);

//        textView = (TextView) findViewById(R.id.stockTextView);

        //id for the add to stock button
        Button addToStockBtn = (Button) findViewById(R.id.addToStockBtn);

//        textView.setText(myArrayList.toString());

        //id for the edit text areas of quantity and name ingredient text
        final EditText quantityText = (EditText) findViewById(R.id.quantityEditText);
        final EditText nameIngredientText = (EditText) findViewById(R.id.nameOfIngredientEditText);

        //adds a listener to the add to stock button to take action
        addToStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myArrayList.add(quantityText.getText().toString() + " --- " + nameIngredientText.getText().toString());
//                    textView.setText(textView.getText().toString() + myArrayList.get(myArrayList.size() -1 ) + "\n");

//
//                ingredient = new Ingredients(quantityText.getText().toString(), nameIngredientText.getText().toString());
//
//                if(myInventory.getFridge() != null) {
//                    if (myInventory.getFridge().contains(ingredient)) {
//                        //error message, its in fridge, change quantity if user wants
//                    } else {
//                        myInventory.addToFridge(quantityText.getText().toString(), nameIngredientText.getText().toString());
//                   }
//              }
//                        quantityText.setText("");
//                        nameIngredientText.setText("");
//
//                textView.setText(textView.getText().toString() + myInventory.getFridge().get(myInventory.getFridge().size() - 1) + "\n" );
            }
        });

//        final EditText quantityText = (EditText) findViewById(R.id.quantityEditText);
//        final EditText nameIngredientText = (EditText) findViewById(R.id.nameOfIngredientEditText);
//        addToStockBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myArrayList.add(quantityText.getText().toString() + " --- " + nameIngredientText.getText().toString());
//                    textView.setText(textView.getText().toString() + myArrayList.get(myArrayList.size() -1 ) + "\n");
//
//                ingredient = new Ingredients(quantityText.getText().toString(), nameIngredientText.getText().toString());
//
//                if(myInventory.getFridge() != null) {
//                    if (myInventory.getFridge().contains(ingredient)) {
//                        //error message, its in fridge, change quantity if user wants
//                    } else {
//                        myInventory.addToFridge(quantityText.getText().toString(), nameIngredientText.getText().toString());
//                   }
//              }
//                        quantityText.setText("");
//                        nameIngredientText.setText("");
//
//                textView.setText(textView.getText().toString() + myInventory.getFridge().get(myInventory.getFridge().size() - 1) + "\n" );
//            }
//        });
    }

    /**
     * Method that configures a button that allows the user to switch
     * back to the Main Activity (Home) Page when clicked
     */
    public void configureStockBackHomeBtn() {
        Button stockBackHomeBtn = (Button) findViewById(R.id.stockBackHomeBtn);
        stockBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("test.txt", MODE_PRIVATE);
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

