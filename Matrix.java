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

	public boolean isEqualTo(Matrix givenMatrix){
		return Arrays.deepEquals(this.matrix,givenMatrix.matrix);
	}


	private boolean isOfSameSize(Matrix other){
		return this.columns == other.columns && this.rows == other.rows;
	}

	public Matrix addWith(Matrix addend){
		if(this.isOfSameSize(addend)){
			Matrix resultedMatrix = new Matrix(this.rows , this.columns);
			for(int i = 0 ; i < this.rows ;i++){
				for(int j = 0 ; j < this.columns ;j++){
					resultedMatrix.matrix[i][j] = this.matrix[i][j] + addend.matrix[i][j];
				}
			}
			return resultedMatrix;
		}
		return new Matrix(0,0);
	}

};