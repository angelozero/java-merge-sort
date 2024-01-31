import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] randomOrderList = {5, 1, 6, 2, 3, 4};

        System.out.println("Random List: " + Arrays.toString(randomOrderList));

        mergeSort(randomOrderList, randomOrderList.length);

        System.out.println("Sorted List: " + Arrays.toString(randomOrderList));
    }

    private static void mergeSort(int[] numList, int listLength) {
        if (listLength < 2) {
            return;
        }
        int mid = listLength / 2;
        int[] l = new int[mid];
        int[] r = new int[listLength - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = numList[i];
        }
        for (int i = mid; i < listLength; i++) {
            r[i - mid] = numList[i];
        }
        mergeSort(l, mid);
        mergeSort(r, listLength - mid);

        merge(numList, l, r, mid, listLength - mid);
    }

    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}

