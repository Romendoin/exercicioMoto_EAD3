package Test;

import org.junit.jupiter.api.*;
import Classes.Moto;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MotoTest {

    public Moto getMoto(){
        return new Moto("Yamaha");
    }

    @Test
    @DisplayName("Teste exception de aceleração com velocidade negativa")
    public void aceleraNegativo(){
        Moto moto = getMoto();
        Assertions.assertThrows(RuntimeException.class,() -> moto.acelera(-1));
    }

    @Test
    @DisplayName("Teste de aceleração e velocidade")
    public void velocidadeAceleração(){
        Moto moto = getMoto();
        moto.abastecer(15);
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, moto.getVelocidade()),
                () -> Assertions.assertDoesNotThrow(() -> moto.acelera(20)),
                () -> Assertions.assertEquals(20, moto.getVelocidade())
        );
    }

    @Test
    @DisplayName("Teste de velocidade máxima")
    public void velocidadeMaxima(){
        Moto moto = getMoto();
        moto.abastecer(30);
        moto.acelera(120);
        Assertions.assertAll(
                () -> Assertions.assertEquals(120, moto.getVelocidade()),
                () -> Assertions.assertDoesNotThrow(() -> moto.acelera(50)),
                () -> Assertions.assertEquals(150, moto.getVelocidade())
        );
    }

    @Test
    @DisplayName("Teste de Freio")
    public void velocidadeFreio(){
        Moto moto = getMoto();
        moto.abastecer(5);
        moto.acelera(100);
        Assertions.assertAll(
                () -> Assertions.assertEquals(100, moto.getVelocidade()),
                () -> Assertions.assertDoesNotThrow(() -> moto.freia(20)),
                () -> Assertions.assertEquals(80, moto.getVelocidade())
        );
    }

    @Test
    @DisplayName("Teste de freio parado")
    public void freioParado(){
        Moto moto = getMoto();
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, moto.getVelocidade()),
                () -> Assertions.assertDoesNotThrow(() -> moto.freia(30)),
                () -> Assertions.assertEquals(0, moto.getVelocidade())
        );
    }

    @Test
    @DisplayName("Teste abastecimento")
    public void abastecimento(){
        Moto moto = getMoto();
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, moto.getGasolina()),
                () -> Assertions.assertDoesNotThrow(() -> moto.abastecer(15)),
                () -> Assertions.assertEquals(15, moto.getGasolina())
        );
    }

    @Test
    @DisplayName("Teste abastecimento com tanque cheio")
    public void abastecimentoTanqueCheio(){
        Moto moto = getMoto();
        moto.abastecer(20);
        Assertions.assertAll(
                () -> Assertions.assertEquals(20, moto.getGasolina()),
                () -> Assertions.assertDoesNotThrow(() -> moto.abastecer(30)),
                () -> Assertions.assertEquals(30, moto.getGasolina())
        );
    }

    @Test
    @DisplayName("Teste exception abastecendo valor negativo")
    public void abastecerNegativo(){
        Moto moto = getMoto();
        Assertions.assertThrows(RuntimeException.class, () -> moto.abastecer(-10));
    }

    @Test
    @DisplayName("Teste quantidade de gasolina após acelerar")
    public void gosolinaAposAcelerar(){
        Moto moto = getMoto();
        moto.abastecer(10);
        Assertions.assertAll(
            () -> Assertions.assertEquals(10, moto.getGasolina()),
            () -> Assertions.assertDoesNotThrow(() -> moto.acelera(10)),
            () -> Assertions.assertEquals(9.9, moto.getGasolina())
        );
    }

    @Test
    @DisplayName("Teste Exception acelerar sem gasolina")
    public void acelerarSemGasolina(){
        Moto moto = getMoto();
        Assertions.assertThrows(RuntimeException.class, () -> moto.acelera(10));
    }
}
