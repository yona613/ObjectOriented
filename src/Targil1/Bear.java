package Targil1;

public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight, season, Color.BROWN);
    }

    private void updateBearWeigth() {
        switch (this.getCurrentSeason()) {
            case WINTER: {
                this.weight = (int) (this.weight * 0.8f);
                break;
            }
            case SPRING: {
                this.weight = (int) (this.weight * 0.75f);
                break;
            }
            case SUMMER: {
                this.weight = (int) (this.weight * (4f/3));
                break;
            }
            case FALL: {
                this.weight = (int) (this.weight * 1.25f);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Bear." + (this.getCurrentSeason().equals(Season.WINTER) ? " I am sleeping." : "") + String.format(" My weight is: %s and my color is: %s", this.weight, this.color);
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        this.updateBearWeigth();
    }
}
