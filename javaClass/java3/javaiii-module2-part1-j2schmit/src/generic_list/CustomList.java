package generic_list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {
	Object[] elementData = new Object[10];
	private int size = 0;

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More
	 * formally, returns <tt>true</tt> if and only if this list contains at least
	 * one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		boolean match = false;
		for (Object i: elementData) {
			if (i == o) {
				match = true;
				break;
			}
		}
		return match;
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 */
	@Override
	public boolean add(E e) {
		elementData[size++] = e;
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present. If the list does not contain the element, it is unchanged. More
	 * formally, removes the element with the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt> (if
	 * such an element exists). Returns <tt>true</tt> if this list contained the
	 * specified element (or equivalently, if this list changed as a result of the
	 * call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return <tt>true</tt> if this list contained the specified element
	 */
	@Override
	public boolean remove(Object o) {
		Object[] newArray = new Object[10];
		boolean foundIt = false;
		for (int i = 0;i<size;i++) {
			if ((elementData[i] != o) || foundIt) {
				newArray[i] = elementData[i];
			} else if (!foundIt) {
				foundIt = true;
			}
			if (foundIt) {
				size--;
				elementData = newArray;
			}
		}
		return foundIt;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	@Override
	public void clear() {
		for (Object o: elementData) {
			this.remove(o);
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException{
		E element = (E) elementData[index];
		return element;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E set(int index, E element) {
		E originalElement = (E) elementData[index];
		elementData[index] = element;
		return originalElement;
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException{
		if (index+1<=size) {
			Object[] arrayCopy = new Object[10];
			for (int i = 0;i<index;i++) {
				arrayCopy[i] = elementData[i];
			}
			arrayCopy[index] = element;
			for (int i = index;i<size;i++) {
				arrayCopy[i+1] = elementData[i];
			}
			elementData = arrayCopy;
			size++;
		}
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 *
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	public E remove(int index) {
		Object[] newArray = new Object[10];
		E object = null;
		int counter = 0;
		for (int i = 0;i < size;i++) {
			if (i == index) {
				object = (E) elementData[i];
			} else {
				newArray[counter] = elementData[i];
				counter++;
			}
		}
		if (object != null) {
			size--;
			elementData = newArray;
		}
		return object;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or
	 * -1 if there is no such index.
	 */
	@Override
	public int indexOf(Object o) {
		int index = -1;
		boolean notFound = true;
		for (int i=0;i<size;i++) {
			if ((elementData[i] == o) && notFound) {
				index = i;
				notFound = true;
			}
		}
		return index;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the highest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or
	 * -1 if there is no such index.
	 */
	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0;i < size;i++) {
			if (elementData[i]==o) index =i;
		}
		return index;
	}

	/**
	 * 
	 * You do not need to implement any
	 * methods beyond this point. ..But if you're looking for a challenge, feel
	 * free.
	 */

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

}
