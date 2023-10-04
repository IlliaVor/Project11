package Music;
import java.util.Scanner;
import MusicCollection.MusicCollection;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MusicCollection trackCollection = new MusicCollection(50);

        System.out.println("Welcome to 'The Sopranos' episode database!");
        while (true) {
            System.out.println("\nChoose an option to proceed:");
            System.out.println("1 - Add an episode to the collection");
            System.out.println("2 - Print all episodes");
            System.out.println("3 - Print details of a single episode");
            System.out.println("4 - Sort episodes by episode number");
            System.out.println("5 - Search episodes by title or year");
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
                    printSingleEpisode(in, trackCollection);
                    break;
                case 4:
                    trackCollection.sort();
                    System.out.println("Episodes sorted by episode number.");
                    trackCollection.print();
                    break;
                case 5:
                    search(in, trackCollection);
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
        System.out.println("Enter episode details (title, season, episode number, year) or 'stop' to exit:");

        while (true) {
            System.out.print("Title: ");
            String title = in.nextLine();

            if (title.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Band: ");
            String band = in.nextInt();
            in.nextLine();

            System.out.print("Year: ");
            int episodeNumber = in.nextInt();
            in.nextLine();

            System.out.print("Length: ");
            double songLength = in.nextInt();
            in.nextLine();

            Music episode = new Music(title, band, episodeNumber, year);
            episodeCollection.add(episode);
            System.out.println("Episode added to the collection.");
        }
    }

}

