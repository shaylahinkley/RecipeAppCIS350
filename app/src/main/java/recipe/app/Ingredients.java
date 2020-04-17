package recipe.app;

/** A class that creates an ingredients object used in the Recipe
 * and Inventory class.
 *
 * @author Christian Van Eerden
 */
public class Ingredients {

    /**
     * How much of a certain ingredient.
     */
    private String quantity;

    /**
     * Name of a certain ingredient.
     */
    private String name;

    /**
     * Default constructor for ingredients,
     * creates an object with no name or quantity.
     */
    public Ingredients() {
        setName(null);
        setQuantity(null);
    }

    /**
     * Constructor for ingredients
     * Creates ingredients object given quantity and name.
     *
     * @param newQuantity - How much of a certain ingredient
     * @param newName     - Name of a certain ingredient
     */
    public Ingredients(final String newQuantity, final String newName) {
        name = newName;
        quantity = newQuantity;
    }

    /**
     * Get method for quantity.
     *
     * @return String quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Set method for quantity.
     *
     * @param newQuantity quantity to be assigned
     */
    public void setQuantity(final String newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Get method for name.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for name.
     *
     * @param newName String name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Overridden toString method for ingredients.
     * @param ingredient ingredient to be made into a string
     * @return String string version of the ingredient
     **/
    public String toString(final Ingredients ingredient) {
        String newString;
        newString = ingredient.getQuantity() + " | " + ingredient.getName();
        return newString;
    }
}