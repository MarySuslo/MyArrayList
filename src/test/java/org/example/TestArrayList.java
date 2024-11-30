package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import java.util.Arrays;
import junit.framework.Assert.*;
import junit.framework.TestSuite;


public class TestArrayList extends TestCase {

    public void testAdding(){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(9);

        array.add(2,1);
        array.add(4,8);

        Object[] newArr={3,5,1,7,8,9};

        assertEquals( Arrays.toString(newArr), Arrays.toString(array.toArray()));
        try {
            array.add(8,6);
        }catch(IndexOutOfBoundsException e){
            assertEquals( "Index: 8, Size: 6",e.getMessage());
        }

        /*
         Проверка ветки, когда элементов в массиве меньше, чем его рамер (после удаления лемнта коллекции)
         */
        Integer[] values2={1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> array2=new ArrayList<>(values2);
        array2.remove(Integer.valueOf(9));
        array2.add(10);
        Object[] reArr={1,2,3,4,5,6,7,8,10};

        assertEquals( Arrays.toString(reArr), Arrays.toString(array2.toArray()));

        Integer[] values3={1,2,3,4,6,7,8,9};
        ArrayList<Integer> array3=new ArrayList<>(values3);
        array3.remove(3);
        array3.add(3,5);
        Object[] reArr2={1,2,3,5,6,7,8,9};

        assertEquals( Arrays.toString(reArr2), Arrays.toString(array3.toArray()));

    }

    public void testSize(){
        ArrayList<Integer> array=new ArrayList<>();
        for(int i=0;i<1000;i++)
            array.add((int)(Math.random()*1000));
        assertEquals(1000,array.size());
    }

    public void testIndexOf(){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(9);

        assertEquals(2,array.indexOf(7));
        assertEquals(-1,array.indexOf(6));
    }

    public void testGet(){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(9);

        assertEquals(Integer.valueOf(5),array.get(1));
        try {
            array.get(5);
        }catch(IndexOutOfBoundsException e){
            assertEquals( "Index: 5, Size: 4",e.getMessage());
        }
    }

    public void testSet(){
        Integer[] values={1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> array=new ArrayList<>(values);


        array.set(3,8);
        array.set(7,5);


        Object[] setArr={1,2,3,8,5,6,7,5,9};
        assertEquals( Arrays.toString(setArr), Arrays.toString(array.toArray()));

    }

    public void testClear(){
        ArrayList<Integer> array=new ArrayList<>();
        for(int i=0;i<10000;i++)
            array.add((int)(Math.random()*10000));

        array.clear();

        Object[] nullArr=new Object[10000];

        assertEquals( Arrays.toString(nullArr), Arrays.toString(array.toArray()));
    }

    public void testRemoveToIndex(){
        Integer[] values={1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> array=new ArrayList<>(values);
        array.remove(6);
        Object[] newArr={1,2,3,4,5,6,8,9,null};

        assertEquals( Arrays.toString(newArr), Arrays.toString(array.toArray()));

    }

    public void testRemoveToElement(){
        Integer[] values={1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> array=new ArrayList<>(values);
        array.remove(Integer.valueOf(6));
        Object[] newArr={1,2,3,4,5,7,8,9,null};

        assertEquals( Arrays.toString(newArr), Arrays.toString(array.toArray()));

        array.add(10);
        Object[] reArr={1,2,3,4,5,7,8,9,10};

        assertEquals( Arrays.toString(reArr), Arrays.toString(array.toArray()));

    }

    public void testSort(){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(7);
        array.add(5);
        array.add(6);
        array.add(3);
        array.add(9);

        QuickSorting.quickSort(array,0,array.size()-1);
        Object[] sortArr={3,5,6,7,9};
        assertEquals( Arrays.toString(sortArr), Arrays.toString(array.toArray()));

    }

}

