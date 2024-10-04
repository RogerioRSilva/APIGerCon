package br.com.gercon.gerenciador.contas;

import br.com.gercon.gerenciador.contas.model.Somar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Somartest {

    private Somar somar;

    @BeforeEach
    public void setUp(){
        somar = new Somar();
    }

    @Test
    public void testSomar(){
        int resultado = somar.somar(1, 1);
        assertEquals(2, resultado);
    }




}
