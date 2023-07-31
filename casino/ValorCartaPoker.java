package casino;

public enum ValorCartaPoker {
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SIETE("7"),
    OCHO("8"),
    NUEVE("9"),
    DIEZ("10"),
    JOTA("J"),
    REINA("Q"),
    REY("K"),
    AS("A");

    private final String valor;

    ValorCartaPoker(String value) {
        this.valor = value;
    }

    public String getValor() {
        return valor;
    }
}