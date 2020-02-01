package familiar.core.domain.character.dnd.item;

import java.time.LocalDateTime;

public abstract class DnDItem {
    private long id;
    private LocalDateTime created;
    private String name;
    private String description;
    private double value;
    private double weight;
}
