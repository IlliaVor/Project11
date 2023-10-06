package Music;

import java.util.Locale;

public class Music {
    private String title;
    private String band;
    private int year;
    private double songLength;

    public Music() {
    }

    public Music(String title, String band, int year, double songLength) {
        this.title = title;
        this.band = band;
        this.year = year;
        this.songLength = songLength;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSongLength() {
        return songLength;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }


    public int calculateAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }


    public String getMusicDescription() {
        return "Title: " + title + "\nBand: " + band + "\nYear: " + year + "\nSong length in minutes: " + songLength;
    }

    public String getFileRepresentation() {
        return String.format(Locale.US,"title: %s; band: %s; year: %d; length: %.2f", title, band, year, songLength);
    }

    public static Music fromString(String s) {
        if (s == null || s.trim().isEmpty()) {
            return handleInvalidFileRecord(s);
        }
        String[] parts = s.split("; ");
        if (parts.length != 4) {
            return handleInvalidFileRecord(s);
        }
        Music music = new Music();
        music.setTitle(parts[0].split(": ")[1]);
        music.setBand(parts[1].split(": ")[1]);
        music.setYear(Integer.parseInt(parts[2].split(": ")[1]));
        music.setSongLength(Double.parseDouble(parts[3].split(": ")[1]));
        return music;
    }

    private static Music handleInvalidFileRecord(String s) {
        System.out.println("invalid file record: " + s);
        return null;
    }
}

