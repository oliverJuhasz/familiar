package familiar.service.assist;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandToHandTable {

    public static final int UPPER_LIMIT = 13;
    public static final int PUNCH_COLUMN = 0;
    public static final int KICK_COLUMN = 1;
    private final Map<Integer, List<String>> handToHandScores = new HashMap<>();
    CsvReader reader = new CsvReader(); //TODO: Bean

    @SneakyThrows
    public HandToHandTable() {
        fillValuesFromFile();
    }

    private void fillValuesFromFile() throws IOException {
        List<String[]> rawScores;
        rawScores = reader.getData("HandToHandTable");
        for (String[] line : rawScores) {
            handToHandScores.put(Integer.valueOf(line[0]),
                    List.of(line[1], line[1]));
        }
    }

    public String getPunchDamage(int bodyStat) {
        return bodyStat > UPPER_LIMIT ?
                handToHandScores.get(UPPER_LIMIT).get(PUNCH_COLUMN) :
                handToHandScores.get(bodyStat).get(PUNCH_COLUMN);
    }

    public String getKickDamage(int bodyStat) {
        return bodyStat > UPPER_LIMIT ?
                handToHandScores.get(UPPER_LIMIT).get(KICK_COLUMN) :
                handToHandScores.get(bodyStat).get(KICK_COLUMN);
    }
}
