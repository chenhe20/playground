/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class FindMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int i= 0, j = 0;
        int length = 0;
        int end1 = 0, end2 = 0;
        int endAt = 1;

        if (m+n == 0) return 0;
        if (m+n == 1) return m == 1 ? nums1[0] : nums2[0];

      while (length <= (m+n)/2) {

          if (i > m-1) {
              j ++;
              endAt = 2;
              continue;
          }

          if (j > n-1) {
              i ++;
              endAt = 1;
              continue;
          }

          if (nums1[i] < nums2[j]) {
              i ++;
              endAt = 1;
          } else {
              j ++;
              endAt = 2;
          }

          ++ length;

          if (length == (m+n)/2) {
              end1 = endAt == 1 ? nums1[i-1] : nums2[j-1];
          }

          if (length == (m+n)/2) {
              end2 = endAt == 1 ? nums1[i-1] : nums2[j-1];
          }
      }

      // If total length is even
      if ((m+n)%2 == 0) {
          return (end1 + end2)/2;
      } else {
          return end1;
      }
    }

    public static void main(String[] args) {
        double medianSortedArrays = new FindMedianSortedArray().findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2,4,6,7,8});
        System.out.println(medianSortedArrays);
    }

    public static <T> int isUnique(T a, T b, T c) {
        if (a == b && a == c) {
            return 3;
        } else if (a != b && a != c && b != c) {
            return 1;
        } else return 2;
    }
}
