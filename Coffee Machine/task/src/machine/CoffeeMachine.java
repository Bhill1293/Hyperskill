package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeCount = scanner.nextInt();

        ///Amount of each thing per cup MILK,WATER,BEANS
        int milk = 50;
        int water = 200;
        int coffeeBeans = 15;

        servingAmount(coffeeCount);
    }

    private static void servingAmount(int coffeeCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int currentWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int currentMilk = scanner.nextInt();
        System.out.println("Write how grams of coffee beans the coffee machine has:");
        int currentCb = scanner.nextInt();
        int possibleCups = Math.min(Math.min((currentWater / 200), (currentMilk / 50)), (currentCb / 15));

        int remWater = 0;
        int remMilk = 0;
        int remCb = 0;

//        while (coffeeCount > 0) {
//            remWater = currentWater - 200;
//            remMilk = currentMilk - 50;
//            remCb = currentCb - 15;
//            coffeeCount--;

//            if(remWater < 200 && remMilk < 50 && remCb < 15 ) {
//                System.out.println("No, I can make only " + possibleCups + "cup(s) of coffee\n");
//                return;
//            }
//            if(remWater >= 200 && remMilk >= 50 && remCb >= 15) {
//                System.out.println("Yes, I can make that amount of coffee (and even" + possibleCups + ") more than that \n");
//                return;
//            }
//            else
//                System.out.println("Yes, I can make that amount of coffee\n");
//            return;
            if (coffeeCount > possibleCups)
                System.out.println("No, I can make only " + possibleCups +" cup(s) of coffee");
            return;
            if(coffeeCount == possibleCups)
                System.out.println("Yes, I can make that amount of coffee");
            return;
            else
                System.out.println("Yes, I can make that amount of coffee (and even " + possibleCups + " more than that)");
    }

        ////Costs per CUP
//        int waterPerCup = coffeeCount * 200;
//        int milkPerCup = coffeeCount * 50;
//        int beansPerCup = coffeeCount * 15;

        ////CUPS LEFT OVER

        }
//    }
//    private static void ingredientCalculator(int coffeeCount){
//        int water = 200;
//        int milk = 50;
//        int coffeeBeans = 15;
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("For" + coffeeCount+  "cups of coffee you will need:");
//        System.out.println(coffeeCount * water + " ml of water");
//        System.out.println(coffeeCount * milk + " ml of milk");
//        System.out.println(coffeeCount * coffeeBeans + " g of coffee beans");
//    }
//    private static void cfPrompt(){
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");
//    }

