package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//В этом классе тестирую метод из MainClass на наличие четверки и копирование в другой массив

@RunWith(Parameterized.class)
public class MainClassTestForCheckArrayAndCopy {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{1,2,3,4,5,6},new int[]{5,6}},
            {new int[]{1,2,3,4,5},new int[]{5}},
            {new int[]{1,2,3,4},new int[]{}}
        });
    }

    int[] array;
    int[] arrayExpected;

    public MainClassTestForCheckArrayAndCopy(int[] array, int[]arrayExpected){
        this.array=array;
        this.arrayExpected=arrayExpected;
    }

    @Test
    public void checkArrayAndCopyTest() {
        MainClass obj = new MainClass();
        Assert.assertArrayEquals(arrayExpected, obj.checkArrayAndCopy(array));
    }

}
