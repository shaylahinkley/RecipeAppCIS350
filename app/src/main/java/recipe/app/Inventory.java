//package recipe.app;
//
//
////import com.example.recipeapp.Cookbook;
////import com.example.recipeapp.Ingredients;
////import com.example.recipeapp.Recipe;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Scanner;
////
////import static main.java.com.example.recipeapp;
//
///**
// * A class that tracks various user related values and computes what recipes
// * are compatible with what is in the user's fridge
// *
// * @author Christian Van Eerden
// */
//public class Inventory {
//
//    /** Cookbook of recipes to compare to */
//    private Cookbook myCookbook;
//
//    /** Current ingredients in fridge*/
//    private ArrayList<Ingredients> fridge;
//
//    /** How many ingredients in fridge*/
//    private int numIngredients;
//
//    /** Difficulty the user is comfortable with */
//    private int difficulty;
//
//    /** ArrayList<Integer> that holds how similar a recipe is to fridge */
//    private ArrayList<Integer> similarities;
//
//    /**Default constructor for Inventory
//     * Creates new fridge and ensures that there are no items in it
//     */
//    public Inventory() {
//        myCookbook = new Cookbook();
//        fillCookbook(new File("C:\\Users\\cvane\\IdeaProjects\\app\\src\\app\\recipes"));
//        fridge = new ArrayList<>();
//        setNumIngredients(0);
//    }
//
//    /** Get method for the cookbook object
//     * @return Cookbook myCookbook
//     */
//    public Cookbook getMyCookbook() {
//        return myCookbook;
//    }
//
//    /** Set method for the cookbook object
//     * @param cookbook
//     */
//    public void setMyCookbook(Cookbook cookbook) {
//        this.myCookbook = cookbook;
//    }
//
//    /** Get method for number of ingredients
//     * @return int numIngredients
//     */
//    public int getNumIngredients() {
//        return numIngredients;
//    }
//
//    /** Set method for number of ingredients
//     * @param numIngredients - number of items in the fridge
//     */
//    public void setNumIngredients(int numIngredients) {
//        this.numIngredients = numIngredients;
//    }
//
//    /** Get method for the fridge
//     * @return ArrayList<Ingredients> fridge
//     */
//    public ArrayList<Ingredients> getFridge() {
//        return fridge;
//    }
//
//    /** Set method for difficulty
//     * @param difficulty - desired recipe difficulty
//     */
//    public void setDifficulty(int difficulty) {
//        this.difficulty = difficulty;
//    }
//
//    /** Get method for difficulty
//     * @return int difficulty
//     */
//    public int getDifficulty() {
//        return difficulty;
//    }
//
//    /** Method that given the quantity and name creates
//     * a valid Ingredient object and adds it to the fridge
//     * ArrayList
//     * @param quantity - quantity of the ingredient
//     * @param name - name of the ingredient
//     */
//    public void addToFridge(String quantity, String name) {
//        String newName = " " + name.toLowerCase();
//        Ingredients Ingredient = new Ingredients(quantity, newName);
//        fridge.add(Ingredient);
//        numIngredients++;
//    }
//
//    /** Method that given the quantity and name creates
//     * a valid Ingredient object and removes it from the fridge
//     * ArrayList
//     * @param quantity - quantity of the ingredient
//     * @param name - name of the ingredient
//     */
//    public void removeFromFridge(String quantity, String name) {
//        Ingredients Ingredient = new Ingredients(quantity, name);
//        fridge.remove(Ingredient);
//        numIngredients--;
//    }
//
//    /** Private helper method that returns all names of ingredients
//     * in the current inventory
//     * @param allIngredients - all the ingredient objects in the fridge
//     * @return ArrayList<String> all the names of every ingredient in the fridge
//     */
//    private ArrayList<String> allNames(ArrayList<Ingredients> allIngredients) {
//        ArrayList<String> ingredientNames = new ArrayList<>();
//        for (int i = 0; i < allIngredients.size(); i++) {
//            ingredientNames.add(allIngredients.get(i).getName());
//        }
//        return ingredientNames;
//    }
//
//    /** Private helper method that locates the index with the largest
//     * value in an arraylist
//     * @param howSimilar - an arraylist of similarities
//     * @return Integer - index of recipe with the greatest similarity to fridge
//     */
//    private int getLargest(ArrayList<Integer> howSimilar) {
//        int recipeSimilarity = 0;
//        for (int i = 0; i < howSimilar.size(); i++) {
//            if (howSimilar.get(i) > recipeSimilarity) {
//                recipeSimilarity = howSimilar.get(i);
//            }
//        }
//        return howSimilar.indexOf(recipeSimilarity);
//    }
//
//    private void fillCookbook(final File folder) {
//        for (final File fileEntry : folder.listFiles()) {
//            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
//            } else {
//                Recipe rec = new Recipe((fileEntry + ""));
//                System.out.println(rec.getMatchedIngredients());
//                myCookbook.addRecipes(rec);
//            }
//        }
//    }
//
//    /** Method that locates the most similar recipe given the fridge ArrayList
//     * @param fridge - what ingredients the user is in possession of
//     * @return Recipe with the greatest similarity to fridge
//     */
//    public Recipe findRecipe(ArrayList<Ingredients> fridge) {
//        int similarity;
//        similarities = new ArrayList<>();
//        ArrayList<Recipe> temp;
//        Recipe tempRecipe;
//        ArrayList<String> tempIngredients;
//        ArrayList<String> fridgeIngredients = allNames(fridge);
//        temp = myCookbook.getRecipes();
//        for (int i = 0; i < temp.size(); i++) {
//            similarity = 0;
//            tempRecipe = temp.get(i);
//            tempIngredients = tempRecipe.getIngredients();
//            for (int j = 0; j < tempIngredients.size(); j++) {
//                if (tempIngredients.contains(fridgeIngredients.get(j))) {
//                    similarity++;
//                }
//            }
//            similarities.add(similarity);
//        }
//        return temp.get(getLargest(similarities));
//    }
//
//    public void saveFridge(String name)
//    {
//        try
//        {
//            FileOutputStream sFridge = new FileOutputStream(name + ".txt");
//            PrintWriter outFridge = new PrintWriter(sFridge);
//            for(Ingredients f: fridge)
//            {
//                outFridge.println(f.getQuantity());
//                outFridge.println(f.getName());
//            }
//            outFridge.flush();
//        }
//        catch(Exception ex)
//        {
//            System.out.printf("Error: %s\n", ex);
//        }
//    }
//
//    public void loadFridge(String file)
//    {
//        try
//        {
//            FileInputStream fileStream = new FileInputStream(file + ".txt");
//            Scanner scnr = new Scanner(fileStream);
//
//            while(scnr.hasNext())
//            {
//                String tempQ = scnr.nextLine();
//                String tempN = scnr.nextLine();
//
//                fridge.add(new Ingredients(tempQ, tempN));
//            }
//        }
//        catch(Exception ex)
//        {
//            System.out.printf("Error: %s\n", ex);
//        }
//    }
//}
