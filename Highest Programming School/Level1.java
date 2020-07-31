
public class Level1 {
	
	/* Первые попытки решения задачи оказались неудачными, так как подзабыл, как 
	работает рекурсия и пытался запихнуть всё в один метод.
	Для решения задачи решил разбить на подзадачи: вычисление факториала
	и нахождения первой цифры.	
	*/
	
	static int squirrel(int N) {
		int tmp = fac(N);
		while (tmp/10 != 0) {
			tmp /= 10;
		}
		return tmp;
	}
	
	static int fac(int N) {
		if (N == 0) return 1;		
		return N = N * (fac(N - 1));
	}
}
