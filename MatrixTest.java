import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MatrixTest{
	@Test
	public void createMatrix(){
		Matrix sample = new Matrix(3,3);
		for(int i = 0 ; i < 3 ;i++){
			for(int j = 0 ; j < 3 ; j++){
				assertEquals(0,sample.Matrix[i][j]);
			}
		}
	}
}