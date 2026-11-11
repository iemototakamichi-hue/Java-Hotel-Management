public class Luxury extends Hotel{

    //private attributes
    private boolean hasSpa;
    private boolean hasSwimmingPool;
    private double luxuryTaxRate;

    public Luxury(){ //default constructor

    }
    public Luxury (int hotelID, String hotelName, int starRating
            , String phoneNumber, String City, boolean isActive, int totalRooms,
                   boolean hasSpa, boolean hasSwimmingPool, double luxuryTaxRate){ //Constructor with parameter

        super(hotelID, hotelName, starRating, phoneNumber, City, isActive, totalRooms);
        this.hasSpa = hasSpa;
        this.luxuryTaxRate = luxuryTaxRate;
        this.hasSwimmingPool = hasSwimmingPool;
    }

    //setter and getter
    public boolean isHasSpa() {
        return hasSpa;
    }

    public void setHasSpa(boolean hasSpa) {
        this.hasSpa = hasSpa;
    }

    public boolean isHasSwimmingPool() {
        return hasSwimmingPool;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public double getLuxuryTaxRate() {
        return luxuryTaxRate;
    }

    public void setLuxuryTaxRate(double luxuryTaxRate) {
        this.luxuryTaxRate = luxuryTaxRate;
    }

    //To string replaces main
    @Override
    public String toString(){
        return  "\n//Luxury Hotel//" +
                "\nHotelID : " + getHotelID() +
                "\nHotelName : " + getHotelName() +
                "\nStarRating : " + getStarRating() +
                "\nPhone Number : " + getPhoneNumber() +
                "\nCity : " + getCity() +
                "\nIsActive : " + isActive() +
                "\nNumber of rooms : " + getTotalRooms() +
                "\nHas Spa : " + hasSpa +
                "\nHas Swimming Pool : " + hasSwimmingPool +
                "\nLuxury Tax Rate : " + luxuryTaxRate + "%";
    }
}
