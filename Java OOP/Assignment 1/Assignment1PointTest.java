import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class Assignment1PointTest {

    private static final double ONE_X = 3.0;

    private static final double ONE_Y = 5.0;

    private static final double OTHER_X = 7.0;

    private static final double OTHER_Y = 9.0;

    private Point one;

    private Point other;

    private Point same_one;

    @Before
    public void setUp() {
        one = new Point(ONE_X, ONE_Y);
        other = new Point(OTHER_X, OTHER_Y);
        same_one = new Point(ONE_X, ONE_Y);
    }

    @Test
    public void getX() {
        assertThat("getX should return the x coordinate", one.getX(), equalTo(ONE_X));
    }

    @Test
    public void getY() {
        assertThat("getY should return the y coordinate", one.getY(), equalTo(ONE_Y));
    }

    @Test
    public void equals_same_point_succesful() {
        assertTrue("An object should be equal to itself", one.equals(one));
    }

    @Test
    public void equals_other_point_failure() {
        assertFalse("Different objects with different attributes should not be equal", one.equals(other));
    }

    @Test
    public void equals_other_point_succesful() {
        assertTrue("Different objects with same attributes should be equal", one.equals(same_one));
    }

    @Test
    public void equals_null_failure() {
        assertFalse("Null should not be equal to an object", one.equals(null));
    }

    @Test
    public void toString_returns_correct_format() {
        assertThat("toString should return the correct format", one.toString(), equalTo("<Point(" + ONE_X + ", " + ONE_Y + ")>"));
    }

    @Test
    public void equals_String_failure() {
        assertFalse("Two objects of different classes should not be equal", one.equals("<Point(" + ONE_X + ", " + ONE_Y + ")>"));
    }

    @Test
    public void translate() {
        one.translate(OTHER_X - ONE_X, OTHER_Y - ONE_Y);
        assertThat("The x coordinate of the point is not translated correctly", one.getX(), equalTo(OTHER_X));
        assertThat("The y coordinate of the point is not translated correctly", one.getY(), equalTo(OTHER_Y));
    }

    @Test
    public void distance() {
        assertThat("Distance of two points is incorrect", one.distance(other), IsCloseTo.closeTo(5.65685424949238, 1E-9));
    }

    @Test
    public void equals_does_not_use_tostring() {
        AtomicBoolean called = new AtomicBoolean(false);

        class PointMock extends Point {

            public PointMock(double x, double y) {
                super(x, y);
            }

            @Override
            public String toString() {
                called.set(true);
                return super.toString();
            }

        }

        assertTrue("Same points should be equal", new PointMock(ONE_X, ONE_Y).equals(new PointMock(ONE_X, ONE_Y)));
        assertFalse("The equals method should not be using toString for comparison", called.get());
    }

}
