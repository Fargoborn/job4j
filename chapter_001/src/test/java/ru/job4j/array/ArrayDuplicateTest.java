package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate  removeDuplicate = new ArrayDuplicate();
        String[] array = new String[] {"папа", "мама", "петруха", "чапай", "папа", "баба", "папа", "чапай"};
        String[] result = removeDuplicate.remove(array);
        String[] expect = new String[] {"папа", "мама", "петруха", "чапай", "баба"};
        assertThat(result, is(expect));
        }
    }