package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake1() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result = App.take(numbers1,2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertThat(result).isEqualTo(list);
        // END
    }
    @Test
    void testTake2(){
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = App.take(numbers2,8);
        List<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(3);
        list2.add(10);
        assertThat(result2).isEqualTo(list2);
    }
}
