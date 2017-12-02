package level1;

/**
 * 
 * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬을 입력받는 sumMatrix 함수를 완성하여 행렬 덧셈의 결과를 반환해 주세요.
 * 예를 들어 2x2 행렬인 A = ((1, 2), (2, 3)), B = ((3, 4), (5, 6)) 가 주어지면
 * , 같은 2x2 행렬인 ((4, 6), (7, 9))를 반환하면 됩니다.(어떠한 행렬에도 대응하는 함수를 완성해주세요.)
 * @author Justin
 *
 */
public class SumMatrix {

	int[][] sumMatrix(int[][] A, int[][] B) {
		int[][] answer = new int[A.length][A[0].length];

		for(int i=0; i < answer.length; i++){
			for(int j=0; j < answer[i].length; j++){
				
				answer[i][j] = A[i][j] + B[i][j];
				System.out.println("i["+i+"], j["+j+"]1 >> "+A[i][j]);
				System.out.println("i["+i+"], j["+j+"]2 >> "+B[i][j]);
				System.out.println("i["+i+"], j["+j+"]3 >> "+answer[i][j]);
				System.out.println("====");
			}
		}
		
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		SumMatrix c = new SumMatrix();
		int[][] A = { { 4, 3 }, { 20, 13 } };
		int[][] B = { { 5, 6 }, { 3, 5 } };
		int[][] answer = c.sumMatrix(A, B);
		if (answer[0][0] == 9 && answer[0][1] == 9 && 
				answer[1][0] == 23 && answer[1][1] == 18) {
			System.out.println("맞았습니다. 제출을 눌러 보세요");
		} else {
			System.out.println("틀렸습니다. 수정하는게 좋겠어요");
		}
	}
}
