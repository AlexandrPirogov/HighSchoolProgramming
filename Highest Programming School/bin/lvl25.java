
public class Level1 {

	

	static boolean TransformTransform(int A[], int N) {
		int [] B = funcS(A, N);
		B = funcS(B, N);
		
		int summ = 0;
		for (int i = 0;i < N; i++)summ+=B[i];
		if(summ%2==0)return true;
		return false;
	}
	
	static int[] funcS(int A[], int N) {
		int k;
		int[] B = new int[N];
		if(N == 1) {
			B[0] = A[0];
			return B;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				k=i+j;
				B[N-i-1] = findMax(A,j,k);
			}
		}
		return B;
	}
	
	
	static int findMax(int A[], int j, int k) {
		int tmpMax = 0;
		for (int i = j; i < k; i++) {
			if (A[i] > tmpMax)tmpMax = A[i];
		}
		return tmpMax;
	}
}
