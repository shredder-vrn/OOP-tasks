package vsu.cs.Task5.Interfaces;

import vsu.cs.Task5.Area.Area;

@FunctionalInterface
public interface AreaPredicate {
    boolean test(Area area);
}