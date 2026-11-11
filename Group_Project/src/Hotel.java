public abstract class Hotel {
    private String hotelName;
    private int hotelID;
    private int starRating;
    private String phoneNumber;
    private String city;
    private boolean isActive;
    private int totalRooms;
    //Private attribute

    //Default constructor
    public Hotel() {

    }
    //parameter constructor
    public Hotel(int hotelID, String hotelName, int starRating
            , String phoneNumber, String City, boolean isActive, int totalRooms) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.starRating = starRating;
        this.phoneNumber = phoneNumber;
        this.city = City;
        this.isActive = isActive;
        this.totalRooms = totalRooms;
    }

    //Set and Getter

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public abstract String toString(); //forces all the class to have this method
}

