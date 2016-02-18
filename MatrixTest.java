import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MatrixTest{
	@Test
	public void createMatrix(){
		Matrix sample = new Matrix(3,3);
		Matrix resultedMatrix = new  Matrix(3,3);
		for(int i = 0 ; i < 3 ; i++){
			for(int  j = 0 ; j< 3 ;j++){
				resultedMatrix.insertValue(i,j,0);
			}
		}
		assertTrue(sample.isEqualTo(resultedMatrix));
	}

	@Test
	public void insertValue(){
		Matrix matrix1 = new Matrix(2,2);
		matrix1.insertValue(0,0,9);
		matrix1.insertValue(0,1,8);
		assertTrue(matrix1.isAtPosition(0,0,9));
		assertTrue(matrix1.isAtPosition(0,1,8));
	}

}