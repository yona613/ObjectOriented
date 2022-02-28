package Targil1;

public class Caribou extends Animal {

    Caribou(int weight, Season season) {
        super(weight, season, null);
        this.updateCaribouColor();
    }

    private void updateCaribouColor() {
        switch (this.getCurrentSeason()) {
            case WINTER: {
                this.color = Color.WHITE;
                break;
            }
            case SPRING:
            case FALL:
            case SUMMER: {
                this.color = Color.BROWN;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Caribou:" + (this.getCurrentSeason().equals(Season.WINTER) ? " I am migrating south." : (this.getCurrentSeason().equals(Season.SUMMER)) ? " I am migrating north." : "") + " My weight is: " + this.weight + " and my color is: " + this.color;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        this.updateCaribouColor();
    }
}
