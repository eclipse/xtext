/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug465649Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				
				def static m() {
					newArray(1, 1)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static Integer[] m() {
			    return C.<Integer>newArray(Integer.valueOf(1), Integer.valueOf(1));
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				
				def static m() {
					newArray(1, 1.1)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static Number[] m() {
			    return C.<Number>newArray(Integer.valueOf(1), Double.valueOf(1.1));
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				
				def static m() {
					newArray(1, '1')
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static Object[] m() {
			    return C.<Object>newArray(Integer.valueOf(1), "1");
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				
				def static m() {
					newArray(1, 1.1, '1')
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static Object[] m() {
			    return C.<Object>newArray(Integer.valueOf(1), Double.valueOf(1.1), "1");
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				def static <E> Class<? extends E[]> getClass(E[] arr) {
					return (arr as Object).getClass as Class<? extends E[]>
				}
				
				def static void main(String... args) {
					val arr1 = newArray(1, 1)
					val arr2 = newArray(1, 1.1)
					val arr3 = newArray(1, '1')
					val arr4 = newArray(1, 1.1, '1')
					
					println(arr1.class.name)
					println(arr2.class.name)
					println(arr3.class.name)
					println(arr4.class.name)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;

			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static <E extends Object> Class<? extends E[]> getClass(final E[] arr) {
			    Class<?> _class = ((Object) arr).getClass();
			    return ((Class<? extends E[]>) _class);
			  }
			  
			  public static void main(final String... args) {
			    final Integer[] arr1 = C.<Integer>newArray(Integer.valueOf(1), Integer.valueOf(1));
			    final Number[] arr2 = C.<Number>newArray(Integer.valueOf(1), Double.valueOf(1.1));
			    final Object[] arr3 = C.<Object>newArray(Integer.valueOf(1), "1");
			    final Object[] arr4 = C.<Object>newArray(Integer.valueOf(1), Double.valueOf(1.1), "1");
			    Class<? extends Integer[]> _class = C.<Integer>getClass(arr1);
			    String _name = _class.getName();
			    InputOutput.<String>println(_name);
			    Class<? extends Number[]> _class_1 = C.<Number>getClass(arr2);
			    String _name_1 = _class_1.getName();
			    InputOutput.<String>println(_name_1);
			    Class<? extends Object[]> _class_2 = C.<Object>getClass(arr3);
			    String _name_2 = _class_2.getName();
			    InputOutput.<String>println(_name_2);
			    Class<? extends Object[]> _class_3 = C.<Object>getClass(arr4);
			    String _name_3 = _class_3.getName();
			    InputOutput.<String>println(_name_3);
			  }
			}
		''')
	}
	
	@Test def test_06() {
		'''
			class C {
				def static <E> E[] newArray(E... arr) {
					return arr
				}
				
				def static m() {
					// internally we know more about the type of the elements
					newArray(1, '1').get(0).compareTo(null)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static <E extends Object> E[] newArray(final E... arr) {
			    return arr;
			  }
			  
			  public static int m() {
			    Object[] _newArray = C.<Object>newArray(Integer.valueOf(1), "1");
			    Object _get = _newArray[0];
			    return ((Comparable<?>)_get).compareTo(null);
			  }
			}
		''')
	}
	
}