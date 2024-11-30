package batting.acs560.batting_analyzer;

import java.util.List;

public class HighestAverageStrategy implements PlayerAnalysisStrategy {
    @Override
    public String analyze(List<Player> players) {
        double topAverage = 0;
        String topAveragePlayer = "";
        for (Player player : players) {
            if (player.getAverage() > topAverage) {
                topAverage = player.getAverage();
                topAveragePlayer = player.getName();
            }
        }
        return "Highest Average: " + topAverage + " by " + topAveragePlayer;
    }
}
