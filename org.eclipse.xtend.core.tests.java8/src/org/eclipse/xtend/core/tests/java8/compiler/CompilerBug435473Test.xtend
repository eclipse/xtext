/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug435473Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug435473Test {
	
	@Test override test_01() {
		'''
			import java.util.List
			class Outer {
				val List<Functions.Function0<?>> x = #[[|1],  [|1.0]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<?>> x = Collections.<Function0<?>>unmodifiableList(CollectionLiterals.<Function0<?>>newArrayList(((Function0<Object>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Object>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_02() {
		'''
			import java.util.List
			class Outer {
				val List<Functions.Function0<? extends Number>> x = #[[|1],  [|1.0]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableList(CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_03() {
		'''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<? extends Number>> x = #[[|1],  [|1.0]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableList(CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_04() {
		'''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<Number>> x = #[[|1],  [|1.0]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<Number>> x = Collections.<Function0<Number>>unmodifiableList(CollectionLiterals.<Function0<Number>>newArrayList(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_05() {
		'''
			import java.util.Set
			class Outer {
				val Set<Functions.Function0<? extends Number>> x = #{ [|1],  [|1.0] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableSet(CollectionLiterals.<Function0<? extends Number>>newHashSet(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_06() {
		'''
			import java.util.Set
			class Outer {
				val Set<Functions.Function0<Number>> x = #{ [|1],  [|1.0] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<Function0<Number>> x = Collections.<Function0<Number>>unmodifiableSet(CollectionLiterals.<Function0<Number>>newHashSet(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_07() {
		'''
			import java.util.Set
			class Outer {
				val Set<? extends Functions.Function0<? extends Number>> x = #{ [|1],  [|1.0] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<? extends Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableSet(CollectionLiterals.<Function0<? extends Number>>newHashSet(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_08() {
		'''
			import java.util.Set
			class Outer {
				val Set<? extends Functions.Function0<Number>> x = #{ [|1],  [|1.0] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Set<? extends Function0<Number>> x = Collections.<Function0<Number>>unmodifiableSet(CollectionLiterals.<Function0<Number>>newHashSet(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}

	@Test override test_09() {
		'''
			import java.util.List
			class Outer {
				val List<Functions.Function0<?>> x = newArrayList([|1],  [|1.0])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<?>> x = CollectionLiterals.<Function0<?>>newArrayList(((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }));
			}
		''')
	}
	
	@Test override test_10() {
		'''
			import java.util.List
			class Outer {
				val List<Functions.Function0<? extends Number>> x = newArrayList([|1],  [|1.0])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<Function0<? extends Number>> x = CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }));
			}
		''')
	}
	
	@Test override test_11() {
		'''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<? extends Number>> x = newArrayList([|1],  [|1.0])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<? extends Number>> x = CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }));
			}
		''')
	}
	
	@Test override test_13() {
		'''
			import java.util.List
			class Outer {
				val x = #[[|1],  [|1.0]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<? extends Number>> x = Collections.<Function0<? extends Number>>unmodifiableList(CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  })));
			}
		''')
	}
	
	@Test override test_14() {
		'''
			import java.util.List
			class Outer {
				val x = newArrayList([|1],  [|1.0])
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final ArrayList<Function0<? extends Number>> x = CollectionLiterals.<Function0<? extends Number>>newArrayList(((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }));
			}
		''')
	}	
	
	@Test
	override test_15() {
		'''
			import java.util.List
			class Outer {
				val List<? extends Functions.Function0<Number>> x = <Functions.Function0<Number>>newArrayList([|1],  [|1.0])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final List<? extends Function0<Number>> x = CollectionLiterals.<Function0<Number>>newArrayList(((Function0<Number>) () -> {
			    return Integer.valueOf(1);
			  }), ((Function0<Number>) () -> {
			    return Double.valueOf(1.0);
			  }));
			}
		''')
	}
	
	@Test
	override test_16() {
		'''
			import java.util.Map
			class Outer {
				val Map<String, Functions.Function0<?>> y = #{'' -> [|1], '' -> [|1.0]}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Map<String, Function0<?>> y = Collections.<String, Function0<?>>unmodifiableMap(CollectionLiterals.<String, Function0<?>>newHashMap(Pair.<String, Function0<Integer>>of("", ((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  })), Pair.<String, Function0<Double>>of("", ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }))));
			}
		''')
	}
	
	@Test
	override test_17() {
		'''
			import java.util.Map
			class Outer {
				val Map<CharSequence, Functions.Function0<?>> y = #{null as StringBuilder -> [|1], null as StringBuffer -> [|1.0]}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final Map<CharSequence, Function0<?>> y = Collections.<CharSequence, Function0<?>>unmodifiableMap(CollectionLiterals.<CharSequence, Function0<?>>newHashMap(Pair.<StringBuilder, Function0<Integer>>of(((StringBuilder) null), ((Function0<Integer>) () -> {
			    return Integer.valueOf(1);
			  })), Pair.<StringBuffer, Function0<Double>>of(((StringBuffer) null), ((Function0<Double>) () -> {
			    return Double.valueOf(1.0);
			  }))));
			}
		''')
	}
	
	// TODO this should be a list of Comparator<String> - Would be nice but too much effort ATM
	@Test
	override test_18() {
		'''
			class Outer {
				val x = newArrayList( String.CASE_INSENSITIVE_ORDER, [ $0 <=> $1 ] )
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Comparator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final ArrayList<Comparator<?>> x = CollectionLiterals.<Comparator<?>>newArrayList(String.CASE_INSENSITIVE_ORDER, ((Comparator<Comparable<? super Comparable<?>>>) (Comparable<? super Comparable<?>> $0, Comparable<? super Comparable<?>> $1) -> {
			    return ($0.compareTo($1));
			  }));
			}
		''')
	}
	
	@Test
	override test_19() {
		'''
			class Outer {
				val x = newArrayList( String.CASE_INSENSITIVE_ORDER, [ String s1, s2| s1 <=> s2 ] )
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Comparator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  private final ArrayList<Comparator<String>> x = CollectionLiterals.<Comparator<String>>newArrayList(String.CASE_INSENSITIVE_ORDER, ((Comparator<String>) (String s1, String s2) -> {
			    return (s1.compareTo(s2));
			  }));
			}
		''')
	}
	
	@Test
	override test_31() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<Functions.Function0<?>> x = #[[| null as B],  [| null as C]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<Function0<?>> x = Collections.<Function0<?>>unmodifiableList(CollectionLiterals.<Function0<?>>newArrayList(((Function0<Object>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Object>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_32() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<Functions.Function0<? extends A>> x = #[[| null as B],  [| null as C]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<Function0<? extends Outer.A>> x = Collections.<Function0<? extends Outer.A>>unmodifiableList(CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_33() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<? extends Functions.Function0<? extends A>> x = #[[| null as B],  [| null as C]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<? extends Function0<? extends Outer.A>> x = Collections.<Function0<? extends Outer.A>>unmodifiableList(CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_34() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<? extends Functions.Function0<A>> x = #[[| null as B],  [| null as C]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<? extends Function0<Outer.A>> x = Collections.<Function0<Outer.A>>unmodifiableList(CollectionLiterals.<Function0<Outer.A>>newArrayList(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_35() {
		'''
			import java.util.Set
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val Set<Functions.Function0<? extends A>> x = #{ [| null as B],  [| null as C] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final Set<Function0<? extends Outer.A>> x = Collections.<Function0<? extends Outer.A>>unmodifiableSet(CollectionLiterals.<Function0<? extends Outer.A>>newHashSet(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_36() {
		'''
			import java.util.Set
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val Set<Functions.Function0<A>> x = #{ [| null as B],  [| null as C] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final Set<Function0<Outer.A>> x = Collections.<Function0<Outer.A>>unmodifiableSet(CollectionLiterals.<Function0<Outer.A>>newHashSet(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_37() {
		'''
			import java.util.Set
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val Set<? extends Functions.Function0<? extends A>> x = #{ [| null as B],  [| null as C] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final Set<? extends Function0<? extends Outer.A>> x = Collections.<Function0<? extends Outer.A>>unmodifiableSet(CollectionLiterals.<Function0<? extends Outer.A>>newHashSet(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_38() {
		'''
			import java.util.Set
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val Set<? extends Functions.Function0<A>> x = #{ [| null as B],  [| null as C] }
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final Set<? extends Function0<Outer.A>> x = Collections.<Function0<Outer.A>>unmodifiableSet(CollectionLiterals.<Function0<Outer.A>>newHashSet(((Function0<Outer.A>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.A>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}

	@Test
	override test_39() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<Functions.Function0<?>> x = newArrayList([| null as B],  [| null as C])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<Function0<?>> x = CollectionLiterals.<Function0<?>>newArrayList(((Function0<Outer.B>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.C>) () -> {
			    return ((Outer.C) null);
			  }));
			}
		''')
	}
	
	@Test
	override test_40() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<Functions.Function0<? extends A>> x = newArrayList([| null as B],  [| null as C])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<Function0<? extends Outer.A>> x = CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.B>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.C>) () -> {
			    return ((Outer.C) null);
			  }));
			}
		''')
	}
	
	@Test
	override test_41() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val List<? extends Functions.Function0<? extends A>> x = newArrayList([| null as B],  [| null as C])
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<? extends Function0<? extends Outer.A>> x = CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.B>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.C>) () -> {
			    return ((Outer.C) null);
			  }));
			}
		''')
	}
	
	@Test
	override test_43() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val x = #[[| null as B],  [| null as C]]
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final List<? extends Function0<? extends Outer.A>> x = Collections.<Function0<? extends Outer.A>>unmodifiableList(CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.B>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.C>) () -> {
			    return ((Outer.C) null);
			  })));
			}
		''')
	}
	
	@Test
	override test_44() {
		'''
			import java.util.List
			class Outer {
				interface A {}
				interface B extends A{}
				interface C extends A{}
				val x = newArrayList([| null as B],  [| null as C])
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface A {
			  }
			  
			  public interface B extends Outer.A {
			  }
			  
			  public interface C extends Outer.A {
			  }
			  
			  private final ArrayList<Function0<? extends Outer.A>> x = CollectionLiterals.<Function0<? extends Outer.A>>newArrayList(((Function0<Outer.B>) () -> {
			    return ((Outer.B) null);
			  }), ((Function0<Outer.C>) () -> {
			    return ((Outer.C) null);
			  }));
			}
		''')
	}
	
}