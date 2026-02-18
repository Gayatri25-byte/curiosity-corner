class Solution {

    public static long inversionCount(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return sortAndCount(arr, 0, arr.length - 1);
    }

    private static long sortAndCount(int[] arr, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            count += sortAndCount(arr, left, mid);
            count += sortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }
}
