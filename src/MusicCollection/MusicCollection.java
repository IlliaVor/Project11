package MusicCollection;
import java.io.*;

import Music.Music;

public class MusicCollection {
    private int count;
    private Music[] tracks;

    //Constructor
    public MusicCollection() {
        count = 0;
    }

    private void resize(int newCapacity) {
        Music[] newTracks = new Music[newCapacity];

        if (count >= 0 && tracks != null)
            System.arraycopy(tracks, 0, newTracks, 0, count);

        tracks = newTracks;
    }


    public void add(Music newTrack) {
        if (tracks == null)
            resize(1);
        else if (count >= tracks.length)
            resize(tracks.length * 2);
        tracks[count] = newTrack;
        count++;
    }


    public void remove(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                tracks[i] = tracks[i + 1];
            }
            count--;
            if (count <= tracks.length / 2)
                resize(tracks.length / 2);
        } else {
            System.out.println("Invalid index");
        }
    }


    public void printOne(int index) {
        if (index >= 0 && index < count) {
            System.out.println(tracks[index].getMusicDescription());
        } else {
            System.out.println("Invalid index.");
        }
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println("Track " + (i + 1) + ":");
            System.out.println(tracks[i].getMusicDescription());
            System.out.println();
        }
    }


    public void printList() {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + tracks[i].getTitle());
        }
    }

    //Method to search
    public void search(String phrase) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (tracks[i].getTitle().toLowerCase().contains(phrase.toLowerCase()) ||
                    tracks[i].getBand().toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("Matching:");
                System.out.println(tracks[i].getMusicDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Track not found.");
        }
    }


    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (tracks[j].getYear() > tracks[j + 1].getYear()) {
                    swap(tracks, j, j + 1);
                    // Swap albums[j] and albums[j+1]
                    //MusicAlbum temp = albums[j];
                    //albums[j] = albums[j + 1];
                    //albums[j + 1] = temp;
                }
            }
        }
    }
    public static void swap(Music[] tracks,int ind1, int ind2 ) {
        Music temp = tracks[ind1];
        tracks[ind1] = tracks[ind2 ];
        tracks[ind2 ] = temp;

    }


    public void searchByProperty(int year) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (tracks[i].getYear() == year) {
                System.out.println("Matching: ");
                System.out.println(tracks[i].getMusicDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("nothing found ");
        }
    }

    private String getAll() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < count; i++) {
            output.append(tracks[i].getMusicDescription()).append("\n");
        }

        return output.toString();
    }


    public void saveToFile(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(getAll());

            bufferedWriter.close();
            System.out.println("Content has been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


    public void readFromFile(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
