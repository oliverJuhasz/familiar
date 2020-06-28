package familiar.service.assist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiceServiceTest {

    @InjectMocks
    private DiceService underTest;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @ValueSource(strings = {"153", "", "d8", "<>~", "153+", "1d8+", "2d8+4-1d5+"})
    @DisplayName("Invalid expressions should result in error.")
    public void test1(String input) {
        assertThrows(IllegalArgumentException.class, () -> underTest.evaluateDiceExpression(input));
    }

}
