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
 * @author Anton Kosyakov - Initial contribution and API
 */
class CompoundAssignmentOperatorCompilerTest extends AbstractXtendCompilerTest {

	@Test def void test_1() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var i = 2
					i += i *= 2
				}
				
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _multiplyAssign = i *= 2;
			      _xblockexpression = i += _multiplyAssign;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_2() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var i = 2
					i *= i += 2
				}
				
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _add = i += 2;
			      _xblockexpression = i *= _add;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

}
