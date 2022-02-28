package Targil1;

public class OliveTree extends Tree {


    OliveTree(int height, Season season) {
        // TODO: Implement.
        super(height, season, Color.GREEN);
    }

    private void updateLeaves() {
        switch (this.getCurrentSeason()) {
            case WINTER:
            case FALL: {
                this.height = this.height + 5;
                break;
            }
            case SPRING:
            case SUMMER: {
                this.height = this.height + 10;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Olive tree. " + ((this.getCurrentSeason().equals(Season.FALL)) ? "I give fruit. " : "") +
                String.format("My height is: %s and my color is: %s", this.height, this.leavesColor);
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        this.updateLeaves();
    }
}
