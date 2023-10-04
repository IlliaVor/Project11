package Music;

public class Music {
    private String title;
    private String band;
    private int year;
    private double songLength;


    public Music(String title, String band, int year, double songLength ) {
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

    public double getsongLength() {
        return songLength;
    }

    public void setPrice(double songLength) {
        this.songLength = songLength;
    }


    public int calculateAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }


    public String getMusicDescription() {
        return "Title: " + title + "\nBand: " + band + "\nYear: " + year + "\nSong length in minutes: " + songLength;
    }
}

