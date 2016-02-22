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

	
	private int [] getRow(int noOfRow){
		int [] valuesInRow = new int [this.columns];
		for(int i = 0 ; i < this.columns ; i++){
			valuesInRow[i] = this.matrix[noOfRow][i];
		}
		return valuesInRow;
	}

	private int [] getColumn(int noOfColumn){
		int [] valuesInColumn = new int[this.rows];
		for(int  i = 0 ; i < this.rows ;i++){
			valuesInColumn[i] = this.matrix[i][noOfColumn];
		}
		return valuesInColumn;
	}

	private int getMultiplicationOf(int [] rowElements , int[] columnElements){
		int sum = 0 ;
		for(int i = 0 ; i < rowElements.length ;i++){
			sum += (rowElements[i] * columnElements [i]);
		}
		return sum;
	}

	private boolean isValidToMultiply(Matrix other){
		return this.rows < other.rows && this.columns > other.columns;
	}

	public Matrix multiplyWith(Matrix multiplier){
		if(this.isOfSameSize(multiplier) || this.isValidToMultiply(multiplier)){
			Matrix productMatrix = new Matrix(this.rows , multiplier.columns);
			for(int i = 0 ; i < this.rows ; i++){
				for(int j = 0 ; j < multiplier.columns ; j++){
					int [] row = this.getRow(i);
					int [] column = multiplier.getColumn(j);
					int resultedInt = getMultiplicationOf(row ,column);
					productMatrix.insertValue(i,j,resultedInt);
				}
			}
			return productMatrix;
		};
		return new Matrix(0,0);
	}

	private boolean isSquareMatrix(){
		return this.rows == this.columns;
	}

	public int getDeterminant(){
		if(isSquareMatrix()){
			if(this.rows != 2){};
			return (this.matrix[0][0]*this.matrix[1][1])- (this.matrix[0][1]*this.matrix[1][0]);
		}
		return 0;
	}



	public String toString(){
		String matrix = "\n";
		for(int i = 0 ; i < this.rows ; i++){
			String column = "";
			for(int j = 0 ; j < this.columns ; j++){
				column +="  "+ this.matrix[i][j];
			}
			matrix += column+"\n";
		}
		return matrix;
	}


};