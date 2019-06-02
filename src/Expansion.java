/****************************************************************************************
 * AUTHOR:           Charlie Nguyen
 * COURSE:           CS 111
 * SECTION:          TuTh 12pm-4
 * HOMEWORK #:       FINAL PROJECT
 * LAST MODIFIED:    8/5/15
 *
 * Instance Variables
 * -------------------------------------------------------------------------------------
 * Type		    Name 		        Description
 * ----		    -----------------   ----------------------------------------------------
 * String       expansionName       The name of the expansion set
 * String       searchWord          The word that will be used to search with
 * int          numberUsed
 * int          indexMatch
 * Card[]       expansionList
 * Card[]       usersDeck
 * int[]        matchedPokemonIndex
 * -------------------------------------------------------------------------------------
 *
 * NOTES/Updates
 ****************************************************************************************/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Expansion extends Pokemon 
{
    // Constants
    public final String DEFAULT_EXPANSION_NAME = "Mystery Set";
    public final int DEFAULT_MAX_ELEMENTS = 200;

    // Instance Variable
    private String expansionName, searchWord;
    private int numberUsed, indexMatch;
    private Card [] expansionList,usersDeck;
    private int [] matchedPokemonIndex;

    /**
     * Default Constructor
     */
    public Expansion() {
        super();
        setExpansionName(DEFAULT_EXPANSION_NAME);
        this.expansionList = new Card [DEFAULT_MAX_ELEMENTS];
        setNumberUsed(0);
    }

    /**
     * Full Constructor
     * @param expansionName
     */
    public Expansion (String expansionName) {
        super();
        setExpansionName(expansionName);
        expansionList = new Card [DEFAULT_MAX_ELEMENTS];
        setNumberUsed(0);
    }

    /**
     * Copy Constructor
     * @param original
     */
    public Expansion (Expansion original) {
        super();
        setExpansionName(original.expansionName);
        expansionList = new Card [original.DEFAULT_MAX_ELEMENTS];
        setNumberUsed(original.getNumberUsed());
    }
    public String toString() {
        String result;
        result = "";
        for (int i = 0; i< this.expansionList.length; i++) {
            result += (this.expansionList[i]) + "\n";
        }
        return result;
    } 
    /**
     * Checks if a String value is equal to the specified index
     * @param searchInput - the String that will be used to search with
     * @param index - the index we are searching within
     * @return
     */
    private boolean equals(String searchInput, int index) {
        if (searchInput.equalsIgnoreCase(this.expansionList[index].getName())) {
            return true;
        } else {
            return false;
        }
            
    }

    /**
     * Checks if a String value exists within specified index
     * @param searchInput - the String that will be used to search with
     * @param index - the index we are seaching within
     * @return
     */
    private boolean indexOf(String searchInput, int index) {
        if (this.expansionList[index].getName().indexOf(searchInput)!=-1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks to see if a seach input exists in an array
     * @param original
     * @param searchWord
     * @return
     */
    private boolean equals(Expansion original, String searchWord) {
        boolean result;
        result = false;
     
        int i = 0;
        while (!result && i < original.getNumberUsed()) {
            result = original.indexOf(searchWord, i);
            i++;
        }
        if (result) {
           setIndexMatch(i);
           result = true;
        }
        return result;
    }
    /**
     * Finds this index of an array that contains the String
     * @param original
     * @param searchWord
     * @return
     */
    private int searchWordEqualsIndex(Expansion original, String searchWord) {
        int result;
        result = -1;
   
        if( original.equals(searchWord, 0)) {
            result = 0;
        }
        else {
            boolean noMatches;
            noMatches = false;
            int i = 0;
            while (!noMatches && i < original.getNumberUsed()) {
                noMatches = original.equals(searchWord, i);
                i++;
            }
            if (noMatches) {
                result = i;
            } else {
                System.out.println("Invalid Pokemon: Please check typing");
            }
        }
        return result;
    }

    /**
     * indexOfMultipe
     * @return
     */
    private String indexOfMultipe() {
        String result;
        result = "";
        for (int i = 0; i < this.getNumberUsed(); i++) {
            if (this.expansionList[i].getName().indexOf(getSearchWord())!=-1) {
                result += i +",";
            }
        }
        return result;
    }

    /**
     * Mutator for instance variable expansionName
     * @param expansionName
     */
    private void setExpansionName (String expansionName) {
        this.expansionName = expansionName;
    }

    /**
     * Accessor for instance variable expansionName
     * @return
     */
    private String getExpansionName () {
        return this.expansionName;
    }

    /**
     * Mutator for instance variable searchWord
     * @param userInput
     */
    private void setSearchWord(String userInput) {
        this.searchWord = userInput;
    }

    /**
     * Accessor for instance variable searchWord
     * @return
     */
    private String getSearchWord () {
        return this.searchWord;
    }

    /**
     * Mutator for instance variable numberUsed
     * @param numberUsed
     */
    private void setNumberUsed (int numberUsed) {
        this.numberUsed = numberUsed;
    }

    /**
     * Accessor for instance variable numberUsed
     * @return
     */
    private int getNumberUsed () {
        return this.numberUsed;
    }

    /**
     * Mutator for instance variable indexMatch
     * @param indexMatch
     */
    private void setIndexMatch (int indexMatch) {
        this.indexMatch = indexMatch;
    }

    /**
     * Accessor for for instance variable indexMatch
     * @return
     */
    private int getIndexMatch () {
        return this.indexMatch;
    }

    /**
     * getElement
     * @param index
     * @return
     */
    private Card getElement (int index)
    {
        if (index < 0 || index >= getNumberUsed())
        {
            System.out.println("Error: Illegal or unused index!");
            System.exit(0);
        }
        return this.expansionList[index - 1];
    }

    /**
     * Imports file and create into an array.
     * @param fileName
     * @param update
     */
    public void importFile (String fileName, String update) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
       
        System.out.println(update);
        
        while (inputStream.hasNextLine()) {

            StringTokenizer cardInfo;
         
            String temp = inputStream.nextLine();
            
            cardInfo = new StringTokenizer (temp, ",");

            this.expansionList[getNumberUsed()] = new Card(cardInfo.nextToken(), 
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken(),
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken(),
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken(),
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken(),
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken(),
                cardInfo.nextToken(),cardInfo.nextToken(),cardInfo.nextToken());
            numberUsed++;
       }
    }
    /**
     * Imports file
     * @param fileName - the path of file
     */
    public static void importFile (String fileName) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    /**
     * Creates users deck
     * @param fileName
     */
    public void createUserDeck(String fileName) {
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(new FileOutputStream(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error writing file!");
        }
        usersDeck();

        writeDeckList(outputStream);
        
        outputStream.close();

    }
    /**
     * Prints a line of card if the user input the card
     * @param outputStream
     */
    private void writeDeckList(PrintWriter outputStream)
    {
        System.out.println(this.usersDeck[0]);
        for ( int i = 0; i < this.usersDeck.length; i++)
        {
            
            /*outputStream.print*/System.out.println(this.usersDeck[i].getName()+","); // test the rest of the check which one is null
            /*outputStream.print*/System.out.println(this.usersDeck[i].getHp()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getCollectionNum()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getCardType()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getEvolvesFrom()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getPokeType()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getWeakness()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getResistance()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getRetreat()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack1()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack1Detail()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack1Cost()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack1Damage()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack2()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack2Detail()+",");
           /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack2Cost()+",");
           /*outputStream.print*/System.out.println(this.usersDeck[i].getAttack2Damage()+",");
            /*outputStream.print*/System.out.println(this.usersDeck[i].getAbilities()+",");
           /*outputStream.print*/System.out.println(this.usersDeck[i].getCardText());
            outputStream.println();

        }
            
    }
    
    /**
     * Checks if the user has any cards
     * @param i
     * @return
     */
    private boolean hasCard (int i) {
        boolean result;
        result = (this.expansionList[i]).getQuantity() != 0;
        return result;
    }
    /**
     * Checks if the user has any cards
     * @param original
     */
    public void cardInput (Expansion original) {
        Scanner keyboard;
        StringTokenizer searchInput;
        keyboard = new Scanner(System.in);
        boolean hasMatch;
        String searchWord;

        do {
            System.out.println("Enter in the name of the Pokemon or Trainer name: ");

            String temp = keyboard.nextLine();
            searchInput = new StringTokenizer(temp);
            searchWord = searchInput.nextToken();
            temp = searchWord.substring(0,1);
            temp = temp.toUpperCase();
            temp+= searchWord.substring(1);
            searchWord = temp;
            setSearchWord(searchWord);
            hasMatch = original.equals(original, searchWord);

            if (!hasMatch) {
                System.out.println("Invalid Pokemon: Please check typing");
            }

        } while (!hasMatch);
    }
    /**
     * Validates with user if this card is correct
     * @param original
     * @return
     */
    public static char validateCard (Expansion original) {

        char menuSelection; 
        
        System.out.println(original.getElement(original.getIndexMatch()));
        MenuMethods.visualMenu("Is this your card? ", "Yes,No");
        menuSelection = Cs111.readChar("Make Selection: ", "abynABYN");
        
        return menuSelection;
    }
    /**
     * Validates with user if the card is correct
     * @param original
     * @return
     */
    public char validateMultipleCards (Expansion original) {

        char menuSelection;
        
        setMatchedPokemonIndex();
        printMultipleCardsMatches(original);
        
        MenuMethods.visualMenu("Which card did you want to add?", namesOfMultipleCardsMatches(original));
        menuSelection = Cs111.readChar("Make Selection: ", matchingOptions(original));
        
        return menuSelection;
    }
    /**
     * setMatchedPokemonIndex
     * @return
     */
    private int [] setMatchedPokemonIndex() { //contains indexes of matched pokemon
        StringTokenizer indexes;
        String listofIndex;
        
        listofIndex = indexOfMultipe();
        indexes = new StringTokenizer (listofIndex, ",");
        this.matchedPokemonIndex = new int [MenuMethods.numOfMenuItems(listofIndex)]; 
        for (int i = 0; i < this.matchedPokemonIndex.length; i++) {
            String temp = indexes.nextToken();
            this.matchedPokemonIndex[i] = Integer.parseInt(temp) + 1;
        }
        return this.matchedPokemonIndex;
    }

    /**
     * Prints out which cards matches
     * @param original
     */
    private void printMultipleCardsMatches (Expansion original) {
        for (int i = 0; i< this.matchedPokemonIndex.length; i++) {
            int start;
            start = 65+i;
            System.out.println((char) start + ":");
            System.out.println(original.getElement(this.matchedPokemonIndex[i]));
        }
    }
    /**
     * Description:         Creates a string of matched cards.
     * @param original
     * @return
     */
    private String namesOfMultipleCardsMatches (Expansion original) {
        String list;
        list= "";
        for (int i = 0; i< this.matchedPokemonIndex.length; i++) {
            list += original.getElement(this.matchedPokemonIndex[i]).getName()+",";
        }
        return list;
    }

    /**
     * Matches hotkeys for menu items
     * @param original
     * @return
     */
    public String matchingOptions (Expansion original) { //matches hotkeys for menu items
        String menuItems;
        menuItems = "";
        
        for (int i = 0; i< this.matchedPokemonIndex.length; i++) {
            int start;
            start = 65+i;
            menuItems += (char) start + "";
        }
        String temp;
        temp = menuItems;
        temp = temp.toLowerCase();
        menuItems += temp;
        
        return menuItems;
    }

    /**
     * cardSelectionChoices
      * @param matchingOptions
     * @return
     */
    public char [] cardSelectionChoices(String matchingOptions) {
        char [] selection;
        
        int length = matchingOptions.length()/2;
        selection = new char [length];
        
        for (int i = 0; i<length ; i++) {
            selection[i] = matchingOptions.charAt(i);
        }
        return selection;
    }

    /**
     * cardSelection
     * @param selection
     * @param userSelection
     */
    public void cardSelection(char [] selection, char userSelection) {
        for (int i = 0; i<selection.length; i++) {
          int start = 65+i; 
          if (userSelection == (char)start || userSelection == (char)start+32 ) {
              System.out.println(expansionList[this.matchedPokemonIndex[i]-1]);
              int amountAdded = Cs111.readInt("How many would you like to add? ", 1, 100);
              expansionList[this.matchedPokemonIndex[i]-1].addCardQuantity(amountAdded);
              System.out.println("Added! You now have " + expansionList[this.matchedPokemonIndex[i]-1].getQuantity()
                + " of " + expansionList[this.matchedPokemonIndex[i]-1].getName());
          }
        }
    }
    /**
     * Requests users to input quantity
     * @param original
     */
    public static void userAddQuantity (Expansion original) {
        int amountAdded = Cs111.readInt("How many would you like to add? ", 1, 100);
        original.getElement(original.getIndexMatch()).addCardQuantity(amountAdded);
        System.out.println("Added! You now have " + (original.getElement(original.getIndexMatch()).getQuantity())
        + " of " + (original.getElement(original.getIndexMatch()).getName()));
    }
    /**
     * Requests users if they want to go back to main menu
     * @return
     */
    public static char backToMainMenu () {
        char menuSelection;
        MenuMethods.visualMenu("Back to main menu?", "Add More Cards,Go Back To Main Menu");
        menuSelection = Cs111.readChar("Make Selection: ", "abAB");
        return menuSelection;
    }

    /**
     * Prints inventory header
     */
    public static void printInventoryHeader() {
        System.out.println("  ______                      _        _ ");
        System.out.println(" / ____|                     | |      | |");
        System.out.println("|  |        ___ __ __ __  __ | | ____ | |");
        System.out.println("|  |      /  _’  || ‘__|/  _’  |/  __|| | ");
        System.out.println("|  |___  |  (_| ||| |  |  (_|  |\\___ \\|_| ");
        System.out.println(" \\_____|  \\____,_||_|   \\___,_ ||____/(_)  ");
        
    }
    /**
     * Checks how many different cards does the user have.
     * @return
     */
    private int quantityCheck() {
        int count;
        count = 0;
        for (int i = 0; i < this.getNumberUsed(); i++) {
            if(hasCard(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Creates and set a users deck
     */
    public void usersDeck() { //checked if arrays are null and thsi is fine
        this.usersDeck = new Card [quantityCheck()];
        
        for (int i = 0; i <getNumberUsed(); i++) {
            if (hasCard(i)) {
                int counter;
                counter = 0;
                this.usersDeck[counter] = new Card(this.expansionList[i]);
                counter++;
                
            }
        }
    }
}
