package recipe.app;


import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *A class that contains a collections of recipes. And allows you to
 * retrieve all or a specific recipe.
 *
 * @author Kameron Nelski
 */
public class Cookbook {

    /**
     * The arrayList of recipes held by the cookbook.
     */
    private ArrayList<Recipe> recipes;

    /**
     * The name of the cookbook.
     */
    private String name;

    /**
     * How many recipes are in the cookbook.
     */
    private int numRecipes;

    /**
     * Default constructor for cookbook
     * sets recipes to an empty arrayList,
     * name to null, and number of recipes to 0.
     */
    public Cookbook() {
        recipes = new ArrayList<>();
        name = "NULL";
        numRecipes = 0;
    }

    /**
     * Constructor for cookbook.
     * Sets recipes to an empty arrayList,
     * name to param name, and number of recipes to 0.
     *
     * @param newName name of created cookbook
     */
    public Cookbook(final String newName) {
        recipes = new ArrayList<>();
        this.name = newName;
        numRecipes = 0;
    }

    /**
     * Copy constuctor for a cookbook.
     *
     * @param originalBook cookbook being copied.
     */
    public Cookbook(final Cookbook originalBook) {
        this.name = originalBook.getName();
        this.recipes = originalBook.getRecipes();
        this.numRecipes = originalBook.getNumRecipes();
    }

    /**
     * Copy constructor for a cookbook that allows for naming new cookbook.
     *
     * @param originalBook cookbook being copied
     * @param newName         name of the new cookbook
     */
    public Cookbook(final Cookbook originalBook, final String newName) {
        this.name = newName;
        this.recipes = originalBook.getRecipes();
        this.numRecipes = originalBook.getNumRecipes();
    }

    /**
     * Get method for a recipe in a known location.
     *
     * @param index location of recipe
     * @return recipe at location i
     */
    public Recipe getRecipe(final int index) {
        return recipes.get(index);
    }

    /**
     * Get method for a recipe with a given name.
     * Converts both to uppercase so it is not case sensitive.
     *
     * @param newName of desired recipe
     * @return recipe with name name or null if no recipe is found
     */
    public Recipe getRecipe(final String newName) {
        for (int i = 0; i < this.recipes.size(); ++i) {
            if (this.recipes.get(i).getName().toUpperCase()
                    .equals(newName.toUpperCase())) {
                return this.recipes.get(i);
            }
        }
        return null;
    }

    /**
     * Get method for recipes.
     *
     * @return arrayList Recipes
     */
    public ArrayList getRecipes() {
        return recipes;
    }

    /**
     * Method to add new recipes to a cookbook, also increments numRecipes.
     *
     * @param recipe recipe to be added
     */
    public void addRecipes(final Recipe recipe) {
        this.recipes.add(recipe);
        this.numRecipes++;
    }

    /**
     * Method to remove recipes from a cookbook, also decrements numRecipes.
     *
     * @param recipe recipe to be removed
     */
    public void removeRecipe(final Recipe recipe) {
        this.recipes.remove(recipe);
        this.numRecipes--;
    }

    /**
     * Get method for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for name.
     *
     * @param newName cookbook's new name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * get Method for numRecipe.
     *
     * @return numRecipes
     */
    public int getNumRecipes() {
        return numRecipes;
    }

    /**
     * Overridden toString method for a cookbook object.
     *
     * @return a String representation of a cookbook
     **/
    @Override
    public String toString() {
        String str = this.name + ": ";
        for (Recipe rec : this.recipes) {
            str += rec.getName() + ", ";
        }
        str = str.substring(0, str.length() - 2);
        return str;
    }

    /**
     * Saves a cookbook to a file with the name of the cookbook,
     * it holds file locations of recipes.
     */
    public void saveBook() {
        try {
            FileOutputStream savedBook =
                    new FileOutputStream(this.name + ".txt");
            PrintWriter outBook = new PrintWriter(savedBook);
            outBook.println(this.name);
            for (Recipe r : recipes) {
                System.out.println(r.getFileLoc());
                outBook.println(r.getFileLoc());
            }
            outBook.flush();
        } catch (Exception e) {
            System.out.println("Error File path not found");
        }
    }
}
