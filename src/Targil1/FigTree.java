package Targil1;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height, season, null);
        //Get color of tree by current season
        switch (this.getCurrentSeason()) {
            case WINTER: {
                this.leavesColor = null;
                break;
            }
            case SPRING:
                this.leavesColor = Color.GREEN;
                break;
            case SUMMER: {
                this.leavesColor = Color.GREEN;
                break;
            }
            case FALL: {
                this.leavesColor = Color.YELLOW;
                break;
            }
        }
    }

    /**
     * Update leaves of tree by current season
     */
    private void updateLeaves() {
        switch (this.getCurrentSeason()) {
            case WINTER: {
                this.height = this.height + 20;
                this.leavesColor = null;
                break;
            }
            case SPRING: {
                this.height = this.height + 30;
                this.leavesColor = Color.GREEN;
                break;
            }
            case SUMMER: {
                this.height = this.height + 30;
                break;
            }
            case FALL: {
                this.height = this.height + 20;
                this.leavesColor = Color.YELLOW;
                break;
            }
        }
    }

    @Override
    /**
     * Print data of Tree
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fig tree.");
        switch (this.getCurrentSeason()) {
            case WINTER: {
                stringBuilder.append(String.format(" My height is: %s", this.height));
                stringBuilder.append(" and I have no leaves");
                break;
            }
            case SPRING:
                stringBuilder.append(String.format(" My height is: %s", this.height));
                stringBuilder.append(String.format(" and my color is: %s", this.leavesColor));
                break;
            case SUMMER:
                stringBuilder.append(String.format(" I give fruit. My height is: %s", this.height));
                stringBuilder.append(String.format(" and my color is: %s", this.leavesColor));
                break;
            case FALL: {
                stringBuilder.append(String.format(" My height is: %s", this.height));
                stringBuilder.append(String.format(" and my color is: %s", this.leavesColor));
                break;
            }
        }
        return stringBuilder.toString();
    }

        @Override
        public void changeSeason () {
            super.changeSeason();
            this.updateLeaves();
        }
    }
