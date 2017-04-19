import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class Assignment1ArithmeticTest {

    private static final double EPSILON = 1E-3;

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void max_positive_negative_returns_positive() {
        assertMax(4.0, -5.0);
    }

    @Test
    public void max_positive_positive_returns_max_positive() {
        assertMax(5.0, 1.0);
    }

    @Test
    public void max_same_value_returns_value() {
        assertMax(2.5, 2.5);
    }

    private void assertMax(double left, double right) {
        assertThat("The max value of " + left + " and " + right + " should be " + left,
                Assignment1_7.max(left, right), equalTo(left));
    }

    @Test
    public void max_right_associative() {
        assertThat("The max value of 1.0 and 5.0 should be 5.0", Assignment1_7.max(1.0, 5.0), equalTo(5.0));
    }

    @Test
    public void abs_makes_positive() {
        assertThat("The absolute value of minus three should be three", Assignment1_7.abs(-3.0), equalTo(3.0));
    }

    @Test
    public void abs_remains_positive() {
        assertThat("The absolute value of three should be three", Assignment1_7.abs(3.0), equalTo(3.0));
    }

    @Test
    public void squared_positive() {
        assertThat("Three squared should be nine", Assignment1_7.squared(3.0), IsCloseTo.closeTo(9.0, EPSILON));
    }

    @Test
    public void squared_negative() {
        assertThat("Minus four squared should be sixteen", Assignment1_7.squared(-4.0), IsCloseTo.closeTo(16.0, EPSILON));
    }

    @Test
    public void distance_positive_positive() {
        assertThat("The distance of <2,3> to <3,3> should be one", Assignment1_7.distance(2.0, 3.0, 3.0, 3.0), IsCloseTo.closeTo(1.0, EPSILON));
    }

    @Test
    public void distance_positive_positive_half() {
        assertThat("The distance of <1,3> to <2.5,2.5> should be within boundaries", Assignment1_7.distance(1.0, 3.0, 2.5, 2.5), IsCloseTo.closeTo(1.581, EPSILON));
    }

    @Test
    public void distance_negative_positive() {
        assertThat("The distance of <-2,3> to <4,1> should be within boundaries", Assignment1_7.distance(-2.0, 3.0, 4.0, 1.0), IsCloseTo.closeTo(6.324, EPSILON));
    }

    @Test
    public void distance_negative_positive_small() {
        assertThat("The distance of <-2,3> to <1,4> should be within boundaries", Assignment1_7.distance(-2.0, 3.0, 1.0, 4.0), IsCloseTo.closeTo(3.162, EPSILON));
    }

}
