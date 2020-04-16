package recipe.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *A class that contains information about a recipe read in from a file.
 *
 * @author Kameron Nelski
 */
public class Recipe {

    /**
     * File location.
     */
    private String fileLoc;

    /**
     * number of ingredients in the recipe.
     */
    private int ingredientCount;

    /**
     * number of instruction steps in the recipe.
     */
    private int stepCount;

    /**
     * name of the recipe.
     */
    private String name;

    /**
     * recipe instructions.
     */
    private ArrayList instructions;

    /**
     * quantities of needed ingredients.
     */
    private ArrayList quantities;

    /**
     * recipes needed ingredients.
     */
    private ArrayList ingredients;

    /**
     * Method that gets the location of the file
     * @return fileLoc - the location of the file
     */
    public String getFileLoc() {
        return fileLoc;
    }

    /**
     * Method that sets the file location
     * @param newFileLoc
     */
    public void setFileLoc(final String newFileLoc) {
        this.fileLoc = newFileLoc;
    }

    /**
     * Constructor for a recipeFile.
     *
     * @param recipeFile file path  to be opened passed in  as a string
     */
    public Recipe(final InputStream recipeFile) {

        instructions = new ArrayList<String>();
        quantities = new ArrayList<String>();
        ingredients = new ArrayList<String>();

        try {
            Scanner scr = new Scanner(recipeFile);
            scr.useDelimiter("[,\r\n|]+");

            //reads to end of file setting the arraylists
            while (scr.hasNext()) {
                name = scr.nextLine();
                ingredientCount = scr.nextInt();

                for (int i = 0; i < ingredientCount; ++i) {
                    quantities.add(scr.next());
                    ingredients.add(scr.next());
                }

                stepCount = scr.nextInt();
                for (int i = 0; i <= stepCount; i++) {
                    instructions.add(scr.nextLine());
                }

                instructions.remove(0); // removes first empty instruction
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Overridden toString method for a recipe object.
     *
     * @return a String representation of a recipe
     **/
    @Override
    public String toString() {
        String str = name + "\n\n";
        for (int i = 0; i < ingredientCount; ++i) {
            str = str + this.quantities.get(i) + this.ingredients.get(i) + "\n";
        }
        str +="\n";
        for (int i = 0; i < stepCount; ++i) {
            str = str + this.instructions.get(i) + "\n";
        }
        return str;
    }

    /**
     * get method for ingredientCount.
     *
     * @return ingredientCount
     */
    public int getIngredientCount() {
        return ingredientCount;
    }

    /**
     * set method for ingredientCount.
     *
     * @param myIngredientCount new ingredientCount
     */
    public void setIngredientCount(final int myIngredientCount) {
        this.ingredientCount = myIngredientCount;
    }

    /**
     * get method for stepCount.
     *
     * @return stepCount
     */
    public int getStepCount() {
        return stepCount;
    }

    /**
     * set method for stepCount.
     *
     * @param myStepCount new number of steps
     */
    public void setStepCount(final int myStepCount) {
        this.stepCount = myStepCount;
    }

    /**
     * get method for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for name.
     *
     * @param newName new name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * get method for instructions.
     *
     * @return instructions
     */
    public ArrayList getInstructions() {
        return instructions;
    }

    /**
     * set method for instructions.
     *
     * @param newInstructions arrayList to be set as the new set of instructions
     */
    public void setInstructions(final ArrayList newInstructions) {
        if (newInstructions.size() == this.stepCount) {
            this.instructions = newInstructions;
        }
    }

    /**
     * get method for quantities.
     *
     * @return quantifies
     */
    public ArrayList getQuantities() {
        return quantities;
    }

    /**
     * set method for quantities.
     *
     * @param newQuantities arrayList of new quantities
     */
    public void setQuantities(final ArrayList newQuantities) {
        if (ingredientCount == quantities.size()) {
            this.quantities = newQuantities;
        }
    }

    /**
     * get method for ingredients.
     *
     * @return ingredients
     */
    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    /**
     * set method for ingredients.
     *
     * @param newIngredients arrayList of new ingredients
     */
    public void setIngredients(final ArrayList newIngredients) {
        if (ingredients.size() == ingredientCount) {
            this.ingredients = newIngredients;
        }
    }
}

