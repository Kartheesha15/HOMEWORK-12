package batting.acs560.batting_analyzer;

import java.util.List;

public class HighestStrikeRateStrategy implements PlayerAnalysisStrategy {
    @Override
    public String analyze(List<Player> players) {
        double topStrikeRate = 0;
        String topStrikeRatePlayer = "";
        for (Player player : players) {
            if (player.getStrikeRate() > topStrikeRate) {
                topStrikeRate = player.getStrikeRate();
                topStrikeRatePlayer = player.getName();
            }
        }
        return "Highest Strike Rate: " + topStrikeRate + " by " + topStrikeRatePlayer;
    }
}
