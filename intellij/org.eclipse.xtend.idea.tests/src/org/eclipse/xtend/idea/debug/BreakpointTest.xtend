/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.debug

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.tests.LibraryUtil
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.idea.tests.debug.AbstractDebuggerTestCase
import org.eclipse.xtext.util.internal.Log

/**
 * @author efftinge - Initial contribution and API
 */
@Log class BreakpointTest extends AbstractDebuggerTestCase {
	
	override configureModule(Module module, ModifiableRootModel model, ContentEntry entry) {
		LibraryUtil.addXtendLibrary(model)
		val srcGenFolder = project.baseDir.createChildDirectory(null, "xtend-gen")
		entry.addSourceFolder(srcGenFolder, false)
		LightToolingTest.addFacetToModule(module, XtendLanguage.INSTANCE.ID)
	}
	
	def void testLineBreakpoint() {
		val file = addFile("MyClass.xtend" -> '''
				class MyClass {
					def static void main(String[] args) {
						println("Hello")
						println("World")
					}
				}
			''')
		compile
		file.addLineBreakpoint(2)
		file.addLineBreakpoint(3)
		startDebugProcess('MyClass')
		file.assertCurrentLine('println("Hello")')
		resume
		file.assertCurrentLine('println("World")')
		resume
		assertProcessTerminated
	}
	
	def void testLineBreakpoint_01() {
		val file = addFile("MyClass.xtend" -> '''
				class MyClass {
					def static void main(String[] args) {
						println("Hello")
						println("World")
						foo('Hello','Woo')
					}
					
					def static void foo(String... woo) {
						
						
						
						
						println("Hi")
						
						if (woo.length == 2) {
							println(woo.get(1))
						}
					}
				}
			''')
		compile
		file.addLineBreakpoint(4)
		file.addLineBreakpoint(14)
		file.addLineBreakpoint(15)

		startDebugProcess('MyClass')

		file.assertCurrentLine("foo('Hello','Woo')")
		resume
		file.assertCurrentLine('if (woo.length == 2) {')
		resume
		file.assertCurrentLine('println(woo.get(1))')
		resume
		assertProcessTerminated
	}
	
	def void testLineBreakpoint_02() {
		val file = addFile("MyClass.xtend" -> '''
				class MyClass {
					def static void main(String[] args) {
						println("Hello")
						
						foo [ println("World") ]
					}
					
					def static void foo(Runnable runnable) {
						
						
						
						
						println("Hi")
						runnable.run
					}
				}
			''')
		compile
		file.addLineBreakpoint(4)
		file.addLineBreakpoint(12)

		startDebugProcess('MyClass')

		file.assertCurrentLine('foo [ println("World") ]')
		resume
		file.assertCurrentLine('println("Hi")')
		resume
		file.assertCurrentLine('foo [ println("World") ]')
		resume
		assertProcessTerminated
	}
	
}