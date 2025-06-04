package vsu.cs.Task9.Interfaces;

import vsu.cs.Task9.Area.Area;

@FunctionalInterface
public interface AreaPredicate {
    boolean test(Area area);
}