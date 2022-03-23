import LISP.Funciones;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class FuncionesTest {
    private final Funciones cc = new Funciones();

    @Test
    void SET() {
        cc.SETQ("NAME", "VALUE");
    }

}
