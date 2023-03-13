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
class CompilerBug426073Test extends AbstractXtendCompilerTest {

	@Test
	def test_01() {
		assertCompilesTo('''
			package foo
			
			import static extension org.eclipse.emf.common.util.URI.*
			
			class Foo {
			
				val URI = "lalala".createURI 
			
			}
		''', '''
			package foo;
			
			import org.eclipse.emf.common.util.URI;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final URI URI = org.eclipse.emf.common.util.URI.createURI("lalala");
			}
		''')
	}

	@Test
	def test_02() {
		assertCompilesTo('''
			package foo
			
			import static extension org.eclipse.emf.common.util.URI.*
			
			class Foo {
			
				val URI2 = "lalala".createURI 
			
			}
		''', '''
			package foo;
			
			import org.eclipse.emf.common.util.URI;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final URI URI2 = URI.createURI("lalala");
			}
		''')
	}

}
