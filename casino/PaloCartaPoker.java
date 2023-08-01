package casino;

public enum PaloCartaPoker {
    picas("Picas"),
    corazones("Corazones"),
    trebol("Trebol"),
    diamantes("Diamantes");

    private final String palo;

    PaloCartaPoker(String palo) {
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }
}
