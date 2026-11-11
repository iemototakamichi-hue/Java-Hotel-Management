public class Budget extends Hotel{

    private boolean freeBreakfast;
    private boolean sharedBathroom;
    private double discountRate;
//Private attributes
    public Budget(){ //default constructor

    }

    public Budget (int hotelID, String hotelName, int starRating
            , String phoneNumber, String City, boolean isActive, int totalRooms,
                   boolean freeBreakfast, boolean sharedBathroom, double discountRate){
        super(hotelID, hotelName, starRating, phoneNumber, City, isActive, totalRooms);             //parameter constructor to collect info
        this.freeBreakfast = freeBreakfast;
        this.sharedBathroom = sharedBathroom;
        this.discountRate = discountRate;
    }


            //Setter and getter
    public boolean isFreeBreakfast() {
        return freeBreakfast;
    }

    public void setFreeBreakfast(boolean freeBreakfast) {
        this.freeBreakfast = freeBreakfast;
    }

    public boolean isSharedBathroom() {
        return sharedBathroom;
    }

    public void setSharedBathroom(boolean sharedBathroom) {
        this.sharedBathroom = sharedBathroom;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }


    //To Sting replaces main
    @Override
    public String toString(){
        return  "\n//Budget Hotel//" +
                "\nHotelID : " + getHotelID() +
                "\nHotelName : " + getHotelName() +
                "\nStarRating : " + getStarRating() +
                "\nPhone Number : " + getPhoneNumber() +
                "\nCity : " + getCity() +
                "\nIsActive : " + isActive() +
                "\nNumber of rooms : " + getTotalRooms() +
                "\nHas Free Breakfast :" + freeBreakfast +
                "\nHas Shared Bathrooms : " + sharedBathroom +
                "\nDiscount rate : " + discountRate + "%";

    }
}
