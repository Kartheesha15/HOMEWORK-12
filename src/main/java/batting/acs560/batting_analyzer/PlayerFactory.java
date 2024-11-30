package batting.acs560.batting_analyzer;

public class PlayerFactory {
    public Player createPlayer(String name, String team, int matches, int innings, int notouts, int runs, double average, double strikeRate) {
        return new Player(name, team, matches, innings, notouts, runs, average, strikeRate);
    }
}
