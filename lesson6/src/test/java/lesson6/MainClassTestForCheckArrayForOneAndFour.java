package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//В этом классе тестирую метод из MainClass на наличие единицы и четверки в массиве

@RunWith(Parameterized.class)
public class MainClassTestForCheckArrayForOneAndFour {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5,6},false},
                {new int[]{1,2,3,4,5},false},
                {new int[]{1,1,4,4},true},
                {new int[]{1,1,1,1},false},
                {new int[]{4,4,4,4},false},
        });
    }

    int[] array;
    boolean expected;

    public MainClassTestForCheckArrayForOneAndFour(int[] array, boolean expected){
        this.array=array;
        this.expected=expected;
    }

    @Test
    public void checkArrayAndCopyTest() {
        MainClass obj = new MainClass();
        Assert.assertEquals(expected, obj.checkArrayForOneAndFour(array));
    }
}
