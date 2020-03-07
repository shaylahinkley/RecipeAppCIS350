package recipe.app;

/** A class that creates an ingredients object used in the Recipe
 * and Inventory class
 *
 * @author Christian Van Eerden
 */
public class Ingredients {

    /**
     * How much of a certain ingredient
     */
    private String quantity;

    /**
     * Name of a certain ingredient
     */
    private String name;

    /**
     * Default constructor for ingredients,
     * creates an object with no name or quantity
     */
    public Ingredients() {
        setName(null);
        setQuantity(null);
    }

    /**
     * Constructor for ingredients
     * Creates ingredients object given quantity and name
     *
     * @param quantity - How much of a certain ingredient
     * @param name     - Name of a certain ingredient
     */
    public Ingredients(String quantity, String name) {
        setName(name);
        setQuantity(quantity);
    }

    /**
     * Get method for quantity
     *
     * @return String quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Set method for quantity
     *
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Get method for name
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overridden toString method for ingredients
     **/
    public String toString(Ingredients Ingredient) {
        String newString;
        newString = Ingredient.getQuantity() + " | " + Ingredient.getName();
        return newString;
    }
}