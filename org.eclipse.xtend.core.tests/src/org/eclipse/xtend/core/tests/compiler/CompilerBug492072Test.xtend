/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class CompilerBug492072Test extends AbstractXtendCompilerTest {
	
	@Test
	def testFeatureCallInAssignmentWithoutVariableDeclaration_0() {
		assertCompilesTo('''
			class Foo {
				
				def foo(Bar a, Bar b) {
					a.name = b.name
				}
			}
			class Bar {
				
				String name
				def String getName(){
					name
				}
				def void setName(String n){
					name = n
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Bar a, final Bar b) {
			    a.setName(b.getName());
			  }
			}
		''')
	}
	
	@Test
	def testFeatureCallInAssignmentWithoutVariableDeclaration_1() {
		assertCompilesTo('''
			class Foo {
				
				def foo(Bar a, Bar b) {
					a.name = b.name.toString
				}
			}
			class Bar {
				
				String name
				def String getName(){
					name
				}
				def void setName(String n){
					name = n
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Bar a, final Bar b) {
			    a.setName(b.getName().toString());
			  }
			}
		''')
	}
	
	@Test
	def testFeatureCallInAssignmentWithVariableDeclarationWhenNullSafe_0() {
		assertCompilesTo('''
			class Foo {
				
				def foo(Bar a, Bar b) {
					a.name = b?.name
				}
			}
			class Bar {
				
				String name
				def String getName(){
					name
				}
				def void setName(String n){
					name = n
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Bar a, final Bar b) {
			    String _name = null;
			    if (b!=null) {
			      _name=b.getName();
			    }
			    a.setName(_name);
			  }
			}
		''')
	}

	@Test
	def testFeatureCallWithoutVariableDeclaration_0() {
		assertCompilesTo('''
			class Foo {
				
				def foo(Bar a, Bar b) {
					bar(a.name)
				}
				def bar(String n){
					n
				}
			}
			class Bar {
				
				String name
				def String getName(){
					name
				}
				def void setName(String n){
					name = n
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  public String foo(final Bar a, final Bar b) {
			    return this.bar(a.getName());
			  }
			
			  public String bar(final String n) {
			    return n;
			  }
			}
		''')
	}
	
	@Test
	def testFeatureCallWithVariableDeclarationWhenNullSafe_0() {
		assertCompilesTo('''
			class Foo {
				
				def foo(Bar a, Bar b) {
					bar(a?.name)
				}
				def bar(String n){
					n
				}
			}
			class Bar {
				
				String name
				def String getName(){
					name
				}
				def void setName(String n){
					name = n
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  public String foo(final Bar a, final Bar b) {
			    String _name = null;
			    if (a!=null) {
			      _name=a.getName();
			    }
			    return this.bar(_name);
			  }
			
			  public String bar(final String n) {
			    return n;
			  }
			}
		''')
	}
}