public class GallopingSearch {
	static int i = 1;
	static int index = (int)(Math.pow(2, i)-2);
	
	public static boolean  GallopingSearch(int arr[], int N) {
		if(arr[index] == N)return true;
		if(arr[index] < N) {
			i++;
			index = (int)(Math.pow(2, i))-2;
			if(index < arr.length-1) {
				GallopingSearch(arr, N);
			} else {
				index = arr.length-1;
			}
		}
		int Right = index;
		int Left = (int) ((Math.pow(2, (i-1))-2)+1);
		BinarySearch b = new BinarySearch(arr);
		b.Right = Right;
		b.Left = Left;
		while(b.processing == 0)b.Step(N);
		if(b.processing == 1)return true;
		return false;
	}
}

 class BinarySearch {
	public int Left, Right;
	private int[] numbers;
	public int processing;
	public int index;
	public int i = 1;

	public BinarySearch(int arr[]) {
		numbers = arr;
		Left = 0;
		Right = arr.length-1;
		processing = 0;
		index = 1;
		index = (int)(Math.pow(2, i))-2;;
	}

	public void Step( int N) {
		if(processing != 0)return;
		int middle = (Right+Left)/2;
		if(numbers[middle] == N)processing = 1;
		if(numbers[middle] > N) 
			Right = middle-1;
		if(numbers[middle] < N) 
			Left = middle+1;
		if(Left == Right || Math.abs(Left - Right) == 1) {
			if(numbers[Left] == N || numbers[Math.abs(Right)] == N)processing = 1;
			else processing = -1;
			return;
		}
	}
	
	public int GetResult() {
		return processing;
	}
	

}

