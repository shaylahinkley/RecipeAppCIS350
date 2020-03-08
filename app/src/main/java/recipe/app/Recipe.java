package recipe.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *A class that contains information about a recipe read in from a file.
 *
 * @author Kameron Nelski
 */

public class Recipe {


    /**
     * File location
     */
    private String fileLoc;

    /**
     * number of ingredients in the recipe
     */
    private int ingredientCount;

    /**
     * number of instruction steps in the recipe
     */
    private int stepCount;

    /**
     * name of the recipe
     */
    private String name;

    /**
     * recipe instructions
     */
    private ArrayList instructions;

    /**
     * quantities of needed ingredients
     */
    private ArrayList quantities;

    /**
     * recipes needed ingredients
     */
    private ArrayList ingredients;

    public String getFileLoc() {
        return fileLoc;
    }

    public void setFileLoc(String fileLoc) {
        this.fileLoc = fileLoc;
    }


    /**
     * Constructor for a recipeFile
     *
     * @param recipeFile file path  to be opened passed in  as a string
     */
    public Recipe(String recipeFile) {

        instructions = new ArrayList<String>();
        quantities = new ArrayList<String>();
        ingredients = new ArrayList<String>();
        fileLoc = recipeFile;

        try {

            FileInputStream recipe = new FileInputStream(recipeFile); //Open recipeFile
            Scanner scr = new Scanner(recipe);
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
        } catch (FileNotFoundException ex) {
            System.out.println("exception");
        }
    }

    /**
     * Overridden toString method for a recipe object
     *
     * @return a String representation of a recipe
     **/
    public String toString() {
        String str = name + "\n";
        for (int i = 0; i < ingredientCount; ++i) {
            str = str + this.quantities.get(i) + this.ingredients.get(i) + "\n";
        }
        for (int i = 0; i < stepCount; ++i) {
            str = str + this.instructions.get(i) + "\n";
        }
        return str;
    }

    /**
     * get method for ingredientCount
     *
     * @return ingredientCount
     */
    public int getIngredientCount() {
        return ingredientCount;
    }

    /**
     * set method for ingredientCount
     *
     * @param ingredientCount new ingredientCount
     */
    public void setIngredientCount(int ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    /**
     * get method for stepCount
     *
     * @return stepCount
     */
    public int getStepCount() {
        return stepCount;
    }

    /**
     * set method for stepCount
     *
     * @param stepCount new number of steps
     */
    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    /**
     * get method for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for name
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for instructions
     *
     * @return instructions
     */
    public ArrayList getInstructions() {
        return instructions;
    }

    /**
     * set method for instructions
     *
     * @param instructions arrayList to be set as the new set of instructions
     */
    public void setInstructions(ArrayList instructions) {
        if (instructions.size() == this.stepCount) {
            this.instructions = instructions;
        }
    }

    /**
     * get method for quantities
     *
     * @return quantifies
     */
    public ArrayList getQuantities() {
        return quantities;
    }

    /**
     * set method for quantities
     *
     * @param quantities arrayList of new quantities
     */
    public void setQuantities(ArrayList quantities) {
        if (ingredientCount == quantities.size()) {
            this.quantities = quantities;
        }
    }

    /**
     * get method for ingredients
     *
     * @return ingredients
     */
    public ArrayList getIngredients() {
        return ingredients;
    }

    /**
     * set method for ingredients
     *
     * @param ingredients arrayList of new ingredients
     */
    public void setIngredients(ArrayList ingredients) {
        if (ingredients.size() == ingredientCount) {
            this.ingredients = ingredients;
        }
    }
}

