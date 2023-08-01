package casino;

public enum ValorCartaPoker {
    dos("2"),
    tres("3"),
    cuatro("4"),
    cinco("5"),
    seis("6"),
    siete("7"),
    ocho("8"),
    nueve("9"),
    diez("10"),
    jota("11"),
    reina("12"),
    rey("13"),
    as("1");

    private final String valor;

    ValorCartaPoker(String value) {
        this.valor = value;
    }

    public String getValor() {
        return valor;
    }
}