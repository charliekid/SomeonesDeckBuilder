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
 * ----		    -----------------   -----------------------------------------------------
 * String       name                name of the Pokemon
 * -------------------------------------------------------------------------------------
 *
 * NOTES/Updates
 ****************************************************************************************/
public class Pokemon {
    //Constants
    public static final String DEFAULT_NAME = "Missing No.";

    //Instance Variables
    private String name;

    /**
     * Default Constructor
     */
    public Pokemon() {
        setName(DEFAULT_NAME);
    }

    /**
     * Full Constructor
     * @param name - name of the Pokemon
     */
    public Pokemon (String name) {
        setName(name);
    }

    /**
     * Copy Constructor - Outputs an error to console if fails
     * @param original - the Pokemon object that will be copied from
     */
    public Pokemon (Pokemon original) {
        if (original != null) {
            setName(original.name);
        }
        else {
            Cs111.error("Trying to copy a non-existing Pokemon");
        }
    }
    @Override
    public String toString() {
        String result;
        result = getName();
        return result;
    }

    /**
     * Mutator for instance variable name
     * @param name - name of the Pokemon
     */
    private void setName(String name) {
        this.name = name; 
    }

    /**
     * Accessor for instance variable name
     * @return
     */
    public String getName() {
        return this.name;
    }
}

