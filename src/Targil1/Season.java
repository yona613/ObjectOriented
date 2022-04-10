package Targil1;

public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    /**
     * Get next season in the year
     * @return next Season
     */
    public Season getNextSeason() {
        return Season.values()[((this.ordinal() + 1) % values().length)];
    }
}
