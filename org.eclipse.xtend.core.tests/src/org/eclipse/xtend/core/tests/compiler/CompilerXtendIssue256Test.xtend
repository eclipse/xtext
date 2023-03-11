/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class CompilerXtendIssue256Test	extends AbstractXtendCompilerTest {
	@Test def void testIssue256_01() {
		assertCompilesTo('''
		class Foo {
			
			def foo() {
		  		bar
			}
			
			@Inline("\"bar\"") def static String bar() {
				throw new IllegalStateException
			}
			
		}
		''','''
		import org.eclipse.xtext.xbase.lib.Inline;
		
		@SuppressWarnings("all")
		public class Foo {
		  public String foo() {
		    return "bar";
		  }
		
		  @Inline("\"bar\"")
		  public static String bar() {
		    throw new IllegalStateException();
		  }
		}
		''')
	}
	
	@Test def void testIssue256_02() {
		assertCompilesTo('''
		class Foo {
			
			def foo() {
		  		bar
			}
			
			@Inline(value="\"bar\"") def static String bar() {
				throw new IllegalStateException
			}
			
		}
		''','''
		import org.eclipse.xtext.xbase.lib.Inline;
		
		@SuppressWarnings("all")
		public class Foo {
		  public String foo() {
		    return "bar";
		  }
		
		  @Inline(value = "\"bar\"")
		  public static String bar() {
		    throw new IllegalStateException();
		  }
		}
		''')
	}
	
	@Test def void testIssue256_03() {
		assertCompilesTo('''
		import java.util.List
		class Foo {
			
			def foo() {
		  		bar
			}
			
			@Inline(value="new ArrayList<String>()", imported=#[java.util.ArrayList]) def static List<String> bar() {
				throw new IllegalStateException
			}
			
		}
		''','''
		import java.util.ArrayList;
		import java.util.List;
		import org.eclipse.xtext.xbase.lib.Inline;
		
		@SuppressWarnings("all")
		public class Foo {
		  public List<String> foo() {
		    return new ArrayList<String>();
		  }
		
		  @Inline(value = "new ArrayList<String>()", imported = { ArrayList.class })
		  public static List<String> bar() {
		    throw new IllegalStateException();
		  }
		}
		''')
	}
}