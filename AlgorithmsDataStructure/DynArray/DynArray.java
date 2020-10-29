

public class DynArray<T> {
	public T[] array;
	public int count;
	public int capacity;
	Class clazz;

	public DynArray(Class clz) {
		clazz = clz;
		count = 0;
		makeArray(16);
	}

	public void display() {
		for (int i = 0; i < count; i++)
			System.out.print(this.array[i] + " ");
		System.out.println();
		System.out.println("capacity: " + array.length);
		System.out.println("count: " + this.count);
	}

	public int getCount(T[] array) {
		count = 0;
		int i = 0;
		try {
			while (this.array[i] != null) {
				i++;
				count++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return count;
		}

		return count;
	}

	public void makeArray(int new_capacity) {
		try {
			array = Arrays.copyOf(array, new_capacity);
		} catch (Exception e) {
			// TODO: handle exception
			array = (T[]) Array.newInstance(this.clazz, new_capacity);
		}
		count = getCount(this.array);
	}

	public T getItem(int index) {
		try {
			if (array[index] != null)
				return array[index];
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void append(T itm) {
		try {
			array[count] = itm;
			count++;
		} catch (Exception e) {
			// TODO: handle exception
			makeArray(array.length * 2);
			array[count] = itm;
			count++;
		}

	}

	public boolean checkCapacity() {
		// System.out.println((double)getCount(this.array)/this.array.length);
		if ((double) getCount(this.array) / this.array.length < 0.5)
			return true;
		return false;
	}

	public void insert(T itm, int index) {
		if (index < 0 || index > array.length)
			throw new ArrayIndexOutOfBoundsException();
		if (getCount(array) == array.length) {
			makeArray(this.array.length * 2);
		}
		int i = getCount(this.array);
		i += 1;
		if(i < index) array[index] = itm;
		else {
			while (i != index) {
				try {
					array[i] = array[i - 1];
				} catch (ArrayIndexOutOfBoundsException ex) {
					// TODO: handle exception
					// makeArray(this.array.length * 2);
				}
				i--;
			}	
		count++;
		array[index] = itm;
		}
	}

	public void remove(int index) {
		if (index < 0 || index > array.length)
			throw new ArrayIndexOutOfBoundsException();
		try {
			while (array[index] != null) {
				array[index] = array[index + 1];
				index++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			array[index] = null;
		}

		if (checkCapacity() && this.array.length > 16) {
			makeArray((int) ((int) this.array.length / 1.5));
		}

	}

}
