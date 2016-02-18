import java.util.Arrays;
class Matrix{
	private int rows;
	private int columns;
	private int [][] matrix;
	
	public Matrix(int noOfRows , int noOfColmns){
		this.rows = noOfRows;
		this.columns = noOfColmns;
		this.matrix = new int[noOfRows][noOfColmns];
	};

	public void insertValue(int positionOfRow , int positionOfColumn , int value){
		this.matrix[positionOfRow][positionOfColumn] = value;
	}

	public boolean isAtPosition(int positionOfRow , int positionOfColumn ,int value){
		return this.matrix[positionOfRow][positionOfColumn] == value;
	}

};