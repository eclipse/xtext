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
 * Tests for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=516321">https://bugs.eclipse.org/bugs/show_bug.cgi?id=516321</a>
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
class CompilerBug516321Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug516321() {
		assertCompilesTo(
			'''
			package com.example.xtend.arraylist
			
			class ArrayListCompile {
			
				def String foo() {
					bar(
						newArrayList(
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz
						), newArrayList(
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz,
							'x'.baz, 'x'.baz, 'x'.baz
					))
				}
			
				def String bar(Iterable<String> a, Iterable<String> b) {
				}
				
				def String baz(String foo) {
					return ''	
				}
				
			}
			''',
			'''
			package com.example.xtend.arraylist;
			
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class ArrayListCompile {
			  public String foo() {
			    return this.bar(
			      CollectionLiterals.<String>newArrayList(
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x"), this.baz("x"), this.baz("x"), 
			        this.baz("x")), CollectionLiterals.<String>newArrayList(
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x"), 
			      this.baz("x"), this.baz("x"), this.baz("x")));
			  }
			
			  public String bar(final Iterable<String> a, final Iterable<String> b) {
			    return null;
			  }
			
			  public String baz(final String foo) {
			    return "";
			  }
			}
			'''
		)
	}
	
}