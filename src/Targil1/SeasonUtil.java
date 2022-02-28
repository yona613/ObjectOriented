package Targil1;

import java.util.Arrays;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }

    static String reportAll(Seasonable[] seasonables) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < seasonables.length - 1; i++) {
            strBuilder.append(seasonables[i].toString()).append("\n");
        }
        strBuilder.append(seasonables[seasonables.length - 1].toString());
        return strBuilder.toString();
    }
}
