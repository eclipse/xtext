/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autobuild

import org.eclipse.xtend.idea.LightXtendTest

/**
 */
class CyclicResolutionInEditorTest extends LightXtendTest {
	
	def void testCyclicResolution() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar {
			
				public void callToFoo(Foo foo) {
					foo.callToBar(this);
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.callToFoo(this)
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}

	def void testCyclicResolution2() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo {
			
				public void someMethod() {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.someMethod
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}

	def void testCyclicResolution3() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo<? extends Bar> {
			
				public void someMethod() {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo<T extends Bar> {
			
				def void callToBar(T bar) {
					bar.someMethod
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
	
	def void testCyclicResolution4() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar extends Foo<Bar> {
			
				public void someMethod(Bar b) {
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo<T extends Bar> {
			
				def void callToBar(T bar) {
					bar.someMethod(bar)
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
}