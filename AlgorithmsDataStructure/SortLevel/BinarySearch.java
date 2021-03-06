public class BinarySearch {
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
	
	public boolean  GallopingSearch(int arr[], int N) {
		Left = 0;
		Right = arr.length-1;

		i = 1;
		index = (int)(Math.pow(2, i))-2;
		if(arr[index] == N)return true;
		while(arr[index] < N) {
			i++;
			index = (int)(Math.pow(2, i))-2;
			if(index < arr.length-1) {
				continue;
			} else {
				index = arr.length-1;
				break;
			}
		}
		Right = index;
		Left = (int) ((Math.pow(2, (i-1))-2)+1);
		while(processing == 0)Step(N);
		if(processing == 1) {
			processing = 0;
			return true;
		}
		processing = 0;
		return false;
	}
}
