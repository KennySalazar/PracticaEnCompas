package casino;

public enum PaloCartaPoker {
    PICAS("Picas"),
    CORAZONES("Corazones"),
    TREBOL("Trebol"),
    DIAMANTES("Diamantes");

    private final String palo;

    PaloCartaPoker(String palo) {
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }
}
