import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestProgram {
    static Scanner input = new Scanner(System.in); //<Scanner
    static ArrayList<Hotel> listHotel = new ArrayList<>(); //<Hotel List
    static ArrayList<Log> listLog = new ArrayList<>(); //<Log List
//Made these static so that i can use for all methods i found it being clean


    public static void main(String[] args) {
        Log log1 = new Log("User Entered View Hotels");
        Log log2 = new Log("User Entered Edit Hotels");
        Log log3 = new Log("User Entered Add New Hotels");
        Log log4 = new Log("User Entered Remove Hotel");
        Log log5 = new Log("User Checked Logging System");
        Log log6 = new Log("User Exited Program");
        Log logOutOfBound = new Log("Out Of Bound Error at main menu");
        Log logInvalidInput = new Log("Invalid Input Error at main menu"); //All these is log
        int option = 0;
        do {        //<Main Menu
            try {
                System.out.println("\n------------------------");
                System.out.println("Hotel Management System");
                System.out.println("------------------------");
                System.out.println("(1).View Hotels");
                System.out.println("(2).Edit Hotel Info");
                System.out.println("(3).Add New Hotel");
                System.out.println("(4).Remove Hotel");
                System.out.println("(5).Logging System");
                System.out.println("(6).Exit");
                System.out.print("Enter Your Option : ");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        listLog.add(log1);      //<Shows what the user is doing in log
                        viewHotel();
                        break;
                    case 2:
                        listLog.add(log2);
                        editHotel();
                        break;
                    case 3:
                        listLog.add(log3);
                        addHotel();

                        break;
                    case 4:
                        listLog.add(log4);
                        removeHotel();

                        break;
                    case 5:
                        listLog.add(log5);
                        loggingSystem();

                        break;
                    case 6:
                        listLog.add(log6);
                        System.out.println("\nThank you for using this system!!!");

                        break;
                    default:
                        listLog.add(logOutOfBound);
                        System.out.println("\nInvalid Input");  //Also Read User Numbers that is out of bound

                        break;

                }
            } catch (InputMismatchException ex) {
                System.out.println("\nNo Letters Only Numbers!!!!");        //Exceptional handling reads user misinput
                listLog.add(logInvalidInput);
                input.nextLine();
            }

        } while (option != 6);
    }

    static void viewHotel() {
        Log log11 = new Log("User Entered View Hotel -> Luxury Hotel");
        Log log111 = new Log("User viewed all Luxury Hotel");
        Log log111Error = new Log("No Hotel Detected");
        Log log112 = new Log("User Searched Luxury Hotel");
        Log log112Error = new Log("No Such Hotel Name Was Found");
        Log log113 = new Log("User Entered View Hotel -> Luxury Hotel -> Back");

        Log log12 = new Log("User Entered View Hotel -> Budget Hotel");
        Log log121 = new Log("User viewed all Budget Hotel");
        Log log121Error = new Log("No Hotel Detected");
        Log log122 = new Log("User Searched Budget Hotel");
        Log log122Error = new Log("No Such Hotel Name Was Found");
        Log log123 = new Log("User Entered View Hotel -> Budget Hotel -> Back");

        Log logOutOfBound = new Log("Out Of Bound Error at View Hotel");
        Log logInvalidInput = new Log("Invalid Input Error at View Hotel"); //all these are logs

        int hotelOption = 0;
        int subOption;
        boolean luxuryFound;
        boolean budgetFound;
        do {
            try {
                System.out.println("\n----------------");
                System.out.println("View Hotel");
                System.out.println("----------------");
                System.out.println("(1).Luxury Hotel");
                System.out.println("(2).Budget Hotel");
                System.out.println("(3).Back");
                System.out.print("Enter Your Option : ");
                hotelOption = input.nextInt();
                switch (hotelOption) {
                    case 1:
                        listLog.add(log11);
                        System.out.println("\n------------------------");
                        System.out.println("Select Your Options");
                        System.out.println("------------------------");
                        System.out.println("(1).All");
                        System.out.println("(2).Search");
                        System.out.println("(3).Back");
                        System.out.print("Enter Your Option : ");
                        subOption = input.nextInt();
                        switch (subOption) {
                            case 1:

                                luxuryFound = false;

                                for (int i = 0; i < listHotel.size(); i++) { //Scans all Hotel in The Hotel list
                                    Hotel luxury = listHotel.get(i);
                                    if (luxury instanceof Luxury){ // Check if the hotel is a luxury or budget
                                        System.out.println(luxury);
                                        luxuryFound = true;
                                    }
                                }
                                if (!luxuryFound){
                                    System.out.println("No Hotel Detected"); //If detect no Hotel
                                    listLog.add(log111Error);
                                }else {
                                    listLog.add(log111);
                                }
                                break;
                            case 2:

                                input.nextLine();
                                System.out.print("Enter the name of the Hotel : ");
                                String searchLuxuryName = input.nextLine();
                                luxuryFound = false;

                                for(int i = 0; i < listHotel.size(); i++) {//Scans all Hotel in The Hotel list

                                    Hotel luxuryName = listHotel.get(i);
                                    if(luxuryName.getHotelName().toLowerCase().contains(searchLuxuryName.toLowerCase())){ //Check all the name and match it with the input
                                        if(luxuryName instanceof Luxury) {  // Check if the hotel is a luxury or budget
                                            System.out.println(luxuryName);

                                            luxuryFound = true;
                                        }
                                    }

                                }if (!luxuryFound){//If detect no Hotel
                                System.out.println("Cant find name");
                                listLog.add(log112Error);
                                }else{
                                listLog.add(log112);
                                }
                                break;
                            case 3:
                                System.out.println("\nBacked");
                                listLog.add(log113);
                                break;
                            default:
                                System.out.println("\nInvalid option");
                                listLog.add(logOutOfBound);
                                break;
                        }
                        break;
                    case 2:
                        listLog.add(log12);
                        System.out.println("\n" +
                                "------------------------");
                        System.out.println("Select Your Options");
                        System.out.println("------------------------");
                        System.out.println("(1).All");
                        System.out.println("(2).Search");
                        System.out.println("(3).Back");
                        System.out.print("Enter Your Option : ");
                        subOption = input.nextInt();
                        switch (subOption) {
                            case 1:

                                budgetFound = false;
                                for (int i = 0; i < listHotel.size(); i++) {    //Scan all hotel
                                    Hotel budget = listHotel.get(i);
                                    if (budget instanceof Budget){          //Check if it is budget
                                        System.out.println(budget);
                                    }
                                }if (!budgetFound) {        //Helps to see if there is any hotel
                                System.out.println("No Hotel Detected");
                                listLog.add(log121Error);
                                }else{
                                listLog.add(log121);
                                }
                                break;
                            case 2:

                                input.nextLine();       //Removes enter
                                System.out.print("Enter the name of the Hotel : ");
                                String searchBudgetName = input.nextLine();
                                budgetFound = false;

                                for(int i = 0; i < listHotel.size(); i++) { //Scan all Hotels

                                    Hotel budgetName = listHotel.get(i);
                                    if(budgetName.getHotelName().toLowerCase().contains(searchBudgetName.toLowerCase())){   //Check all the name and match it with the input
                                        if(budgetName instanceof Budget) {
                                            System.out.println(budgetName);
                                            budgetFound = true;
                                        }
                                    }

                                }if (!budgetFound){
                                System.out.println("Cant find name"); //Check if can find name
                                listLog.add(log122Error);
                                }else{
                                listLog.add(log122);
                                }
                                break;
                            case 3:
                                System.out.println("\nBacked");
                                listLog.add(log123);
                                break;
                            default:
                                System.out.println("\nInvalid option");
                                listLog.add(logOutOfBound);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("\nExited");
                        break;
                    default:
                        System.out.println("\nInvalid option");
                        listLog.add(logOutOfBound);
                        break;
                }

            } catch (InputMismatchException ex) {       //Exceptional handling Check for misinput
                System.out.println("\nNo Letters Only Numbers!!!!");
                input.nextLine();
                listLog.add(logInvalidInput);
            }
        } while (hotelOption != 3);


    } //Done

    static void addHotel() {
        int addOption = 0;
        Log log1 = new Log("User Added Luxury Hotel");
        Log log1Error = new Log ("User MissInput Adding Luxury Hotel");

        Log log2 = new Log("User Added Budget Hotel");
        Log log2Error = new Log ("User MissInput Adding Budget Hotel");

        Log log3 = new Log ("User Exited From Add Hotel");

        Log logOutOfBound = new Log("Out Of Bound Error at Add Hotel");
        Log logInvalidInput = new Log("Invalid Input Error at Add Hotel");

        do {
            try {
                System.out.println("\n----------------");
                System.out.println("Add Hotel");
                System.out.println("----------------");
                System.out.println("(1).Luxury");
                System.out.println("(2).Budget");
                System.out.println("(3).Back");
                System.out.print("Enter Your Option : ");
                addOption = input.nextInt();
                switch (addOption) {
                    case 1:
                        String LuxuryError = "y";
                        do {
                            try {
                                System.out.print("Hotel ID : ");
                                int hotelID = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Hotel Name : ");
                                String hotelName = input.nextLine();
                                System.out.print("Star rating : ");
                                int starRating = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Phone Number : ");
                                String phoneNumber = input.nextLine();
                                System.out.print("City : ");
                                String City = input.nextLine();
                                System.out.print("IsActive? : ");
                                boolean isActive = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Total Rooms : ");
                                int totalRooms = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Has Spa : ");
                                boolean hasSpa = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Has Swimming Pool : ");
                                boolean hasSwimmingPool = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Luxury tax Rate : ");
                                double luxuryTaxRate = input.nextDouble();
                                input.nextLine();//Removes enter

                                listHotel.add(new Luxury(hotelID, hotelName, starRating,
                                        phoneNumber, City, isActive, totalRooms, hasSpa,
                                        hasSwimmingPool, luxuryTaxRate)); // Place everything in the constructor
                                System.out.println("\nSuccess Fully Added");
                                listLog.add(log1);
                                LuxuryError = "n";

                            } catch (InputMismatchException ex) { //Catch any miss match


                                System.out.println("Wrong Input Try again");
                                System.out.print("Still want to continue? (y/n): ");
                                input.nextLine();
                                LuxuryError = input.nextLine();
                                listLog.add(log1Error);

                            }

                        } while (LuxuryError.equals("y"));

                        break;
                    case 2:
                        String BudgetError = "y";

                        do {
                            try {
                                System.out.print("Hotel ID : ");
                                int hotelID = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Hotel Name : ");
                                String hotelName = input.nextLine();
                                System.out.print("Star rating : ");
                                int starRating = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Phone Number : ");
                                String phoneNumber = input.nextLine();
                                System.out.print("City : ");
                                String City = input.nextLine();
                                System.out.print("IsActive? : ");
                                boolean isActive = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Total Rooms : ");
                                int totalRooms = input.nextInt();
                                input.nextLine();//Removes enter
                                System.out.print("Has Free Breakfast : ");
                                boolean hasFreeBreakfast = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Has Shared Bathrooms : ");
                                boolean hasSharedBathroom = input.nextBoolean();
                                input.nextLine();//Removes enter
                                System.out.print("Discount Rate : ");
                                double discountRate = input.nextDouble();
                                input.nextLine();//Removes enter


                                listHotel.add(new Budget(hotelID, hotelName, starRating,
                                        phoneNumber, City, isActive, totalRooms,
                                        hasFreeBreakfast, hasSharedBathroom, discountRate));// Place everything in the constructor
                                System.out.println("\nSuccessfully Added");
                                listLog.add(log2);
                                BudgetError = "n";

                            } catch (InputMismatchException ex) {//Catch any miss match
                                System.out.println("Wrong Input Try again");
                                listLog.add(log2Error);
                                System.out.print("Still want to continue? (y/n): ");
                                input.nextLine();
                                BudgetError = input.nextLine();

                            }

                        } while (BudgetError.equals("y"));
                        System.out.println("\nExited");
                        break;
                    case 3:
                        System.out.println("\nExited");
                        listLog.add(log3);
                        break;
                    default:
                        System.out.print("Invalid Option");
                        listLog.add(logOutOfBound);
                        break;
                }

            } catch (InputMismatchException ex) {//Catch any miss input
                System.out.println("\nNo Letters Only Numbers!!!!");
                listLog.add(logInvalidInput);
                input.nextLine();
            }
        }while(addOption != 3);
    }//Done

    static void editHotel(){
        Log log21 = new Log("User Searched Luxury Hotel");
        Log log21Error = new Log("No Such Hotel Name Was Found");

        Log log22 = new Log("User Searched Budget Hotel");
        Log log22Error = new Log("No Such Hotel Name Was Found");

        Log log23 = new Log("User Entered View Hotel -> Back");

        Log logOutOfBound = new Log("Out Of Bound Error at Edit Hotel");
        Log logInvalidInput = new Log("Invalid Input Error at Edit Hotel"); //Logs

        int hotelOption = 0;

        do {
            try {
                System.out.println("\n----------------");
                System.out.println("Edit Hotel");
                System.out.println("----------------");
                System.out.println("(1).Luxury Hotel");
                System.out.println("(2).Budget Hotel");
                System.out.println("(3).Back");
                System.out.print("Enter Your Option : ");
                hotelOption = input.nextInt();
                switch (hotelOption) {
                    case 1:
                        String LuxuryError = "y";
                        input.nextLine();//Removes enter
                        System.out.print("Enter the of name the Hotel you want to edit : ");
                        String searchluxuryName = input.nextLine();
                        boolean luxuryFound = false;

                        for(int i = 0; i < listHotel.size(); i++) {  //Scans for all Hotel

                            Hotel LuxuryName = listHotel.get(i);
                            if(LuxuryName.getHotelName().equalsIgnoreCase(searchluxuryName)){ //Scans for matching names
                                if(LuxuryName instanceof Luxury) { //Check if is in luxury or budget
                                    do {
                                        try {
                                            System.out.print("Hotel ID : ");
                                            int hotelID = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Hotel Name : ");
                                            String hotelName = input.nextLine();
                                            System.out.print("Star rating : ");
                                            int starRating = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Phone Number : ");
                                            String phoneNumber = input.nextLine();
                                            System.out.print("City : ");
                                            String City = input.nextLine();
                                            System.out.print("IsActive? : ");
                                            boolean isActive = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Total Rooms : ");
                                            int totalRooms = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Has Spa : ");
                                            boolean hasSpa = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Has Swimming Pool : ");
                                            boolean hasSwimmingPool = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Luxury tax Rate : ");
                                            double luxuryTaxRate = input.nextDouble();
                                            input.nextLine();//Removes enter

                                            listHotel.set(i, new Luxury(hotelID, hotelName, starRating,
                                                    phoneNumber, City, isActive, totalRooms, hasSpa,
                                                    hasSwimmingPool, luxuryTaxRate)); //Place all this into subclass constructor
                                            System.out.println("\nSuccess Fully Edited");

                                            luxuryFound = true;
                                            break;
                                        } catch (InputMismatchException ex) {  //Catch miss match


                                            System.out.println("Wrong Input Try again");
                                            System.out.print("Still want to continue? (y/n): ");
                                            input.nextLine();
                                            LuxuryError = input.nextLine();

                                        }


                                    }while (LuxuryError.equals("y")) ;

                                }
                            }

                        }if (!luxuryFound){
                        System.out.println("Cant find name");  //Check if name can be found
                        listLog.add(log21Error);
                        }else {
                        listLog.add(log21);
                        }
                        break;
                    case 2:
                        String BudgetError = "y";
                        input.nextLine();//Removes enter
                        System.out.print("Enter the name Hotel you want to edit : ");
                        String searchbudgetName = input.nextLine();
                        boolean budgetFound = false;

                        for(int i = 0; i < listHotel.size(); i++) {

                            Hotel BudgetName = listHotel.get(i);
                            if(BudgetName.getHotelName().equalsIgnoreCase(searchbudgetName)){ //Check if there is matching name
                                if(BudgetName instanceof Budget) { //check if it is budget or luxury
                                    do {
                                        try {
                                            System.out.print("Hotel ID : ");
                                            int hotelID = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Hotel Name : ");
                                            String hotelName = input.nextLine();
                                            System.out.print("Star rating : ");
                                            int starRating = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Phone Number : ");
                                            String phoneNumber = input.nextLine();
                                            System.out.print("City : ");
                                            String City = input.nextLine();
                                            System.out.print("IsActive? : ");
                                            boolean isActive = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Total Rooms : ");
                                            int totalRooms = input.nextInt();
                                            input.nextLine();//Removes enter
                                            System.out.print("Has Free Breakfast : ");
                                            boolean hasFreeBreakfast = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Has Shared Bathrooms : ");
                                            boolean hasSharedBathroom = input.nextBoolean();
                                            input.nextLine();//Removes enter
                                            System.out.print("Discount Rate : ");
                                            double discountRate = input.nextDouble();
                                            input.nextLine();//Removes enter

                                            listHotel.set(i, new Budget(hotelID, hotelName, starRating,
                                                    phoneNumber, City, isActive, totalRooms, hasFreeBreakfast, hasSharedBathroom, discountRate)); //Place all in the subclass Constructor
                                            System.out.println("\nSuccess Fully Edited");

                                            budgetFound = true;
                                            break;
                                        } catch (InputMismatchException ex) { //check for miss match input


                                            System.out.println("Wrong Input Try again");
                                            System.out.print("Still want to continue? (y/n): ");
                                            input.nextLine();
                                            BudgetError = input.nextLine();

                                        }


                                    }while (BudgetError.equals("y")) ;

                                }
                            }

                        }if (!budgetFound){ //Check if name can be found
                        System.out.println("Cant find name");
                        listLog.add(log22Error);
                        }else {
                        listLog.add(log22);
                        }
                        break;
                    case 3:
                        System.out.println("\nExited");
                        listLog.add(log23);
                        break;
                    default:
                        System.out.println("\nInvalid option");
                        listLog.add(logOutOfBound);
                        break;
                }

            } catch (InputMismatchException ex) {   //Catch miss input
                System.out.println("\nNo Letters Only Numbers!!!!");
                input.nextLine();//Removes enter
                listLog.add(logInvalidInput);
            }
        } while (hotelOption != 3);





    }//Done

    static void removeHotel(){
        Log log311 = new Log("User Remove all Luxury Hotel");
        Log log311Error = new Log("Cancel remove Luxury Hotel");
        Log log311Success = new Log("Successfully Removed All Luxury Hotel");
        Log log312 = new Log("User Searched Luxury Hotel");
        Log log312Error = new Log("No Such Hotel Name Was Found");
        Log log312Success = new Log("Successfully Removed Luxury Hotel");
        Log log313 = new Log("User Entered View Hotel -> Delete Hotel -> Back");

        Log log321 = new Log("User Remove all Budget Hotel");
        Log log321Error = new Log("Cancel remove Budget Hotel");
        Log log321Success = new Log("Successfully Removed All Budget Hotel");
        Log log322 = new Log("User Searched Budget Hotel");
        Log log322Error = new Log("No Such Hotel Name Was Found");
        Log log322Success = new Log("Successfully Removed Budget Hotel");
        Log log323 = new Log("User Entered View Hotel -> Budget Hotel -> Back");

        Log logOutOfBound = new Log("Out Of Bound Error at View Hotel");
        Log logInvalidInput = new Log("Invalid Input Error at View Hotel");

        int hotelOption = 0;
        int subOption;
        int count;
        do {
            try {
                System.out.println("\n----------------");
                System.out.println("Remove Hotel");
                System.out.println("----------------");
                System.out.println("(1).Luxury Hotel");
                System.out.println("(2).Budget Hotel");
                System.out.println("(3).Back");
                System.out.print("Enter Your Option : ");
                hotelOption = input.nextInt();
                switch (hotelOption) {
                    case 1:
                        listLog.add(log311);
                        count = 0;
                        System.out.println("\n------------------------");
                        System.out.println("Select Your Options");
                        System.out.println("------------------------");
                        System.out.println("(1).All");
                        System.out.println("(2).Search");
                        System.out.println("(3).Back");
                        System.out.print("Enter Your Option : ");
                        subOption = input.nextInt();
                        switch (subOption) {
                            case 1:
                                input.nextLine();
                                System.out.println("Are you sure u want to delete all Luxury Hotel?(y/n)");
                                String luxuryOption = input.nextLine();
                                if (luxuryOption.equals("y")) {
                                    for (int i = listHotel.size() - 1; i >= 0; i--) { //Check all hotel from max size to 0
                                        // -1 because array start from 0
                                        Hotel luxury = listHotel.get(i);
                                        if (luxury instanceof Luxury) { //Check for luxury or budget
                                            listHotel.remove(i);
                                            count++; //Counting how much hotel is removed


                                        }
                                    }System.out.println("Successfully remove " + count + " Hotels.");
                                    listLog.add(log311Success);
                                }
                                    else if (luxuryOption.equals("n")){
                                        System.out.println("Canceled exit to main menu.");
                                        listLog.add(log311Error);
                                    }


                                break;
                            case 2:
                                listLog.add(log312);
                                input.nextLine();
                                System.out.print("Enter the name of the Luxury Hotel : ");
                                String searchLuxuryName = input.nextLine();
                                boolean luxuryFound = false;

                                for(int i = listHotel.size() - 1; i >= 0; i--) {

                                    Hotel luxuryName = listHotel.get(i);
                                    if(luxuryName.getHotelName().equalsIgnoreCase(searchLuxuryName)){ //check for matching name
                                        if(luxuryName instanceof Luxury) { //Check for luxury or budget
                                            listHotel.remove(i); // remove hotel
                                            System.out.println("Successfully remove " + luxuryName.getHotelName() +".");
                                            listLog.add(log312Success);
                                            luxuryFound = true;
                                        }

                                    }
                                }
                                if (!luxuryFound){
                                System.out.println("Cant find a hotel name " + searchLuxuryName + "."); //check if name can be found
                                    listLog.add(log312Error);
                                }
                                break;
                            case 3:
                                System.out.println("\nBacked");
                                listLog.add(log313);
                                break;
                            default:
                                System.out.println("\nInvalid option");
                                listLog.add(logOutOfBound);
                                break;

                        }break;

                    case 2:
                        count = 0;
                        System.out.println("\n" +
                                "------------------------");
                        System.out.println("Select Your Options");
                        System.out.println("------------------------");
                        System.out.println("(1).All");
                        System.out.println("(2).Search");
                        System.out.println("(3).Back");
                        System.out.print("Enter Your Option : ");
                        subOption = input.nextInt();
                        switch (subOption) {
                            case 1:
                                listLog.add(log321);
                                input.nextLine();
                                System.out.println("Are you sure u want to delete all Budget Hotel?(y/n)");
                                String BudgetOption = input.nextLine();
                                if (BudgetOption.equals("y")) {
                                    for (int i = listHotel.size() - 1; i >= 0; i--) { //Scan for all hotel fron top to bottom -1 because array start from 0
                                        Hotel budget = listHotel.get(i);
                                        if (budget instanceof Budget) { //Check for budget or luxury
                                            listHotel.remove(i);
                                            count++; //Helps count hotels removed
                                        }
                                    }System.out.println("Successfully remove " + count + " Hotels.");
                                    listLog.add(log321Success);
                                }else if (BudgetOption.equals("n")){
                                    System.out.println("Canceled exit to main menu.");
                                    listLog.add(log321Error);
                                }


                                break;
                            case 2:
                                listLog.add(log322);
                                input.nextLine();
                                System.out.print("Enter the name of the Budget Hotel : ");
                                String searchBudgetName = input.nextLine();
                                boolean budgetFound = false;

                                for(int i = listHotel.size() - 1; i >= 0; i--) { //Scans all hotel

                                    Hotel budgetName = listHotel.get(i);
                                    if(budgetName.getHotelName().equalsIgnoreCase(searchBudgetName)){ //Matching the name with hotel name
                                        if(budgetName instanceof Budget) { //Check if its budget or luxury
                                            listHotel.remove(i); //remove hotel
                                            System.out.println("Successfully remove " + budgetName.getHotelName() +".");
                                            budgetFound = true;
                                        }

                                    }
                                }listLog.add(log322Success);
                                if (!budgetFound){
                                System.out.println("Cant find a hotel name " + searchBudgetName + ".");  //Check if name can be found
                                listLog.add(log322Error);
                                }

                                break;
                            case 3:
                                System.out.println("\nExited");
                                listLog.add(log323);
                                break;
                            default:
                                System.out.println("\nInvalid option");
                                listLog.add(logOutOfBound);
                                break;
                        }


                }break;

            } catch (InputMismatchException ex) { //Catch miss match input
                System.out.println("\nNo Letters Only Numbers!!!!");
                input.nextLine();
                listLog.add(logInvalidInput);

            }
        } while (hotelOption != 3);

    }//Done

    static void loggingSystem(){
        Log logOutOfBound = new Log("Out Of Bound Error at Logging System");
        Log logInvalidInput = new Log("Invalid Input Error at Logging System");
        int logOption;
        int i = 0;

        try {
            System.out.println("\n------------------------");
            System.out.println("Logging System");
            System.out.println("------------------------");
            System.out.println("(1).View");
            System.out.println("(2).Clear");
            System.out.print("Enter Your Option : ");
            logOption = input.nextInt();
            switch (logOption) {
                case 1:
                    for(i = 0; i < listLog.size(); i++){  //prints out all the logs
                        Log logAdd = listLog.get(i);
                        System.out.print(logAdd);
                    }

                    break;
                case 2:
                    for(i = listLog.size() - 1; i >= 0; i--){ //Clear out alll the log
                        input.nextLine();
                        listLog.remove(i);
                        System.out.print("Successfully Cleared Log");
                    }

                    break;
                default:
                    System.out.println("\nInvalid Input");
                    listLog.add(logOutOfBound);
                    break;

            }
        } catch (InputMismatchException ex) { //catch miss match
            System.out.println("\nNo Letters Only Numbers!!!!");
            listLog.add(logInvalidInput);
            input.nextLine();
        }


    } //Done
}



