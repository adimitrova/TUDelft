import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Assignment2_2Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void max_empty() {
        assertThat("Empty array must have a max of MIN_VALUE", Assignment2_2.max(new int[]{}), equalTo(Integer.MIN_VALUE));
    }

    @Test
    public void max_one_element() {
        assertThat("Single value in array must be the maximum", Assignment2_2.max(new int[]{5}), equalTo(5));
    }

    @Test
    public void max_many_elements() {
        assertThat("Maximum from many values must be correct", Assignment2_2.max(new int[]{3, 6, -1, -10, 16}), equalTo(16));
    }

    @Test
    public void index_empty() {
        assertThat("Empy array should return index -1", Assignment2_2.index(new int[]{}, 5), equalTo(-1));
    }

    @Test
    public void index_found() {
        assertThat("Should return index of value in array", Assignment2_2.index(new int[]{3, 6, 5, 1}, 5), equalTo(2));
    }

    @Test
    public void index_first_value() {
        assertThat("Should return index of the first value in array", Assignment2_2.index(new int[]{3, 6, 1, 5, 3, 5}, 5), equalTo(3));
    }

    @Test
    public void index_not_found() {
        assertThat("Should return -1 if value is not found in array", Assignment2_2.index(new int[]{3, 6, 1, 5, 3, 5}, 7), equalTo(-1));
    }

    @Test
    public void contains_empty() {
        assertThat("Empy array should not contain value", Assignment2_2.contains(new int[]{}, 5), equalTo(false));
    }

    @Test
    public void contains_found() {
        assertThat("Should contain value in array", Assignment2_2.contains(new int[]{3, 6, 5, 1}, 5), equalTo(true));
    }

    @Test
    public void contains_first_value() {
        assertThat("Should contain value in array with duplicates", Assignment2_2.contains(new int[]{3, 6, 1, 5, 3, 5}, 5), equalTo(true));
    }

    @Test
    public void contains_not_found() {
        assertThat("Should not contain value in array", Assignment2_2.contains(new int[]{3, 6, 1, 5, 3, 5}, 7), equalTo(false));
    }

    @Test
    public void isPrime_low_number() {
        expectedException.expect(IllegalArgumentException.class);
        Assignment2_2.isPrime(-1);
    }

    @Test
    public void isPrime_small_number_success() {
        assertThat("5 is a prime", Assignment2_2.isPrime(5), equalTo(true));
    }

    @Test
    public void isPrime_large_number_success() {
        assertThat("379 is a prime", Assignment2_2.isPrime(379), equalTo(true));
    }

    @Test
    public void isPrime_small_number_failure() {
        assertThat("9 is not a prime", Assignment2_2.isPrime(9), equalTo(false));
    }

    @Test
    public void isPrime_large_number_failure() {
        assertThat("380 is not a prime", Assignment2_2.isPrime(380), equalTo(false));
    }

    @Test
    public void countPrimes_empty() {
        assertThat("Empty array has no primes", Assignment2_2.countPrimes(new int[]{}), equalTo(0));
    }

    @Test
    public void countPrimes_many_elements() {
        assertThat("Big array must have some primes", Assignment2_2.countPrimes(new int[]{167, 173, 179, 181, 191, 31, 36, 76, 89}), equalTo(7));
    }

    @Test
    public void primesUpTo_small_number() {
        assertThat("There are some primes below 8", Assignment2_2.primesUpTo(8), equalTo(new int[]{2, 3, 5, 7}));
    }

    @Test
    public void primesUpTo_big_number() {
        assertThat("There are some primes below 17", Assignment2_2.primesUpTo(17), equalTo(new int[]{2, 3, 5, 7, 11, 13}));
    }

    @Test
    public void primesIn_empty() {
        assertThat("Empty array has no primes", Assignment2_2.primesIn(new int[]{}), equalTo(new int[]{}));
    }

    @Test
    public void primesIn_small() {
        assertThat("There are some primes in this array", Assignment2_2.primesIn(new int[]{167, 173, 179, 12, 191, 31, 36, 76, 89}), equalTo(new int[]{167, 173, 179, 191, 31, 89}));
    }

}
