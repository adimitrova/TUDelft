import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class Assignment2_1Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void swap_empty() {
        expectedException.expect(IllegalArgumentException.class);
        Assignment2_1.swap(new int[]{});
    }

    @Test
    public void swap_two_elements() {
        int[] array = new int[]{1, 2};
        Assignment2_1.swap(array);
        assertThat("First two elements must be swapped", array, equalTo(new int[]{2, 1}));
    }

    @Test
    public void swap_many_elements() {
        int[] array = new int[]{5, 27, 91, 36, 2};
        Assignment2_1.swap(array);
        assertThat("First two elements must be swapped", array, equalTo(new int[]{27, 5, 91, 36, 2}));
    }

    @Test
    public void copy_should_return_different_array() {
        int[] array = new int[]{};
        assertThat("Array should be copied", Assignment2_1.copy(array), not(sameInstance(array)));
    }

    @Test
    public void copy_empty() {
        int[] array = new int[]{};
        assertThat("Array should be empty", Assignment2_1.copy(array), equalTo(new int[]{}));
    }

    @Test
    public void copy_many_elements() {
        int[] array = new int[]{6, 3, 7, 10, 52};
        assertThat("Values in array should be copied", Assignment2_1.copy(array), equalTo(new int[]{6, 3, 7, 10, 52}));
    }

    @Test
    public void rotate_empty() {
        expectedException.expect(IllegalArgumentException.class);
        Assignment2_1.rotate(new int[]{});
    }

    @Test
    public void rotate_once() {
        int[] array = new int[]{3, 6, 3, 9, 1, 0};
        Assignment2_1.rotate(array);
        assertThat("Values should be shifted one place to the right", array, equalTo(new int[]{0, 3, 6, 3, 9, 1}));
    }

    @Test
    public void rotate_twice() {
        int[] array = new int[]{3, 6, 3, 9, 1, 0};
        Assignment2_1.rotate(array);
        Assignment2_1.rotate(array);
        assertThat("Values should be shifted two places to the right", array, equalTo(new int[]{1, 0, 3, 6, 3, 9}));
    }

    @Test
    public void rotate_once_with_n() {
        int[] array = new int[]{3, 6, 3, 9, 1, 0};
        Assignment2_1.rotate(array, 1);
        assertThat("Values should be shifted one place to the right", array, equalTo(new int[]{0, 3, 6, 3, 9, 1}));
    }

    @Test
    public void rotate_thrice_with_n() {
        int[] array = new int[]{3, 6, 3, 9, 1, 0};
        Assignment2_1.rotate(array, 3);
        assertThat("Values should be shifted three places to the right", array, equalTo(new int[]{9, 1, 0, 3, 6, 3}));
    }

    @Test
    public void rotate_minus_one_with_n() {
        int[] array = new int[]{3, 6, 3, 9, 1, 0};
        expectedException.expect(IllegalArgumentException.class);
        Assignment2_1.rotate(array, -1);
    }

    @Test
    public void rotate_empty_with_n() {
        expectedException.expect(IllegalArgumentException.class);
        Assignment2_1.rotate(new int[]{}, 2);
    }

}
