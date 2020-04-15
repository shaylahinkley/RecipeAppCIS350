package recipe.app;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that builds the Recents Page.
 * The Recents Page displays recent recipes that were
 * viewed by the user. This functionality will be finalized in future release.
 * See: activity_recent_pg.xml
 *
 * @author Shayla Hinkley
 */
public class SearchPage extends AppCompatActivity {

    /** Instance variable for the arraylist of recipe names */
    private ArrayList<String> recipeNames;

    /** Instance variable for the
     * array adapter that is being used in list view */
    private ArrayAdapter arrayAdapter;

    /** Instance variable that allows the
     * Cookbook class to link to front end for use */
    private Cookbook recipe;

    /**Instance variable that stores the name of
     * the recipe name that is clicked to be used for pop up */
    private String clickedName;

    /**
     * Method that builds and creates the Recents page.
     * @param savedInstanceState - reference to Bundle Object
     *                           that allows restore
     */

    /**
     * Instance variable to pull and create an inventroy
     **/
    Inventory myInventory;

    /**
     *
     */
    ArrayList<Recipe> recipes;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_pg);
        configureRecentsBacktoHomeButton();

        recipe = new Cookbook();
        recipeNames = new ArrayList<String>();

        //adding recipe names to the arraylist

        myInventory = new Inventory();

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

        recipes = myInventory.getMyCookbook().getRecipes();

        for(Recipe r : recipes){
            recipeNames.add(r.getName());
        }
        /*   recipeNames.add("Chicken Parm");
        recipeNames.add("Icecream");
        recipeNames.add("Chicken Alfredo");
        recipeNames.add("Apple");
        recipeNames.add("Banana");
        recipeNames.add("Chocolate Chip Cookies");
        recipeNames.add("Peanut Butter Cookies");
        recipeNames.add("Steak");
        recipeNames.add("Milk");
        recipeNames.add("Pizza Bagels");
        recipeNames.add("Stuffed Peppers");
        recipeNames.add("Greek Yogurt");
        recipeNames.add("Red Velvet Cake");
        recipeNames.add("Sugar Cookies");
*/
        //adapter for array - can be used for example array and actual array
        arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, recipeNames);

        //setting up the list view
        ListView listView = (ListView) findViewById(R.id.searchListView);
        listView.setAdapter(arrayAdapter);

        //setting up the search filter
        final EditText searchFilter =
                (EditText) findViewById(R.id.searchEditText);
        searchFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start,
                                          final int count, final int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, final int start,
                                      final int before, final int count) {
                (SearchPage.this).arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(final Editable s) {

            }
        });

        //setting on click listener for the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent,
                                    final View view, final int position,
                                    final long id) {

                String item = (String) parent.getItemAtPosition(position);
                clickedName = item;
                //sends information to the pop activity class
                Intent intent = new Intent(SearchPage.this, Pop.class);
                intent.putExtra("detail", clickedName.replace(" ", "")+ "_recipe");

                //starts the activity
                startActivity(intent);
            }
        });
    }

    /**
     * Method that configures a button that allows
     * the user to navigate back to the home page
     * when the button is pressed.
     */
    public void configureRecentsBacktoHomeButton() {
        Button recentsBackHomeBtn = (
                Button) findViewById(R.id.recentsBacktoHomeBtn);
        recentsBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                finish();
            }
        });
    }

}
