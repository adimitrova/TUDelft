import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Assignment1CircleTest {

    private static final double ONE_X = 3.0;

    private static final double ONE_Y = 5.0;

    private static final double OTHER_X = 7.0;

    private static final double OTHER_Y = 9.0;

    private static final double ONE_RADIUS = 3.0;

    private static final double OTHER_RADIUS = 1.5;

    private static final double EPSILON = 1E-9;

    private Point onePoint;

    private Point otherPoint;

    private Circle one;

    private Circle other;

    private Circle same_one;

    @Before
    public void setUp() {
        onePoint = new Point(ONE_X, ONE_Y);
        otherPoint = new Point(OTHER_X, OTHER_Y);
        one = new Circle(onePoint, ONE_RADIUS);
        other = new Circle(otherPoint, OTHER_RADIUS);
        same_one = new Circle(onePoint, ONE_RADIUS);
    }

    @Test
    public void get_center() {
        assertThat("getCenter should return the center", one.getCenter(), equalTo(onePoint));
    }

    @Test
    public void get_radius() {
        assertThat("getRadius should return the radius", one.getRadius(), IsCloseTo.closeTo(ONE_RADIUS, EPSILON));
    }

    @Test
    public void get_surface() {
        assertThat("surface should return the calculated surface", one.surface(), IsCloseTo.closeTo(28.274333882308138, EPSILON));
    }

    @Test
    public void translate() {
        one.translate(OTHER_X - ONE_X, OTHER_Y - ONE_Y);
        assertThat("The x coordinate of the point is not translated correctly", one.getCenter().getX(), equalTo(OTHER_X));
        assertThat("The y coordinate of the point is not translated correctly", one.getCenter().getY(), equalTo(OTHER_Y));
    }

    @Test
    public void translate_delegates_to_Point_translate() {
        AtomicBoolean called = new AtomicBoolean(false);

        class PointMock extends Point {

            public PointMock(double x, double y) {
                super(x, y);
            }

            @Override
            public void translate(double dx, double dy) {
                called.set(true);
                super.translate(dx, dy);
            }
        }

        new Circle(new PointMock(ONE_X, ONE_Y), ONE_RADIUS).translate(ONE_X, ONE_Y);
        assertTrue("The equals method should delegate equals on attributes", called.get());
    }

    @Test
    public void periphery() {
        assertThat("periphery should return the calculated periphery", one.periphery(), IsCloseTo.closeTo(18.84955592153876, EPSILON));
    }

    @Test
    public void overlappingWith_same_Circle() {
        assertTrue("overlappingWith same Circle should be true", one.overlappingWith(one));
    }

    @Test
    public void overlappingWith_other_failure() {
        assertFalse("overlappingWith other Circle should be false", one.overlappingWith(other));
    }

    @Test
    public void overlappingWith_other_success() {
        one.translate(OTHER_X - ONE_X - ONE_RADIUS, OTHER_Y - ONE_Y - ONE_RADIUS);
        assertTrue("overlappingWith same Circle should be true", one.overlappingWith(other));
    }

    @Test
    public void equals_same_Circle_succesful() {
        assertTrue("An object should be equal to itself", one.equals(one));
    }

    @Test
    public void equals_other_Circle_failure() {
        assertFalse("Different circles with different points should not be equal", one.equals(other));
    }

    @Test
    public void equals_other_Circle_succesful() {
        assertTrue("Different circles with same attributes should be equal", one.equals(same_one));
    }

    @Test
    public void equals_other_radius_failure() {
        Circle biggerCircle = new Circle(onePoint, OTHER_RADIUS);
        assertFalse("Different circles with different radius should not be equal", one.equals(biggerCircle));
    }

    @Test
    public void equals_null_failure() {
        assertFalse("Null should not be equal to an object", one.equals(null));
    }

    @Test
    public void toString_returns_correct_format() {
        assertThat("toString should return the correct format", one.toString(), equalTo("<Circle(<Point(" + ONE_X + ", " + ONE_Y + ")>, " + ONE_RADIUS + ")>"));
    }

    @Test
    public void equals_String_failure() {
        assertFalse("Two objects of different classes should not be equal", one.equals("<Circle(<Point(" + ONE_X + ", " + ONE_Y + ")>, " + ONE_RADIUS + ")>"));
    }

    @Test
    public void equals_does_not_use_tostring() {
        AtomicBoolean called = new AtomicBoolean(false);

        class CircleMock extends Circle {

            public CircleMock(Point point, double radius) {
                super(point, radius);
            }

            @Override
            public String toString() {
                called.set(true);
                return super.toString();
            }

        }

        assertTrue("Same Circles should be equal", new CircleMock(new Point(ONE_X, ONE_Y), ONE_RADIUS).equals(new CircleMock(new Point(ONE_X, ONE_Y), ONE_RADIUS)));
        assertFalse("The equals method should not be using toString for comparison", called.get());
    }

    @Test
    public void equals_delegates_to_equals() {
        AtomicBoolean called = new AtomicBoolean(false);

        class PointMock extends Point {

            public PointMock(double x, double y) {
                super(x, y);
            }

            @Override
            public boolean equals(Object other) {
                called.set(true);
                return super.equals(other);
            }
        }

        assertTrue("Same Circles should be equal", new Circle(new PointMock(ONE_X, ONE_Y), ONE_RADIUS).equals(new Circle(new PointMock(ONE_X, ONE_Y), ONE_RADIUS)));
        assertTrue("The equals method should delegate equals on attributes", called.get());
    }
}
