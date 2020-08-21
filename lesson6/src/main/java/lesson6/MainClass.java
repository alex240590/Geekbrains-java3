package lesson6;


import java.util.Arrays;

//В классе MainClass создаю два метода, которые необходимо протестировать

public class MainClass {

    
    public static void main(String[] args) {

    }


    public int[] checkArrayAndCopy(int[] arr1) throws RuntimeException{
        for (int i = arr1.length-1; i>=0; i--) {
            if (arr1[i]==4) {
                return Arrays.copyOfRange(arr1,i+1,arr1.length);
                }
            }
        throw new RuntimeException("array does not have four");
        }

    public boolean checkArrayForOneAndFour(int[] arr1){
        boolean checkOne = false;
        boolean checkFour = false;
        for (int i =0; i<arr1.length; i++) {
            if (arr1[i]==1){
                checkOne=true;
            }
            if (arr1[i]==4){
                checkFour=true;
            }
            if (arr1[i] !=1 && arr1[i] !=4){
                return false;
            }
        }
        return checkOne && checkFour;
    }


}


