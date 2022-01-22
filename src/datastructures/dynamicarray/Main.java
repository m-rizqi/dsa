package datastructures.dynamicarray;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(-5);
        dynamicArray.add(44);
        dynamicArray.add(9);
        dynamicArray.add(23);
        dynamicArray.add(52);
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.isEmpty());
        dynamicArray.set(2,2);
        System.out.println(dynamicArray);
        dynamicArray.clear();
        System.out.println(dynamicArray.size());
        dynamicArray.add(2);
        dynamicArray.add(23);
        dynamicArray.add(7);
        dynamicArray.add(9);
        dynamicArray.removeAt(1);
        System.out.println(dynamicArray.indexOf(9));
        dynamicArray.remove(45);
        System.out.println(dynamicArray.contains(23));
    }
}
