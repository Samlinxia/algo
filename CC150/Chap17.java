// set entire row and column of matrix to zero
class Chap17
{
	public static void setMatrixZero(int[][] matrix, int n)
	{
		int[] rows = new int[n];
		int[] columns = new int[n];
		//traveral all elements of matrix
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(matrix[i][j] == 0)
					{
						//coz array is initialized to zero, so must record the flag as non-zero number
						rows[i] = 1;
						columns[j] = 1;
					}
			}
		}
		
		//set the element to zero according to the recorded rows and columns
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(rows[i] == 1 || columns[j] == 1)
					{
						matrix[i][j] = 0;
					}
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
        Chap17.printArray(image, 5);  
          
        System.out.println("After rotating:");  
        Chap17.setMatrixZero(image, 5);  
		Chap17.printArray(image, 5); 
	}
}