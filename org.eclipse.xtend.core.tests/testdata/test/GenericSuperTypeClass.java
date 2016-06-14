package test;

import java.io.Serializable;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public abstract class GenericSuperTypeClass<T> {

	public abstract <V> V getSomething(V v);
	
	public abstract <C extends Comparable<C>> void useComparable(C c);
	public abstract <C extends Comparable<C>> C getComparable();

	public abstract T getTypeParamValue();
	
	public abstract <T1 extends Object> T1[] getValue1(final List<T1> t);

	public abstract <T2 extends Object> T2[] getValue2(final T2[] t);

	public abstract <T3 extends Object> List<T3> getValue3(final List<T3> t);

	public abstract <T3 extends Object> List<T3> getValue4(final List<T3[]> t);

	public abstract <T3 extends Object> List<T3> getValue5(final List<List<T3>[]> t);

	public abstract <T3 extends Object> List<T3> getValue6(final List<? extends T3> t);

	public abstract <T3 extends Object> List<T3> getValue7(final List<? super T3> t);

	public abstract <T1 extends Object, T2 extends T1> T1[] getValue8(final List<T1> t, final List<T2> t2);

	public abstract <T2 extends Object, T1 extends Serializable & CharSequence> T1[] getValue9(final List<T1> t);

	public abstract <T5 extends CharSequence> void foo1();

	public abstract <T6> void foo2(T t, Procedure1<? super T> proc);
	
	public abstract <T7> void foo3(T7 t, Procedure1<? super T7> proc);
	
}
