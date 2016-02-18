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

	@Test
	public void add_matrices_of_3_by_3(){
		Matrix addend1 = new Matrix(3,3);
		Matrix addend2 = new Matrix(3,3);
		for(int i = 0 ; i < 3 ;i++){
			for(int j = 0 ;  j < 3 ; j++){
				addend1.insertValue(i,j,(i+j));
			}
			addend2.insertValue(i,i,1);
		}
		Matrix sum = addend1.addWith(addend2);
		Matrix sumShouldbe = new Matrix(3,3);
		sumShouldbe.insertValue(0,0,1);
		sumShouldbe.insertValue(0,1,1);
		sumShouldbe.insertValue(0,2,2);
		sumShouldbe.insertValue(1,0,1);
		sumShouldbe.insertValue(1,1,3);
		sumShouldbe.insertValue(1,2,3);
		sumShouldbe.insertValue(2,0,2);
		sumShouldbe.insertValue(2,1,3);
		sumShouldbe.insertValue(2,2,5);
		assertTrue(sum.isEqualTo(sumShouldbe));
 	}

 	@Test
	public void add_matrix_of_different_sizes(){
		Matrix addend1 = new Matrix(0,3);
		Matrix addend2 = new Matrix(3,9);
		Matrix sum = addend1.addWith(addend2);
		Matrix sumShouldbe = new Matrix(0,0);
		assertTrue(sum.isEqualTo(sumShouldbe));
 	}

}