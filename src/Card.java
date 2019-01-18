/**This is the Card Class. It makes a Card item with the following:
 * @author Kostas Oikonomou
 * @version 2
 */

public class Card {
    private int cardValue;
    private boolean isOpen;

    /**
     * This is the constructor with:
     * @param cardValue an int that represents the value of the card.
     * @param isOpen a boolean that shows if the card is open.
     */

    public Card (int cardValue,boolean isOpen)
    {
        this.cardValue = cardValue;
        this.isOpen = isOpen;
    }

    /**
     * This function:
     * @return an int that represents the value of the card.
     */

    public int getCardValue(){return cardValue;}

    /**
     * This function:
     * @return a boolean that shows if the card is open.
     */

    public boolean getIsOpen(){return isOpen;}

    /**
     * This function sets:
     * @param isOpen which represents the state of the card (open / closed).
     */

    public void setIsOpen(boolean isOpen){this.isOpen = isOpen;}

    /**
     * This function sets:
     * @param value which represents the value of the card.
     */

    public void setCardValue(int value){this.cardValue = value;}

}
