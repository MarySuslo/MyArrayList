package org.example;

public class QuickSorting {
    /**
     * Основная часть сортировки. Деление сортирумого массива (подмассива) на две части
     * @param arr - сортируемый массив (подмассив)
     * @param start - левая граница подмассива
     * @param end - правая граница подмассива
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(ArrayList<T > arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    /**
     * сортировка элементов подмассива
     * @param arr
     * @param start
     * @param end
     * @return
     * @param <T>
     */
    private static <T extends Comparable<T>> int partition(ArrayList<T > arr, int start, int end){
        T pivot = arr.get(end);

        for(int i=start; i<end; i++){
            if(arr.get(i).compareTo(pivot)<0){
                T temp= arr.get(start);
                arr.set(start,arr.get(i));
                arr.set(i,temp);
                start++;
            }
        }

        T temp = arr.get(start);
        arr.set(start, pivot);
        arr.set(end ,temp);

        return start;
    }
}

