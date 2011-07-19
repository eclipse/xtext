package testdata;

public class ArrayClient2<T> {
	
    private T[] internal;

    public ArrayClient2(T[] internal) {
        this.internal = internal;
    }

    public T get(int index) {
        return internal[index];
    }

    public T set(int index, T value) {
        return internal[index] = value;
    }

    public static <X> ArrayClient2<X> access(X[] val) {
        return new ArrayClient2<X>(val);
    }

}