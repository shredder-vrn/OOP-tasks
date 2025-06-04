package vsu.cs.Task1.Area;

public class Area {
    private String name;
    private int latitude;
    private int longitude;

    public Area(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Родительский";
    }
}



