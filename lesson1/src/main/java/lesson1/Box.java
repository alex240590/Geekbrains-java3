package lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> box = new ArrayList<T>();

    public float getWeight() {
        float weightOfBox = 0.0f;
        for (T fruit : box) {
            weightOfBox += fruit.getWeight();
        }
        return weightOfBox;
    }

    public  boolean compare(Box another) {
        return Math.abs(this.getWeight()-another.getWeight())<0.001;
    }

    public void addFruitToBox(T fruit){
        box.add(fruit);
    }

    public void moveToNewBox (Box<T> another) {
        another.box.addAll(this.box);
        this.box.clear();
    }
}
