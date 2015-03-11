/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug424763Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_424763_01() {
		assertCompilesTo('''
			import static com.google.common.base.Preconditions.*
			
			class NoConstructor<JAVA_TYPE> implements Functions.Function0<JAVA_TYPE> {
				val String type
				new(String theTypeName) {
					type = checkNotNull(theTypeName, "theTypeName")
				}
				new(Class<JAVA_TYPE> theType) {
					type = checkNotNull(theType, "theType").name
				}
				override apply() {
					throw new UnsupportedOperationException("Instances of type "+type
						+" cannot be created (without parameters?)")
				}
			}
			
			class Test<JAVA_TYPE> {
			
				val Functions.Function0<JAVA_TYPE> constructor
			
				new(Functions.Function0<JAVA_TYPE> theConstructor,
					Class<JAVA_TYPE> theType) {
					constructor = if (theConstructor == null)
						new NoConstructor<JAVA_TYPE>(theType) else theConstructor
				}
			
				def static test(){
					new Test(null, String)
				}
			}
		''', '''
			import com.google.common.base.Preconditions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class NoConstructor<JAVA_TYPE extends Object> implements Function0<JAVA_TYPE> {
			  private final String type;
			  
			  public NoConstructor(final String theTypeName) {
			    String _checkNotNull = Preconditions.<String>checkNotNull(theTypeName, "theTypeName");
			    this.type = _checkNotNull;
			  }
			  
			  public NoConstructor(final Class<JAVA_TYPE> theType) {
			    Class<JAVA_TYPE> _checkNotNull = Preconditions.<Class<JAVA_TYPE>>checkNotNull(theType, "theType");
			    String _name = _checkNotNull.getName();
			    this.type = _name;
			  }
			  
			  public JAVA_TYPE apply() {
			    throw new UnsupportedOperationException(
			      (("Instances of type " + this.type) + " cannot be created (without parameters?)"));
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_02() {
		assertCompilesTo('''
			import static com.google.common.base.Preconditions.*
			
			class Test<JAVA_TYPE> {
			
				val Functions.Function0<JAVA_TYPE> constructor
				val list = new java.util.ArrayList(1)
			
				new(Functions.Function0<JAVA_TYPE> theConstructor, Class<JAVA_TYPE> theType) {
					constructor = if (theConstructor == null)
						new NoConstructor<JAVA_TYPE>(theType)
					else 
						theConstructor
				}
			
				def static test(){
					new Test(null, String)
				}
			}
			
			class NoConstructor<JAVA_TYPE> implements Functions.Function0<JAVA_TYPE> {
				val String type
				new(String theTypeName) {
					type = checkNotNull(theTypeName, "theTypeName")
				}
				new(Class<JAVA_TYPE> theType) {
					type = checkNotNull(theType, "theType").name
				}
				override apply() {
					throw new UnsupportedOperationException("Instances of type "+type
						+" cannot be created (without parameters?)")
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Test<JAVA_TYPE extends Object> {
			  private final Function0<JAVA_TYPE> constructor;
			  
			  private final ArrayList<Object> list = new ArrayList<Object>(1);
			  
			  public Test(final Function0<JAVA_TYPE> theConstructor, final Class<JAVA_TYPE> theType) {
			    Function0<JAVA_TYPE> _xifexpression = null;
			    boolean _equals = Objects.equal(theConstructor, null);
			    if (_equals) {
			      _xifexpression = new NoConstructor<JAVA_TYPE>(theType);
			    } else {
			      _xifexpression = theConstructor;
			    }
			    this.constructor = _xifexpression;
			  }
			  
			  public static Test<String> test() {
			    return new Test<String>(null, String.class);
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_03() {
		assertCompilesTo('''
			class C<T> {
			
				val Functions.Function0<T> constructor
			
				new(C<T> theConstructor) {
					this.constructor = theConstructor?.constructor
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  private final Function0<T> constructor;
			  
			  public C(final C<T> theConstructor) {
			    Function0<T> _constructor = null;
			    if (theConstructor!=null) {
			      _constructor=theConstructor.constructor;
			    }
			    this.constructor = _constructor;
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_04() {
		assertCompilesTo('''
			class C<T> {
			
				val Functions.Function0<T> constructor
			
				new(C<T> theConstructor) {
					this.constructor = theConstructor?.doGetConstructor(try {''} finally {})
				}
				
				def doGetConstructor(String s) {
					constructor
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  private final Function0<T> constructor;
			  
			  public C(final C<T> theConstructor) {
			    Function0<T> _doGetConstructor = null;
			    if (theConstructor!=null) {
			      String _xtrycatchfinallyexpression = null;
			      try {
			        _xtrycatchfinallyexpression = "";
			      } finally {
			      }
			      _doGetConstructor=theConstructor.doGetConstructor(_xtrycatchfinallyexpression);
			    }
			    this.constructor = _doGetConstructor;
			  }
			  
			  public Function0<T> doGetConstructor(final String s) {
			    return this.constructor;
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_05() {
		assertCompilesTo('''
			import static com.google.common.base.Preconditions.*
			
			class Test<JAVA_TYPE> {
			
				val Functions.Function0<JAVA_TYPE> constructor
			
				new(Functions.Function0<JAVA_TYPE> theConstructor, Class<JAVA_TYPE> theType) {
					constructor = if (theConstructor == null)
						new NoConstructor<JAVA_TYPE>(try { theType } finally {})
					else 
						theConstructor
				}
			
				def static test(){
					new Test(null, String)
				}
			}
			
			class NoConstructor<JAVA_TYPE> implements Functions.Function0<JAVA_TYPE> {
				val String type
				new(String theTypeName) {
					type = checkNotNull(theTypeName, "theTypeName")
				}
				new(Class<JAVA_TYPE> theType) {
					type = checkNotNull(theType, "theType").name
				}
				override apply() {
					throw new UnsupportedOperationException("Instances of type "+type
						+" cannot be created (without parameters?)")
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Test<JAVA_TYPE extends Object> {
			  private final Function0<JAVA_TYPE> constructor;
			  
			  public Test(final Function0<JAVA_TYPE> theConstructor, final Class<JAVA_TYPE> theType) {
			    Function0<JAVA_TYPE> _xifexpression = null;
			    boolean _equals = Objects.equal(theConstructor, null);
			    if (_equals) {
			      Class<JAVA_TYPE> _xtrycatchfinallyexpression = null;
			      try {
			        _xtrycatchfinallyexpression = theType;
			      } finally {
			      }
			      _xifexpression = new NoConstructor<JAVA_TYPE>(_xtrycatchfinallyexpression);
			    } else {
			      _xifexpression = theConstructor;
			    }
			    this.constructor = _xifexpression;
			  }
			  
			  public static Test<String> test() {
			    return new Test<String>(null, String.class);
			  }
			}
		''')
	}

	@Test def void testBug_424763_06() {
		assertCompilesTo('''
			class C<T> {
			
				val Functions.Function0<T> constructor
			
				new(C<T> theConstructor) {
					this(theConstructor?.constructor)
				}
				new(Functions.Function0<T> f) {
					this.constructor = f
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  private final Function0<T> constructor;
			  
			  public C(final C<T> theConstructor) {
			    this(new Function0<Function0<T>>() {
			      public Function0<T> apply() {
			        Function0<T> _constructor = null;
			        if (theConstructor!=null) {
			          _constructor=theConstructor.constructor;
			        }
			        return _constructor;
			      }
			    }.apply());
			  }
			  
			  public C(final Function0<T> f) {
			    this.constructor = f;
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_07() {
		assertCompilesTo('''
			class C<T> {
			
				val Functions.Function0<T> constructor
			
				new(C<T> theConstructor) {
					this.constructor = theConstructor.doGetConstructor(try {''} finally {})
				}
				
				def doGetConstructor(String s) {
					constructor
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  private final Function0<T> constructor;
			  
			  public C(final C<T> theConstructor) {
			    String _xtrycatchfinallyexpression = null;
			    try {
			      _xtrycatchfinallyexpression = "";
			    } finally {
			    }
			    Function0<T> _doGetConstructor = theConstructor.doGetConstructor(_xtrycatchfinallyexpression);
			    this.constructor = _doGetConstructor;
			  }
			  
			  public Function0<T> doGetConstructor(final String s) {
			    return this.constructor;
			  }
			}
		''')
	}
	
	@Test def void testBug_424763_08() {
		assertCompilesTo('''
			class C<T> {
			
				val Functions.Function0<T> constructor
			
				new(C<T> theConstructor) {
					this(theConstructor.doGetConstructor(try {''} finally {}))
				}
				new(Functions.Function0<T> f) {
					this.constructor = f
				}
				
				def doGetConstructor(String s) {
					constructor
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  private final Function0<T> constructor;
			  
			  public C(final C<T> theConstructor) {
			    this(new Function0<Function0<T>>() {
			      public Function0<T> apply() {
			        String _xtrycatchfinallyexpression = null;
			        try {
			          _xtrycatchfinallyexpression = "";
			        } finally {
			        }
			        Function0<T> _doGetConstructor = theConstructor.doGetConstructor(_xtrycatchfinallyexpression);
			        return _doGetConstructor;
			      }
			    }.apply());
			  }
			  
			  public C(final Function0<T> f) {
			    this.constructor = f;
			  }
			  
			  public Function0<T> doGetConstructor(final String s) {
			    return this.constructor;
			  }
			}
		''')
	}	
}
