//rotate matrix with 90 degree
class Chap16{
	//use extra buffer return, iterate every element of original matrix and copy to the new matrix
	public static int[][] rotateMatrix(int[][] matrix, int n)
	{	
		int[][] newMatrix = new int[n][n];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				newMatrix[j][n-1-i] = matrix[i][j];
			}
		}
		return newMatrix;
	}
	
	//do not use extra buffer, but more complex algorithm
	public static void rotateMatrix2(int[][] matrix, int n)
	{
		int buffer;
		for(int i = 0; i< n/2; i++)
		{
			for(int j = i; j< n-1-i; j++)
			{
				//left-bottom -> buffer
				buffer = matrix[n-1-j][i];
				//right-bottom -> left-bottom
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				//right-top -> right-bottom
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				//left-top -> right-top
				matrix[j][n-1-i] = matrix[i][j];
				//buffer -> left-top
				matrix[i][j] = buffer;
			}
		}
	}
	
	 public static void printArray(int[][] image, int n)  
    {  
        for (int i = 0; i < n; i++)  
        {  
            for (int j = 0; j < n; j++)  
                System.out.print(image[i][j] + " ");  
            System.out.println();  
        }  
    } 

	public static void main(String[] args)
	{
		int[][] image = new int[][]{{1,2,3,4,5}, {5,6,7,8,9}, {9,0,1,2,5}, {3,4,5,6,7}, {3,2,1,4,6}};  
		System.out.println("Before rotating:");  
        Chap16.printArray(image, 5);  
          
        System.out.println("After rotating:");  
        Chap16.rotateMatrix2(image, 5);  
		Chap16.printArray(image, 5); 

	
	}
}