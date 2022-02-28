package Targil1;

public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;
    // TODO: Add auxiliary fields and functions.

    Tree(int height, Season season, Color leavesColor){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
    }

    @Override
    public void changeSeason() {
        this.season = this.season.getNextSeason();
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Tree)
            return Integer.compareUnsigned(this.height, ((Tree)o).height);
        throw new IllegalArgumentException("o object not comparable");
    }
}
