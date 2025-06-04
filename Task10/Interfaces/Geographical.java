package vsu.cs.Task10.Interfaces;

public interface Geographical {
    double calculateDistance(int latitude, int longitude);
    boolean isWithinRange(int latitude, int longitude, int range);


}