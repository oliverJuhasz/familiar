package familiar.domain.character.witcher.assist;

import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhysicalTable {

    public static final int LOWER_LIMIT = 2;
    public static final int UPPER_LIMIT = 13;
    public static final int HP_COLUMN = 1;
    public static final int STAMINA_COLUMN = 2;
    public static final int RECOVERY_COLUMN = 3;
    public static final int STUN_COLUMN = 4;
    private final Map<Integer, List<Integer>> physicalTableScores = new HashMap<>();
    CsvReader reader = new CsvReader(); //TODO: Bean

    @SneakyThrows
    public PhysicalTable() {
        fillValuesFromFile();
    }

    private void fillValuesFromFile() throws IOException {

        List<String[]> rawScores;
        rawScores = reader.getData("PhysicalTable");
        for (String[] line : rawScores) {
            physicalTableScores.put(Integer.valueOf(line[0]),
                    List.of(Integer.valueOf(line[1]), Integer.valueOf(line[1]),
                            Integer.valueOf(line[1]), Integer.valueOf(line[1])));
        }
    }

    private int calculateStatIndex(int bodyStat, int willStat) {
        int stat = (bodyStat + willStat) / LOWER_LIMIT;
        if (stat < LOWER_LIMIT) {
            stat = LOWER_LIMIT;
        } else if (stat > UPPER_LIMIT){
            stat = UPPER_LIMIT;
        }
        return stat;
    }

    public int getHealthPoint(int bodyStat, int willStat) {
        return physicalTableScores.get(calculateStatIndex(bodyStat, willStat)).get(HP_COLUMN);
    }

    public int getStamina(int bodyStat, int willStat) {
        return physicalTableScores.get(calculateStatIndex(bodyStat, willStat)).get(STAMINA_COLUMN);
    }

    public int getRecovery(int bodyStat, int willStat) {
        return physicalTableScores.get(calculateStatIndex(bodyStat, willStat)).get(RECOVERY_COLUMN);
    }

    public int getStun(int bodyStat, int willStat) {
        return physicalTableScores.get(calculateStatIndex(bodyStat, willStat)).get(STUN_COLUMN);
    }
}
