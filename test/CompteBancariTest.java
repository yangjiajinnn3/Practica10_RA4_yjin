import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteBancariTest {
    @Test
    public void testIngressar() {
        CompteBancari compte = new CompteBancari("Joan", "ES12345", 100);
        compte.ingressar(50);
        assertEquals(150, compte.getSaldo());
    }
}
