package Classes;

public class Moto {
    private final String modelo;
    private double velocidade;
    private double gasolina;

    private static final int VEL_FINAL = 150;
    private static final int TAMANHO_TANQUE = 30;


    public Moto(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
        this.gasolina = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void acelera(int velocidade){
        if (velocidade<0) throw new RuntimeException("Velocidade deve ser positivo");
        if (this.gasolina == 0) throw new RuntimeException("Moto sem gasolina disponível");

        this.gasolina -= (velocidade * 0.01);
        if (this.velocidade + velocidade>VEL_FINAL) this.velocidade = VEL_FINAL;
        else this.velocidade += velocidade;
    }

    public void freia(int velocidade){
        if (this.velocidade - velocidade<0) this.velocidade = 0;
        else this.velocidade -= velocidade;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void abastecer(double gasolina){
        if (gasolina<0) throw new RuntimeException("Quantidade de gasolina não pode ser negativa");
        if (this.gasolina + gasolina > TAMANHO_TANQUE) this.gasolina = TAMANHO_TANQUE;
        else this.gasolina += gasolina;
    }

}
