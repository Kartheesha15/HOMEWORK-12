package batting.acs560.batting_analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String csvFile = "batting stats.csv";
        String outputFile = "analysis.txt";

        List<Player> players = readCsvFile(csvFile);
        analyzeData(players);
        writeAnalysisToFile(players, outputFile);
    }

    private static List<Player> readCsvFile(String csvFile) {
        List<Player> players = new ArrayList<>();
        PlayerFactory playerFactory = new PlayerFactory(); // Create factory

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Player player = playerFactory.createPlayer(
                        values[0],
                        values[1],
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4]),
                        Integer.parseInt(values[5]),
                        Double.parseDouble(values[6]),
                        Double.parseDouble(values[7])
                );
                players.add(player);
            }
        } catch (IOException e) {
            System.out.println("Unable to read csv file");
        }

        return players;
    }

    private static void analyzeData(List<Player> players) {
        // Create strategies
        PlayerAnalysisStrategy topScorerStrategy = new TopScorerStrategy();
        PlayerAnalysisStrategy highestAverageStrategy = new HighestAverageStrategy();
        PlayerAnalysisStrategy highestStrikeRateStrategy = new HighestStrikeRateStrategy();

        // Apply strategies and print results
        System.out.println(topScorerStrategy.analyze(players));
        System.out.println(highestAverageStrategy.analyze(players));
        System.out.println(highestStrikeRateStrategy.analyze(players));
    }

    private static void writeAnalysisToFile(List<Player> players, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Player Stats Analysis\n");
            writer.write("------------------------\n");

            for (Player player : players) {
                writer.write(player.toString() + "\n");
            }

            // Use strategies again to write analysis
            PlayerAnalysisStrategy topScorerStrategy = new TopScorerStrategy();
            PlayerAnalysisStrategy highestAverageStrategy = new HighestAverageStrategy();
            PlayerAnalysisStrategy highestStrikeRateStrategy = new HighestStrikeRateStrategy();

            writer.write("\nHighest Stats\n");
            writer.write("-------------\n");
            writer.write(topScorerStrategy.analyze(players) + "\n");
            writer.write(highestAverageStrategy.analyze(players) + "\n");
            writer.write(highestStrikeRateStrategy.analyze(players) + "\n");
        } catch (IOException e) {
            System.out.println("output file not found");
        }
    }
}
