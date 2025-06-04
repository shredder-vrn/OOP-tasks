package vsu.cs.Task10.Interfaces;

import vsu.cs.Task10.Area.Area;

@FunctionalInterface
public interface AreaPredicate {
    boolean test(Area area);
}