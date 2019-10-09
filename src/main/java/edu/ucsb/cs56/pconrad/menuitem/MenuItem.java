package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    /**
     Custom exception thrown when getPrice is called with a width
     that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {}


    public MenuItem(String name, int priceInCents, String category) {
	this.name=name;
	this.priceInCents=priceInCents;
	this.category=category;
    }
    
    public String getName(){
	return this.name;
    }
    
    public String getCategory(){
	return this.category;
    }

    /**
     Returns the price, formatted as a string with a $.
     For example "$0.99", "$10.99", or "$3.50"
     */

    public String getPrice() {
	int PriceInDollar=this.priceInCents/100;
	return "$"+Integer.toString(PriceInDollar);
    }
	
    /**
     Returns the price, formatted as a string with a $,
     right justified in a field with the specified width.
     For example "$0.99", "$10.99", or "$3.50".

     If the width is too small, throws IllegalArgumentException

     @param width width of returned string

     */

    public String getPrice(int width) {
	    int PriceInDollar=this.priceInCents/100;
	    String displayPrice="$"+Integer.toString(PriceInDollar);
	    if(displayPrice.length()<width){
		throw new IllegalArgumentException("@param width width of returned string");
	    }
	    return displayPrice;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     * @return string in csv format
     */

    @Override
    public String toString() {
	//return "a";
	return this.getName()+","+this.getPrice()+","+this.getCategory();
    }

}