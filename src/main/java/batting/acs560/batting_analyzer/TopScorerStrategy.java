package batting.acs560.batting_analyzer;

import java.util.List;

public class TopScorerStrategy implements PlayerAnalysisStrategy {
    @Override
    public String analyze(List<Player> players) {
        int topScorerRuns = 0;
        String topScorer = "";
        for (Player player : players) {
            if (player.getRuns() > topScorerRuns) {
                topScorerRuns = player.getRuns();
                topScorer = player.getName();
            }
        }
        return "Most Runs: " + topScorerRuns + " by " + topScorer;
    }
}
