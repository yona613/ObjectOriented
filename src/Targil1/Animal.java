package Targil1;

public abstract class Animal implements Seasonable, Comparable {
    protected int weight;
    private Season season;
    protected Color color;

    Animal(int weight, Season season, Color color) {
        this.weight = weight;
        this.season = season;
        this.color = color;
    }

    @Override
    /**
     * Change the season of the object
     */
    public void changeSeason() {
        this.season = this.season.getNextSeason();
    }

    @Override
    /**
     * Get current season of the object
     */
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Animal)
            return Integer.compareUnsigned(this.weight, ((Animal)o).weight);
        throw new IllegalArgumentException("o object not comparable");
    }
}
