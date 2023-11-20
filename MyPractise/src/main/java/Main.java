import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Write the season of the year: ");
        Scanner scanner = new Scanner(System.in);
        String sea = scanner.nextLine();
        sea = sea.toUpperCase();
        switch (sea) {
            case "WINTER" :
                System.out.println(Season.WINTER.getSeasons());
                break;
            case "SPRING" :
                System.out.println(Season.SPRING.getSeasons());
                break;
            case "SUMMER" :
                System.out.println(Season.SUMMER.getSeasons());
                break;
            case "AUTUMN" :
                System.out.println(Season.AUTUMN.getSeasons());
                break;
            default:
                System.out.println("Not correct Season. Try Again :) ");
                break;
        }
    }
}