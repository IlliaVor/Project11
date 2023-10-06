package Music;
import MusicCollection.MusicCollection;
import Music.Music;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    private static int getUserInt() {
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Try again");
            }
        }
    }

    private static double getUserDouble() {
        while (true) {
            try {
                return in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Try again.");
            }
        }
    }

    public static void main(String[] args) {
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
                    inputItems(trackCollection);
                    break;
                case 2:
                    trackCollection.printList();
                    break;
                case 3:
                    trackCollection.sort();
                    trackCollection.printList();
                    break;
                case 4:
                    search(trackCollection);
                    break;
                case 5:
                    searchByYear(trackCollection);
                    break;
                case 6:
                    removeItem(trackCollection);
                    break;
                case 7:
                    trackCollection.print();
                    break;
                case 8:
                    readFromFile(trackCollection);
                    break;
                case 9:
                    saveToFile(trackCollection);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void inputItems(MusicCollection trackCollection) {
        System.out.println("Enter track details (title, Band, year, length) or 'stop' to exit:");

        while (true) {
            System.out.print("Title: ");
            String title = in.nextLine();

            if (title.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Band: ");
            String band = in.nextLine();


            System.out.print("Year: ");
            int year = in.nextInt();
            in.nextLine();

            System.out.print("Length: ");
            double songLength = in.nextDouble();
            in.nextLine();

            Music track = new Music(title, band, year, songLength);
            trackCollection.add(track);
            System.out.println("Track added to the collection.");
        }
    }

    private static void search(MusicCollection trackCollection) {
        System.out.print("Enter a phrase to search for: ");
        String title = in.nextLine();
        trackCollection.search(title);
    }

    private static void searchByYear(MusicCollection trackCollection) {
        System.out.print("Enter release year: ");
        int year = getUserInt();
        in.nextLine();
        trackCollection.searchByYear(year);
    }

    private static void removeItem(MusicCollection trackCollection) {
        System.out.print("Enter index: ");
        int index = getUserInt();
        in.nextLine();
        trackCollection.remove(index);
    }

    private static void readFromFile(MusicCollection trackCollection) {
        System.out.print("Enter file name to read from: ");
        String fileName = in.nextLine();
        try {
            trackCollection.readFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Something went wrong during reading from file: " + e.getMessage());
        }
    }

    private static void saveToFile(MusicCollection trackCollection) {
        System.out.print("Enter file name to save to: ");
        String fileName = in.nextLine();
        try {
            trackCollection.saveToFile(fileName);
        } catch (IOException e) {
            System.out.println("Something went wrong during writing to file: " + e.getMessage());
        }
    }

}