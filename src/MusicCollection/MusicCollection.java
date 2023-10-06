package MusicCollection;
import java.io.*;

import Music.Music;

import java.io.*;
import java.util.Arrays;

public class MusicCollection {
    private int count;
    private Music[] tracks;

    //Constructor
    public MusicCollection(int capacity) {
        tracks = new Music[capacity];
        count = 0;
    }


    public void add(Music music) {
        if (count < tracks.length) {
            tracks[count++] = music;
        } else {
            int newSize = tracks.length + 1;
            tracks = Arrays.copyOf(tracks, newSize);
            add(music);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index");
        } else {
            int newSize = tracks.length - 1;
            Music[] arr = new Music[newSize];
            System.arraycopy(tracks, 0, arr, 0, index);
            System.arraycopy(tracks, index + 1, arr, index, newSize - index);
            tracks = arr;
            count--;
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


    public void search(String phrase) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            Music track = tracks[i];
            if (track.getMusicDescription().toLowerCase().contains(phrase.toLowerCase())) {
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
        int i, j;
        boolean swapped;
        for (i = 0; i < count - 1; i++) {
            swapped = false;
            for (j = 0; j < count - i - 1; j++) {
                if (tracks[j].getYear() > tracks[j + 1].getYear()) {
                    swap(tracks, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void swap(Music[] tracks, int ind1, int ind2) {
        Music temp = tracks[ind1];
        tracks[ind1] = tracks[ind2];
        tracks[ind2] = temp;

    }


    public void searchByYear(int year) {
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

    private String getAllRecords() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < count; i++) {
            output.append(tracks[i].getFileRepresentation()).append("\n");
        }

        return output.toString();
    }


    public void saveToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(getAllRecords());

        bufferedWriter.close();
        System.out.println("Content successfully written to file.");

    }
    public void readFromFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null && !line.trim().isEmpty()) {
            add(Music.fromString(line));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

    }
}


