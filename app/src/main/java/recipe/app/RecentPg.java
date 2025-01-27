package recipe.app;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * A class that builds the Recents Page.
 * The Recents Page displays recent recipes that were
 * viewed by the user. This functionality will be finalized in future release.
 * See: activity_recent_pg.xml
 *
 * @author Shayla Hinkley
 */
public class RecentPg extends AppCompatActivity {

    /** Recently searched recipes. */
    private ArrayList<String> recipeNames;

    /** Makes an array into the android format. */
    private ArrayAdapter arrayAdapter;

    /** Cookbook where recipes you like can be stored. */
    private Cookbook recipe;

    /**
     * Method that builds and creates the Recents page.
     * @param savedInstanceState - reference to Bundle Object
     *                           that allows restore
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_pg);
        configureRecentsBacktoHomeButton();

        recipe = new Cookbook();
        recipeNames = new ArrayList<String>();

//        //example arraylist to get search feature working
        recipeNames = new ArrayList<String>();
        recipeNames.add("Chicken parm");
        recipeNames.add("Icecream");
        recipeNames.add("Chicken alfredo");
        recipeNames.add("Apple");
        recipeNames.add("Banana");
        recipeNames.add("Chocolate Chip Cookies");
        recipeNames.add("Peanut butter cookies");
        recipeNames.add("Mexican tacos");
        recipeNames.add("Pineapple");
        recipeNames.add("Dairy free");
        recipeNames.add("Fries");
        recipeNames.add("Butter");
        recipeNames.add("Steak");
        recipeNames.add("Milk");
        recipeNames.add("Stuffed peppers");
        recipeNames.add("Pizza bagels");

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
                (RecentPg.this).arrayAdapter.getFilter().filter(s);
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
                startActivity(new Intent(RecentPg.this, Pop.class));
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
