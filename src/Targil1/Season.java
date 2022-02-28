package Targil1;

public enum Season {
    WINTER, SPRING, SUMMER, FALL;
    // TODO: Add auxiliary functions.

    public Season getNextSeason() {
        return Season.values()[((this.ordinal() + 1) % values().length)];
    }
}
