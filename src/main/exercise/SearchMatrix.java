/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        int mid = 0;

        int left = 0;
        int right = maxRow;

        while (left < right) {
            if (target < matrix[left][0] || target > matrix[right][maxCol]) return false ;
            else if (target == matrix[left][0] || target == matrix[right][maxCol]) return true ;
            else {
                mid = (right - left)/2 + left;
                if (target == matrix[mid][0] || target == matrix[mid][maxCol]) return true;
                else if (target < matrix[mid][0]) right = mid-1 < 0 ? 0 : mid-1;
                else if (target > matrix[mid][maxCol]) left = mid+1;
                else {
                    left = mid;
                    break;
                }
            }
        }

        // find target in a specified row

        for (int i = 0; i <= maxCol; i++) {
            if (matrix[left][i] == target) return true;
        }



        return false;

    }
}
