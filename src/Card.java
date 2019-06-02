 /****************************************************************************************
  * AUTHOR:           Charlie Nguyen
  * COURSE:           CS 111
  * SECTION:          TuTh 12pm-4
  * HOMEWORK #:       FINAL PROJECT
  * LAST MODIFIED:    8/5/15
  *
  * Instance Variables
  * -------------------------------------------------------------------------------------
  * Type		Name		        Description
  * ----		-----------------   -----------------------------------------------------
  * int         hp                  represents the hit points value of the card
  * int         collectionNum       the collection number the card belongs to
  * int         cardQuantity        quantity of a specific card
  * String      name                name of the card
  * String      cardType            the card can either be a pokemon, trainer or supporter
  * String      evolvesFrom         the name of Pokemon the current card evolves from
  * String      pokeType            the element type of the Pokemon
  * String      weakness            the element type the card is weak to
  * String      resistance          the element type the card is resistance to
  * String      retreat             the cost amount to retreat
  * String      attack1             Name of the first attack
  * String      attack1Detail       The details of the first attack
  * String      attack1Cost         The cost for the first attack
  * String      attack1Damage       The damage the first attack deals
  * String      attack2             Name of the second attack
  * String      attack2Detail       The details of the second attack
  * String      attack2Cost         The cost for the second
  * String      attack2Damage       The damage the second attack deals
  * String      abilities           Details of the Pokemon's abilities
  * String      cardText            Extra text from the card
  * -------------------------------------------------------------------------------------
  * NOTES/Updates
  * - Create card types of Trainer, supporter, Pokemon, Items
  * - Use Card object
  ****************************************************************************************/
  public class Card extends Expansion {

    public final int DEFAULT_HP = 10000;
    public final int DEFAULT_COLLECT_NUM = 10000;
    public final int DEFAULT_CARD_QUANTITY = 0;
    public final String DEFAULT_CARD_TYPE = "Basic Pokemon";
    public final String DEFAULT_EVOLVES_FROM = "Forgotten Pokemon";
    public final String DEFAULT_POKE_TYPE = "Unicorn/Ghost";
    public final String DEFAULT_WEAKNESS = " ";
    public final String DEFAULT_RESISTANCE = " ";
    public final String DEFAULT_RETREAT = " ";
    public final String DEFAULT_ATTACK1 = "First Attack";
    public final String DEFAULT_ATTACK1_DETAIL = "The defending Pokemon is knocked out";
    public final String DEFAULT_ATTACK1_COST = "Colorless";
    public final String DEFAULT_ATTACK1_DAMAGE = " ";
    public final String DEFAULT_ATTACK2 = " ";
    public final String DEFAULT_ATTACK2_DETAIL = " ";
    public final String DEFAULT_ATTACK2_COST = " ";
    public final String DEFAULT_ATTACK2_DAMAGE = " ";
    public final String DEFAULT_ABILITIES = "This Pokemon can't be defeated.";
    public final String DEFAULT_CARD_TEXT = " ";
    private final int SPACES_IN_CARD_OUTPUT = 39;


    // Instance Variables
    private int hp, collectionNum, cardQuantity;
    private String name, cardType, evolvesFrom, pokeType, weakness, resistance,
                retreat, attack1, attack1Detail, attack1Cost, attack1Damage,
                attack2, attack2Detail, attack2Cost, attack2Damage, abilities,
                cardText;

    /**
     * Default Constructor
     */
    public Card() {
        super();
        setHp(DEFAULT_HP);
        setCollectionNum(DEFAULT_COLLECT_NUM);
        setCardType(DEFAULT_CARD_TYPE);
        setEvolvesFrom(DEFAULT_EVOLVES_FROM);
        setPokeType(DEFAULT_POKE_TYPE);
        setWeakness(DEFAULT_WEAKNESS);
        setResistance(DEFAULT_RESISTANCE);
        setRetreat(DEFAULT_RETREAT);
        setAttack1(DEFAULT_ATTACK1);
        setAttack1Detail(DEFAULT_ATTACK1_DETAIL);
        setAttack1Cost(DEFAULT_ATTACK1_COST);
        setAttack1Damage(DEFAULT_ATTACK1_DAMAGE);
        setAttack2(DEFAULT_ATTACK2);
        setAttack2Detail(DEFAULT_ATTACK2_DETAIL);
        setAttack2Cost(DEFAULT_ATTACK2_COST);
        setAttack2Damage(DEFAULT_ATTACK2_DAMAGE);
        setAbilities(DEFAULT_ABILITIES);
        setCardText(DEFAULT_CARD_TEXT);
        setCardQuantity(DEFAULT_CARD_QUANTITY);
    }
    /**
     * Kind-of Full Constructor
     * @param name - the name of the card
     * @param hp - the hit points of a the card
     * @param collectiveNum - the collection the card belongs to
     * @param cardType - the card type (element type or trainer)
     */
    public Card (String name, String hp, String collectiveNum, String cardType) {
        super(name);
        setHp(stringToInt(hp));
        setCollectionNum(stringToInt(collectiveNum));
        setCardType(cardType);
        setCardQuantity(DEFAULT_CARD_QUANTITY);
    }

    /**
     * Copy Constructor
     * @param original - The card who's values will be copied from
     */
    public Card (Card original) {
        super();
        if (original !=null) {
            setName(original.getName());
            setHp(original.getHp());
            setCollectionNum(original.getCollectionNum());
            setCardType(original.getCardType());
            setEvolvesFrom(original.getEvolvesFrom());
            setPokeType(original.getPokeType());
            setWeakness(original.getWeakness());
            setResistance(original.getResistance());
            setRetreat(original.getRetreat());
            setAttack1(original.getAttack1());
            setAttack1Detail(original.getAttack1Detail());
            setAttack1Cost(original.getAttack1Cost());
            setAttack1Damage(original.getAttack1Damage());
            setAttack2(original.getAttack2());
            setAttack2Detail(original.getAttack2Detail());
            setAttack2Cost(original.getAttack2Cost());
            setAttack2Damage(original.getAttack2Damage());
            setAbilities(original.getAbilities());
            setCardText(original.getCardText());
            setCardQuantity(original.getQuantity());
        } else{
            System.out.println("Error: trying copy a NULL card!");
            System.exit(0);
        }
    }

    /**
     * Full Constructor
     * @param name - name of the card
     * @param hp - represents the hit points value of the card
     * @param collectionNum - the collection number the card belongs to
     * @param cardType - the card can either be a Pokemon, trainer or supporter
     * @param evolvesFrom - the name of Pokemon the current card evolves from
     * @param pokeType - the element type of the Pokemon
     * @param weakness - the element type the card is weak to
     * @param resistance - the element type the card is resistance to
     * @param retreat - the cost amount to retreat
     * @param attack1 - Name of the first attack
     * @param attack1Detail - The details of the first attack
     * @param attack1Cost - The cost for the first attack
     * @param attack1Damage - The damage the first attack deals
     * @param attack2 - Name of the second attack
     * @param attack2Detail - The details of the second attack
     * @param attack2Cost - The cost for the second
     * @param attack2Damage - The damage the second attack deals
     * @param abilities - Details of the Pokemon's abilities
     * @param cardText - Extra text from the card
     */
    public Card (String name, String hp,String collectionNum, String cardType, String evolvesFrom,
              String pokeType, String weakness, String resistance, String retreat,
              String attack1, String attack1Detail, String attack1Cost,
              String attack1Damage, String attack2, String attack2Detail,
              String attack2Cost, String attack2Damage, String abilities,
              String cardText) {
        super();
        setName(name);
        setHp(stringToInt(hp));
        setCollectionNum(stringToInt(collectionNum));
        setCardType(cardType);
        setEvolvesFrom(evolvesFrom);
        setPokeType(pokeType);
        setWeakness(weakness);
        setResistance(resistance);
        setRetreat(retreat);
        setAttack1(attack1);
        setAttack1Detail(attack1Detail);
        setAttack1Cost(attack1Cost);
        setAttack1Damage(attack1Damage);
        setAttack2(attack2);
        setAttack2Detail(attack2Detail);
        setAttack2Cost(attack2Cost);
        setAttack2Damage(attack2Damage);
        setAbilities(abilities);
        setCardText(cardText);
        setCardQuantity(DEFAULT_CARD_QUANTITY);
    }

     /**
      * toString
      * @return
      */
    @Override
    public String toString(){
        System.out.println("------------------------------------------");
        System.out.printf("| %-15s %6d %15s |%n", getName(), getHp(), getPokeType());
        System.out.printf("| %-38s |%n", getCardType());
        System.out.printf("| %-38s |%n", getEvolvesFrom());
        System.out.printf("| %38s |%n", " ");
        System.out.printf("| %-38s |%n", getAttack1Cost());
        System.out.printf("| %-32s %5s |%n", getAttack1(), getAttack1Damage());
        System.out.printf("%-38s|%n", attackDetailFormat(getAttack1Detail()));
        System.out.printf("| %38s |%n", " ");
        System.out.printf("| %-38s |%n", getAttack2Cost());
        System.out.printf("| %-32s %5s |%n", getAttack2(), getAttack2Damage());
        System.out.printf("%-38s|%n", attackDetailFormat(getAttack2Detail()));
        System.out.printf("| %38s |%n", " ");
        System.out.printf("| %-19s%-19s |%n", "Weakness", "Resistance");
        System.out.printf("| %-19s%-19s |%n", getWeakness(), getResistance());
        System.out.printf("| %38s |%n", " ");
        System.out.printf("| %-19s%19s |%n", "Retreat", "Collection Number");
        System.out.printf("| %-19s%19d |%n", getRetreat(), getCollectionNum());
        System.out.println("------------------------------------------");
        String result = "";
        return result;
    }

     /**
      * stringToInt - takes a String value and converts it to an int
      * NOTES: This has no error checking
      * @param line - contains a value
      * @return int
      */
    private int stringToInt(String line) {
        int result;
        result = Integer.parseInt(line);
        return result;
    }

     /**
      * addCardQuuantity - adds the specified quantity to the existing quantity
      * @param quantity - the number of cards that will be added
      */
    public void addCardQuantity(int quantity) {
        this.cardQuantity += quantity;
    }

     /**
      * Mutator for instance variable HP
      * @param hp
      */
    private void setHp(int hp) {
        this.hp = hp;
    }

     /**
      * Mutator for instance variable collectionNum
      * @param collectionNum
      */
    private void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

     /**
      * Mutator for instance variable pokeType
      * @param pokeType
      */
    private void setPokeType(String pokeType) {
        this.pokeType = pokeType;
    }

     /**
      * Mutator for instance variable evolvesFrom
      * @param evolvesFrom
      */
    private void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

     /**
      * Mutator for instance variable cardType
      * @param cardType
      */
    private void setCardType (String cardType) {
        this.cardType = cardType;
    }

     /**
      * Mutator for instance variable weakness
      * @param weakness
      */
    private void setWeakness (String weakness) {
        this.weakness = weakness;
    }

     /**
      * Mutator for instance variable resistance
      * @param resistance
      */
    private void setResistance (String resistance) {
        this.resistance = resistance;
    }

     /**
      * Mutator for instance variable retreat
      * @param retreat
      */
    private void setRetreat (String retreat) {
        this.retreat = retreat;
    }

     /**
      * Mutator for instance variable attack1
      * @param attack1
      */
    private void setAttack1 (String attack1) {
        this.attack1 = attack1;
    }

     /**
      * Mutator for instance variable attack1Detail
      * @param attack1Detail
      */
    private void setAttack1Detail (String attack1Detail) {
        this.attack1Detail = attack1Detail;
    }

     /**
      * Mutator for instance variable attack1Cost
      * @param attack1Cost
      */
    private void setAttack1Cost (String attack1Cost) {
        this.attack1Cost = attack1Cost;
    }

     /**
      * Mutator for instance variable attack1Damage
      * @param attack1Damage
      */
    private void setAttack1Damage(String attack1Damage) {
        this.attack1Damage = attack1Damage;
    }

     /**
      * Mutator for instance variable attack2
      * @param attack2
      */
    private void setAttack2 (String attack2) {
        this.attack2 = attack2;
    }

     /**
      * Mutator for instance variable attack2Detail
      * @param attack2Detail
      */
    private void setAttack2Detail (String attack2Detail) {
        this.attack2Detail = attack2Detail;
    }

     /**
      * Mutator for instance variable attack2Cost
      * @param attack2Cost
      */
    private void setAttack2Cost (String attack2Cost) {
        this.attack2Cost = attack2Cost;
    }

     /**
      * Mutator for instance variable attack2Damage
      * @param attack2Damage
      */
    private void setAttack2Damage(String attack2Damage) {
        this.attack2Damage = attack2Damage;
    }

     /**
      * Mutator for instance variable abilities
      * @param abilities
      */
    private void setAbilities(String abilities) {
        this.abilities = abilities;
    }

     /**
      * Mutator for instance variable cardText
      * @param cardText
      */
    private void setCardText (String cardText) {
        this.cardText = cardText;
    }

     /**
      * Mutator for instance variable cardQuantity
      * @param cardQuantity
      */
    private void setCardQuantity (int cardQuantity) {
        this.cardQuantity = cardQuantity;
    }

     /**
      * Accessor for instance variable hp
      * @return
      */
    public int getHp() {
        return this.hp;
    }

     /**
      * Accessor for instance variable  collectionNum
      * @return
      */
    public int getCollectionNum() {
        return this.collectionNum;
    }

     /**
      * Accessor for instance variable pokeType
      * @return
      */
    public String getPokeType() {
        return this.pokeType;
    }

     /**
      * Accessor for instance variable evolvesFrom
      * @return
      */
    public String getEvolvesFrom() {
        return this.evolvesFrom;
    }

     /**
      * Accessor for instance variable cardType
      * @return
      */
    public String getCardType () {
        return this.cardType;
    }

     /**
      * Accessor for instance variable weakness
      * @return
      */
    public String getWeakness () {
        return this.weakness;
    }

     /**
      * Accessor for instance variable resistance
      * @return
      */
    public String getResistance () {
        return this.resistance;
    }

     /**
      * Accessor for instance variable retreat
      * @return
      */
    public String getRetreat () {
        return this.retreat;
    }

     /**
      * Accessor for instance variable attack1
      * @return
      */
    public String getAttack1 () {
        return this.attack1;
    }

     /**
      * Accessor for instance variable attack1Detail
      * @return
      */
    public String getAttack1Detail () {
        return this.attack1Detail;
    }

     /**
      * Accessor for instance variable attack1Cost
      * @return
      */
    public String getAttack1Cost () {
        return this.attack1Cost;
    }

     /**
      * Accessor for instance variable attack1Damage
      * @return
      */
    public String getAttack1Damage() {
        return this.attack1Damage;
    }

     /**
      * Accessor for instance variable attack2
      * @return
      */
    public String getAttack2 () {
        return this.attack2;
    }

     /**
      * Accessor for instance variable attack2Detail
      * @return
      */
    public String getAttack2Detail () {
        return this.attack2Detail;
    }

     /**
      * Accessor for instance variable attack2Cost
      * @return
      */
    public String getAttack2Cost () {
        return this.attack2Cost;
    }

     /**
      * Accessor for instance variable attack2Damage
      * @return
      */
    public String getAttack2Damage() {
        return this.attack2Damage;
    }

     /**
      * Accessor for instance variable abilities
      * @return
      */
    public String getAbilities() {
        return this.abilities;
    }

     /**
      * Accessor for instance variable cardText
      * @return
      */
    public String getCardText () {
        return this.cardText;
    }

     /**
      * Accessor for instance variable quantity
      * @return
      */
    public int getQuantity() {
        return this.cardQuantity;
    }

     /**
      * Mutator for instance variable name
      * @param name
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

     /**
      * attackDetailFormat - Creates a String that is formatted to look like a card on the
      *                      console screen.
      * @param detail - the attack detail
      * @return - attack detail onto the console
      */
    private String attackDetailFormat(String detail) {
        int length;
        length = detail.length();
        String result;
        result = "| ";
        if (length > SPACES_IN_CARD_OUTPUT) {
            for (int i = 0; i < length/SPACES_IN_CARD_OUTPUT ; i++) {

                result += detail.substring(((i)*SPACES_IN_CARD_OUTPUT), (SPACES_IN_CARD_OUTPUT*(i+1)))+"|\n| " ;
            }
            if (length%SPACES_IN_CARD_OUTPUT!=0);{
                result += detail.substring(((length/SPACES_IN_CARD_OUTPUT)*SPACES_IN_CARD_OUTPUT), length);
                result += makeSpaces(SPACES_IN_CARD_OUTPUT - length%SPACES_IN_CARD_OUTPUT);
            }
        } else {
            result += detail;
            result += makeSpaces(SPACES_IN_CARD_OUTPUT - length);
        }
        return result;
    }

     /**
      * makesSpaces - creates a number of specified spaces
      * @param n - the number of spaces
      * @return - String containing the specified amount of spaces
      */
    public static String makeSpaces(int n) {
        String result;
        result = "";

        for(int i = 0; i < n; i++) {
            result+= " ";
        }
        return result;
    }
}
