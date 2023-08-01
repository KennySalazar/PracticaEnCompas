package casino;

public class Carta {
    ValorCartaPoker valor;
    PaloCartaPoker palo;

    public Carta(ValorCartaPoker valor, PaloCartaPoker palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getNombre() {
        return (this.valor + " de " + this.palo);
    }

    public String getValor() {
        return valor.getValor();
    }

}

