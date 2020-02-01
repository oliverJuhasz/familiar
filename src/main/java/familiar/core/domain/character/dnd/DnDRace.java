package familiar.core.domain.character.dnd;

public enum DnDRace {
    Human("Human"), Dwarf("Dwarf"), Elf("Elf");
    
    private String displaytext;
    
    private DnDRace(String displayText) {
        this.displaytext = displayText;
    }
}
