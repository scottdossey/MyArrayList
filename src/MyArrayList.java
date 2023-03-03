import java.util.AbstractList;
import java.util.Collection;

// this is going to be our own implementation of the Java ArrayList class.. 
// the way ArrayList works is that it uses an array to store the data and it 
//will actually have to resize and copy that array 
// when it runs out of space 
public class MyArrayList<T> extends AbstractList<T> {
	private static final int INITIAL_SIZE=16;
	
	private Object[] backingArray= new Object[INITIAL_SIZE];
	
	//We need a variable that tracks how full our array is.
	private int fillSize=0;

	@Override
	public int size() {
		
		return fillSize;
	}
	
	@Override
	public T get(int index) {
		if((index <0) || (index >= fillSize)) {
			throw new IndexOutOfBoundsException();
		}
		return (T)backingArray[index];
	}
	
	@Override
	public T set(int index, T value) {
		if((index <0) || (index >= fillSize)) {
			throw new IndexOutOfBoundsException();
		}
		T oldValue = (T)backingArray[index];
		backingArray[index] = value;
		return oldValue;
	}
	
	@Override 
	public void add(int index, T value) {
		if((index <0) || (index > fillSize)) { //Must be > not >=
			throw new IndexOutOfBoundsException();
		}
		
		//Okay, we need to now add a new value in two steps:
		//1. We have to make sure we have space for the value in
		//   our backingArray, and if not, somehow make space.
		if(fillSize+1 >= backingArray.length) {
			//We don't have enough room
			//We need to do something.
			//We have to allocate a bigger array...
			//let's our double our allocation size.
			int newArrayLength = backingArray.length * 2;
			Object[] newArray = new Object[newArrayLength];
			//We are going to copy everything over that we currently have.
			for(int i=0; i<backingArray.length; ++i) {
				newArray[i] = backingArray[i];
			}
			backingArray = newArray;
		}
		
				
		//2. We have to insert the item in the correct place
		//   in the backingArray, moving everything after it 
		//   over by one position.
	    //       a) move everything over by one first
		//       b) set the value
		for(int i=fillSize-1; i>= index; --i) {
			backingArray[i+1] = backingArray[i];
		}
		backingArray[index] = value;
		fillSize += 1; 				
	}
	
	@Override
	public T remove(int index) {
		if((index <0) || (index >= fillSize)) { 
			throw new IndexOutOfBoundsException();
		}
		T item = (T)backingArray[index];
		
		for(int i=index; i< fillSize; ++i) {
			backingArray[i] = backingArray[i+1];
		}
		fillSize -= 1;
		
		return item;		
	}
}	




