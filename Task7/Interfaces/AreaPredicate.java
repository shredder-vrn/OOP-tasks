package vsu.cs.Task7.Interfaces;

import vsu.cs.Task7.Area.Area;

@FunctionalInterface
public interface AreaPredicate {
    boolean test(Area area);
}