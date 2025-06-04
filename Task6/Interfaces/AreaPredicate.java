package vsu.cs.Task6.Interfaces;

import vsu.cs.Task6.Area.Area;

@FunctionalInterface
public interface AreaPredicate {
    boolean test(Area area);
}