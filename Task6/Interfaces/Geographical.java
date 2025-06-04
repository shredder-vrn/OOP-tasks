package vsu.cs.Task6.Interfaces;

public interface Geographical {
    double calculateDistance(int latitude, int longitude);
    boolean isWithinRange(int latitude, int longitude, int range);


}