package recipe.app;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * A class that builds the Favorites screen of the Android App.
 * It allows the user to view their favorite recipes in the app.
 * This will be fully functioning in future releases
 * See: activity_favorites_pg.xml
 *
 * @author Shayla Hinkley
 * @version 1.0
 */
public class FavoritesPg extends AppCompatActivity {

    /**Instance variable arraylist that
     * holds the names of the favorite recipes */
    private ArrayList<String> favRecipes;

    /**Instance variable for the array
     * adapter that is being used in the list view */
    private ArrayAdapter arrayAdapter;

    /**Instance variable that holds the name of
     * item that is clicked*/
    private String clickedName;

    /**
     * Method that builds and creates the Favorites Page.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_pg);
        configureFavBacktoHomeButton();

//        favRecipes = (ArrayList<String>) getIntent().getSerializableExtra("favoriteslist");
        favRecipes = new ArrayList<String>();
        favRecipes = SearchPage.favoriteRecipes;

        arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, favRecipes);

        ListView listView = (ListView) findViewById(R.id.favListView);
        listView.setAdapter(arrayAdapter);


        //filtering the arraylist when searched
        final EditText searchFilter = (EditText) findViewById(R.id.favSearchEditText);
        searchFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (FavoritesPg.this).arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

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
                Intent intent = new Intent(FavoritesPg.this, Pop.class);
                intent.putExtra("detail", clickedName.replace(" ", "")+ "_recipe");

                //starts the activity
                startActivity(intent);
            }
        });

        //removing item from favorites on the screen when user holds a long click
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                favRecipes.remove(position);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Favorite Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    /**
     * Method that configures a button that allows
     * the user to navigate back to the home page when the button is clicked.
     */
    public void configureFavBacktoHomeButton() {
        Button favBackHomeBtn = (Button) findViewById(R.id.favBackHomeBtn);
        favBackHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                finish();
            }
        });
    }
}
