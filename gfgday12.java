{

   
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        
        int[][] psum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                psum[i][j] = mat[i][j];
                if (i > 0) psum[i][j] += psum[i - 1][j];
                if (j > 0) psum[i][j] += psum[i][j - 1];
                if (i > 0 && j > 0) psum[i][j] -= psum[i - 1][j - 1];
            }
        }

        int count = 0;

        
        for (int size = 1; size <= Math.min(n, m); size++) {
            for (int i = size - 1; i < n; i++) {
                for (int j = size - 1; j < m; j++) {

                  
                    int sum = psum[i][j];
                    if (i - size >= 0) sum -= psum[i - size][j];
                    if (j - size >= 0) sum -= psum[i][j - size];
                    if (i - size >= 0 && j - size >= 0) sum += psum[i - size][j - size];

                    if (sum == x) count++;
                }
            }
        }

        return count;
    }
}