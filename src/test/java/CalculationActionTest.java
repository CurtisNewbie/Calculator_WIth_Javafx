import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.CalculationAction;

public class CalculationActionTest {

    @DisplayName("Testing calculation result")
    @Test
    void calculationTest() {
	assertTrue("30.0".equals(CalculationAction.parseQuery("1 + 5 * 4 / 2 * 2 + 4 * 6")));
    }

}
