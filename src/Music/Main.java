package Music;
import java.util.Scanner;
import MusicCollection.MusicCollection;

public class Main {
    private static MusicCollection albumCollection;

    private static Scanner scanner;

    private static int getUserInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\u001B[31mIt is not a number. Try again: \u001B[0m");
            }
        }
    }

    private static double getUserDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\u001B[31mIt is not a number. Try again: \u001B[0m");
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MusicCollection trackCollection = new MusicCollection(50);

        System.out.println("Welcome to songs database!");
        while (true) {
            System.out.println("1 - Add tracks to collection");
            System.out.println("2 - Print track list");
            System.out.println("3 - Sort tracks by release year");
            System.out.println("4 - Search track by a phrase");
            System.out.println("5 - Search track by release year");
            System.out.println("6 - Remove a track from the collection");
            System.out.println("7 - Print detailed track");
            System.out.println("8 - Read tracks from a file");
            System.out.println("9 - Save tracks to a file");
            System.out.println("0 - Exit the program");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    inputItems(in, trackCollection);
                    break;
                case 2:
                    trackCollection.print();
                    break;
                case 3:
                    trackCollection.sort();
                    break;
                case 4:
                    searchByPhrase(in, trackCollection);
                    break;
                case 5:
                    searchByYear(in, trackCollection);
                    break;
                case 6:
                    trackCollection.remove(in, trackCollection);
                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Goodbye!");
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    public static void inputItems(Scanner in, MusicCollection trackCollection) {
        System.out.println("Enter track details (title, Band, year, length) or 'stop' to exit:");

        while (true) {
            System.out.print("Title: ");
            String title = in.nextLine();

            if (title.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Band: ");
            String band = in.nextLine();
            in.nextLine();

            System.out.print("Year: ");
            int year = in.nextInt();
            in.nextLine();

            System.out.print("Length: ");
            double songLength = in.nextInt();
            in.nextLine();

            Music track = new Music(title, band, year, songLength);
            trackCollection.add(track);
            System.out.println("Track added to the collection.");
        }
    }
    private static void search(Scanner in) {
        System.out.print("Enter a phrase to search for: ");
        String title = in.nextLine();
        MusicCollection.search(title);
    }
    private static void searchByYear() {
        System.out.print("Enter release year to search for albums: ");
        int year = getUserInt();
        in.nextLine(); // Consume newline character
        MusicCollection.searchByProperty(year);


      }

}