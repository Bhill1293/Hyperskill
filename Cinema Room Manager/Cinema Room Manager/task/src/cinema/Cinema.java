package cinema;

import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Objects;

public class Cinema {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int cinemaLength = scanner.nextInt();
        System.out.print("\n");

        System.out.println("Enter the number of seats in each row:");
        int cinemaWidth = scanner.nextInt();
        System.out.print("\n");

        int seatTotal = cinemaLength * cinemaWidth;

        // String openSeat = "S ";
        // String paidSeat = "B ";

        String[][] cinema = cinemaSeating(cinemaLength, cinemaWidth);

        while(theatreMenu(cinema, cinemaLength, cinemaWidth));

    }

    public static boolean theatreMenu(String[][] cinema, int cinemaLength, int cinemaWidth) {

        Scanner menuInput = new Scanner(System.in);
        boolean seatSecured = true;
        int purchasePrice = 0;
        int seatPick = 0;
        int rowPick = 0;
        boolean quitProgram = true;
        String menuMessage = ("1. Show the seats \n" +
                "2. Buy a ticket \n" + "3. Statistics \n" +
                "0. Exit");


        System.out.println(menuMessage);
        int menuOption = menuInput.nextInt();
        System.out.print("\n");

        switch (menuOption) {
            case 1:
                printTheatre(cinema, cinemaLength, cinemaWidth);
                break;
            case 2:

                System.out.println("Enter a row number:");
                rowPick = menuInput.nextInt() - 1;

                System.out.println("Enter a seat number in that row:");
                seatPick = menuInput.nextInt() - 1;
                while (seatSecured){
                    try {
                        if(fillSeat(cinema,rowPick,seatPick)){
                            purchasePrice = buyTicket(rowPick,cinemaLength,cinemaWidth);
                            System.out.println("Ticket Price:$" + purchasePrice + "\n");
                            break;
                        }
                        else{
                            System.out.println("That ticket has already been purchased!");
                            System.out.println("Enter a row number:");
                            rowPick = menuInput.nextInt() - 1;

                            System.out.println("Enter a seat number in that row:");
                            seatPick = menuInput.nextInt() - 1;
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.print("Wrong input!");
                        seatSecured = false;
                    }
                }
                System.out.print("\n");
                break;

            case 3:
                ticketCount(cinema,cinemaLength,cinemaWidth,rowPick);
                boxOffice(cinemaLength,cinemaWidth);
                break;
            case 0:
                quitProgram = false;
                menuInput.close();
                break;
        }
        return quitProgram;

    }

    private static void printTheatre(String[][] cinema, int cinemaLength, int cinemaWidth) {

        System.out.print("Cinema:\n  ");

        for (int i = 0; i < cinemaWidth; i++) {
            System.out.print(i + 1 + " ");
        }

        System.out.println();

        for (int i = 0; i < cinemaLength; i++) {
            for (int j = 0; j < cinemaWidth; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + " " + cinema[i][j]);
                } else {
                    System.out.print(cinema[i][j]);
                }
            }

            System.out.println();
        }
    }


    private static int buyTicket (int rowPick,int cinemaLength,int cinemaWidth) {

        int seatPrice = 0;
        int frontRows = (cinemaLength / 2) - 1;
        int backRows = (cinemaLength / 2) + 1;
        int seats = cinemaLength * cinemaWidth;

        if (seats <= 60) {
            // System.out.println("Ticket Price:" + "\n" + "$10" + "\n");
            seatPrice = 10;
        } else if (seats > 60 && rowPick <= frontRows) {
            // System.out.println("Ticket Price:" + "\n" + "$10" + "\n");
            seatPrice = 10;
        } else
            // System.out.println("Ticket Price:" + "\n" + "$8" + "\n");
            seatPrice = 8;

        return seatPrice;
    }

    private static void ticketCount (String[][] cinema,int cinemaLength,int cinemaWidth,int rowPick) {

        int tickets = 0;
        int currentSales = 0;
        int frontRows = (int)Math.floor(cinemaLength / 2);
        int backRows = Math.round(cinemaLength /2) + 1;

        int seatTotal = cinemaLength * cinemaWidth;


        for (int i = 0; i < cinemaLength; i++) {
            for (int j = 0; j < cinemaWidth; j++) {
                if(Objects.equals(cinema[i][j], "B ")){
                    tickets++;
                    currentSales += i >= cinemaLength/2 ? 8 : 10;
                }
            }
        }

        double percentSold = (double)(tickets * 100)/(double)seatTotal;
        String str = String.format("Percentage: %.2f", percentSold);

        System.out.print("Number of purchased tickets: " + tickets + "\n");
        System.out.println("Current income: $" + currentSales);
        System.out.println(str + "%");
    }





    private static boolean fillSeat(String[][] cinema,int rowPick, int seatPick) {

        boolean vacantSeat = true;

        if (cinema[rowPick][seatPick].equals("S ")) {
            cinema[rowPick][seatPick] = "B ";
            return vacantSeat;
        }
        else if (cinema[rowPick][seatPick].equals("B ")) {
            vacantSeat = false;
            return vacantSeat;
        }
        return vacantSeat;
    }


    private static void boxOffice(int cinemaLength, int cinemaWidth) {

        int seatPrice = 0;
        int frontRows = 0;
        int backRows = 0;

        //Small theatre to Large size theatre
        int seats = cinemaLength * cinemaWidth;
        int frontSeats = 0;
        int bkSeats = 0;
        int sales = 0;


        if (seats <= 60) {
            seatPrice = 10;
            sales = seats * seatPrice;
        }
        if (seats > 60 && seats % 2 != 0) {
            frontRows = (int)Math.floor(cinemaLength / 2);
            frontSeats = (frontRows * cinemaWidth) * 10;
            backRows = Math.round(cinemaLength /2) + 1;
            bkSeats = (backRows * cinemaWidth) * 8;
            sales = bkSeats  + frontSeats;
        }
        if (seats > 60 && seats % 2 == 0) {
            frontRows = (seats/2) * 10;
            backRows = (seats/2) * 8;
        }
        System.out.println("Total income: " + "$" + sales);
        // return String.valueOf(sales);
    }

    private static String[][] cinemaSeating(int cinemaLength, int cinemaWidth) {

        String[][] cinema = new String[cinemaLength][cinemaWidth];
        for (String[] row : cinema) {
            Arrays.fill(row,"S ");
        }
        return cinema;
    }


}