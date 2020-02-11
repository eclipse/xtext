/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.xtend.XtendFile
import org.junit.Test

/**
 * @author Christian Schneider
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=486838>https://bugs.eclipse.org/bugs/show_bug.cgi?id=486838</a>
 */
class CompilerBug486838Test extends AbstractXtendCompilerTest {

	@Test
	def void testBug486838() {
		'''
			package bug486838
			
			class Foo {
				/**
				 * field
				 */
				UnknownType field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* UnknownType */Object field;
			}
		''')
	}

	@Test
	def void testBug486838_comment() {
		'''
			package bug486838
			
			class Foo {
				/**
				 * field
				 */
				UnknownType/* comment */ field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* UnknownType */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_inner() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Unknown.InnerType field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Unknown.InnerType */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_inner_comment() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Unknown./* comment */InnerType field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Unknown. InnerType */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_inner_comment_WS() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Unkown. /* comment*/ InnerType field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Unkown. InnerType */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_parameterized() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Unknown<Argument> field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Unknown<Argument> */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_parameterized_comment() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Unknown< /* comment */ Argument> field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Unknown<Argument> */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_parameterized_argumentUnkown() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Functions.Function0<Argument> field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Function0<Argument> */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_parameterized_argumentUnkown_comment() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Functions.Function0/* comment */<Argument> field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Function0<Argument> */Object field;
			}
		''')
	}
	
	@Test
	def void testBug486838_parameterized_argumentUnkown_comment2() {
		'''
			package bug486838
						
			class Foo {
				/**
				 * field
				 */
				Functions.Function0</* comment */ Argument> field
			}
		'''.assertCompilesTo('''
			package bug486838;
			
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Foo {
			  /**
			   * field
			   */
			  private /* Function0<Argument> */Object field;
			}
		''')
	}
	
	override XtendFile file(String string, boolean validate) throws Exception {
		// suppress the validation here by ignoring 'validate'
		return file(string, false, true);
	}
}