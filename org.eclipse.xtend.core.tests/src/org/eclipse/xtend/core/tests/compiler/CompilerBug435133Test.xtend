/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug435133Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.annotation.RetentionPolicy.*
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val idx = valueOf(null, 1)
					idx.present
					return null
				}
			}
		''', '''
			import com.google.common.base.Optional;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final Optional<Object> idx = C.valueOf(null, Integer.valueOf(1));
			    idx.isPresent();
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.Enum.valueOf
			import java.lang.annotation.RetentionPolicy
			import java.util.List
			import java.util.Set
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val idx = valueOf(RetentionPolicy, '')
					idx.toString
					return null
				}
			}
		''', '''
			import com.google.common.base.Optional;
			import java.lang.annotation.RetentionPolicy;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final RetentionPolicy idx = Enum.<RetentionPolicy>valueOf(RetentionPolicy.class, "");
			    idx.toString();
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.Enum.*
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val idx = <Enum>valueOf(null, null)
					return null
				}
			}
		''', '''
			import com.google.common.base.Optional;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final Enum idx = Enum.<Enum>valueOf(null, null);
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.Enum.*
			import java.lang.annotation.RetentionPolicy
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val RetentionPolicy idx = valueOf(null, null)
					return null
				}
			}
		''', '''
			import com.google.common.base.Optional;
			import java.lang.annotation.RetentionPolicy;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final RetentionPolicy idx = Enum.<RetentionPolicy>valueOf(null, null);
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.Enum.*
			import java.lang.annotation.RetentionPolicy
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val Enum<RetentionPolicy> idx = valueOf(null, null)
					return null
				}
			}
		''', '''
			import com.google.common.base.Optional;
			import java.lang.annotation.RetentionPolicy;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final Enum<RetentionPolicy> idx = Enum.<RetentionPolicy>valueOf(null, null);
			    return null;
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug436483_01() {
		assertCompilesTo('''
			import com.google.common.base.Optional
			import static java.lang.Enum.*
			class C {
				def static Optional<Object> valueOf(Object o, Object context) {
				}
				def Optional<Object> m() {
					val idx = valueOf(null, null)
					return idx
				}
			}
		''', '''
			import com.google.common.base.Optional;
			
			@SuppressWarnings("all")
			public class C {
			  public static Optional<Object> valueOf(final Object o, final Object context) {
			    return null;
			  }
			  
			  public Optional<Object> m() {
			    final Enum idx = Enum.<Enum>valueOf(null, null);
			    return null;
			  }
			}
		''')
	}
	
}