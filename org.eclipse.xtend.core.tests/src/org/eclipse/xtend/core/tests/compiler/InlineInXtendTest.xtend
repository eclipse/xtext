/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Stéphane Galland - Initial Contribution
 * @author Christian Dietrich - Fixed broken test
 */
class InlineInXtendTest extends AbstractXtendCompilerTest {
	
	@Test
	def testDataClasses_01() { 
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Inline;
			class Foo {
				@Inline(value = "3", constantExpression = true)
				def int fct() {
					return 3
				}
				def int fct2() {
					return fct() + 1
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Inline;
			
			@SuppressWarnings("all")
			public class Foo {
			  @Inline(value = "3", constantExpression = true)
			  public int fct() {
			    return 3;
			  }
			
			  public int fct2() {
			    int _fct = 3;
			    return (_fct + 1);
			  }
			}
		''')
	}

}
