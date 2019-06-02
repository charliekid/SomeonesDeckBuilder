/**************************************
* AUTHOR:           Charlie Nguyen
* COURSE:           CS 111
* SECTION:          TuTh 12pm-4
* HOMEWORK #:       FINAL PROJECT
* LAST MODIFIED:    8/5/15
**************************************/
 
/*********************************************************
* Someone's Deck Builder
*********************************************************
* PROGRAM DESCRIPTION:
* This deck will allow users to input cards that they own.
* After inputting all cards the program will create a
* deck based off the cards they have.
*********************************************************
* ALGORITHM:
* Have user choose 
* A: Enter in Inventory
* B: Create new deck
* C: Modify a deck
* X: Exit
*
* A: Enter in Inventory
*   Prompt: Type in the name of the card:
*   READ: userInput
*   Check to see which one matches with the XY_SET_FILE*
*   IF it doesn't match THEN
*       PROMPT: Error: Doesn't match any pokemon in the POKEMON_SET
*   IF it matches THEN
*       DISPLAY the cardInfo
*       PROMPT: Is this your card?
*           A: Yes
*           B: No
*       IF yes THEN
*           PROMPT: How many of these you would like to add?
*           READ: userInventory [sound be a counter]
*       END IF	
*       IF no THEN
*           GO back to the beginning
*       END IF
*   END IF 
*   Save this file as userInventory once done.
*
* B: Create new deck
*
* RULE WITH POKEMON - YOU CANNOT HAVE MORE THAN 4 OF THE SAME CARD 
*   (exclude energy)
* 
*   Check how many Trainers do they Have		
*   IF they have Trainers THEN
*           ADD all Trainers
*   END IF
*   CHECK How many different type of Pokemon there are.
*   SET numOfPokeType
*   CHECK which two of that list is the highest
*   SET mostType1 mostType2
*   CHECK How many different pokemon you have for Colorless
*   SET colorlessPoke
* 
*   WHILE there are EX in mostType1
*       keep adding them to creatingDeck until there are none
*   END WHILE
* 
*   WHILE there are Stage 2 Pokemon in mostType1 (with their evolutions)
*                           AND there is less than 12 Pokemons in creatingDeck
*       add them to creatingDeck
* 
*   WHILE there are Stage 1 Pokemon in mostType1 AND there are less than
*                                                    12 Pokemon in creatingDeck
*       add them to creatingDeck
*
*   IF there is less than 12 Pokemon in creatingDeck
*       WHILE there are EX in mostType2
*           keep adding them to creatingDeck until there are none
*       END WHILE
* 
*       WHILE there are Stage 2 Pokemon in mostType2 (with their evolutions)
*                           AND there is less than 12 Pokemons in creatingDeck
*           add them to creatingDeck
* 
*       WHILE there are Stage 1 Pokemon in mostType2 AND there are less than
*                                                   12 Pokemon in creatingDeck
*           add them to creatingDeck
*   END IF
*   ElSE 
*       sort colorlessPoke to quanity
*       add from higest to lowest.
*
*
*   ADD 13 Energys of mostType1 (and if we used mostType2)
*
*
* C: Modify Deck (requires more Sets to be added)
*
*	Not enough Supporter
*	Not enough Energy
*	Not enough Pokemon
*	I want more healing
 *********************************************************
 * ALL IMPORTED PACKAGES NEEDD AND PURPOSE:
 * None
 *********************************************************/

public class FinalProject {

    public static void main(String[] args) {
        Expansion xyBaseSet;
        xyBaseSet = new Expansion ("xyBaseSet");
        char menuSelection;
          
        xyBaseSet.importFile("database_forfinalproject.csv", 
                                                        "UPDATED: XY Base Set");
        
        MenuMethods.visualMenu("Main Menu", 
                 "Enter in Inventory/Cards,Create new deck,Modify a deck,Exit");
        menuSelection = Cs111.readChar("Make a selection: ", "abcdABCD");
        System.out.println();
        
        if (menuSelection == 'a' || menuSelection == 'A') {
            Expansion.printInventoryHeader();
            int exit;
            exit = 0;
            while (exit == 0) {
                xyBaseSet.cardInput(xyBaseSet);

                menuSelection = xyBaseSet.validateMultipleCards(xyBaseSet);
                
                String matchingOptions = xyBaseSet.matchingOptions(xyBaseSet);
                xyBaseSet.cardSelection(xyBaseSet.cardSelectionChoices
                                              (matchingOptions), menuSelection);
                menuSelection = Expansion.backToMainMenu();
 
                if (menuSelection == 'b' || menuSelection == 'B') {
                    
                    xyBaseSet.createUserDeck("UserDeck.csv");
                    exit++;
                }
            }  
        }
        if (menuSelection == 'b' || menuSelection == 'B') {
            Expansion.importFile("UserDeck.csv");
        }
    }
}    

