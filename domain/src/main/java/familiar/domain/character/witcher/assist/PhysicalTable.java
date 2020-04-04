package familiar.domain.character.witcher.assist;

import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhysicalTable {

    private final Map<Integer, List<Integer>> physicalTableScores = new HashMap<>();

    @SneakyThrows
    public PhysicalTable() {
        fillValuesFromFile();
    }

    private void fillValuesFromFile() throws IOException {
        CsvReader reader = new CsvReader();
        List<String[]> rawScores;
        rawScores = reader.getData("PhysicalTable");
        for (String[] line : rawScores) {
            physicalTableScores.put(Integer.valueOf(line[0]),
                    List.of(Integer.valueOf(line[1]), Integer.valueOf(line[1]),
                            Integer.valueOf(line[1]), Integer.valueOf(line[1])));
        }
    }

    private int bodyPlusWillRoundedDown(int bodyStat, int willStat) {
        int stat = (bodyStat + willStat) /2;
        if (stat < 2) {
            stat = 2;
        } else if (stat > 13){
            stat = 13;
        }
        return stat;
    }

    public int getHealthPoint(int bodyStat, int willStat) {
        return physicalTableScores.get(bodyPlusWillRoundedDown(bodyStat, willStat)).get(1);
    }

    public int getStamina(int bodyStat, int willStat) {
        return physicalTableScores.get(bodyPlusWillRoundedDown(bodyStat, willStat)).get(2);
    }

    public int getRecovery(int bodyStat, int willStat) {
        return physicalTableScores.get(bodyPlusWillRoundedDown(bodyStat, willStat)).get(3);
    }

    public int getStun(int bodyStat, int willStat) {
        return physicalTableScores.get(bodyPlusWillRoundedDown(bodyStat, willStat)).get(4);
    }
}
