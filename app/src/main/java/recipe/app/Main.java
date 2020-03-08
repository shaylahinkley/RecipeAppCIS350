package recipe.app;

import java.io.File;


/**
 * A class helped in the beginning of the project to list files from the folder and loaded in the recipes.
 *
 * @author Kameron Nelski
 */
public class Main {


    public static void main(String[] args){

        File folder = new File("C:\\Users\\Sparky\\Documents\\CIS 350 proj");
        listFilesForFolder(folder);

    }

    /**
     * Method that takes files and changes them into recipe objects
     * @param folder - a File
     */
    public static void listFilesForFolder(final File folder) {
        Recipe rec;
        Cookbook book = new Cookbook();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
               rec = new Recipe((fileEntry + ""));
               //book.addRecipes(rec);
               System.out.println(rec);
            }
        }
       // book.loadBook("newbook");
        //book.saveBook();
       // book.loadRecipes("test book.txt");
        System.out.println(book);
    }
}
