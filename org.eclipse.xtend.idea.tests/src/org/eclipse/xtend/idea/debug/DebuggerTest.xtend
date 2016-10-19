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
import com.intellij.openapi.vfs.VfsUtil
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.tests.LibraryUtil
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.idea.tests.debug.AbstractDebuggerTestCase
import org.eclipse.xtext.util.internal.Log

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Log class DebuggerTest extends AbstractDebuggerTestCase {
	
	override configureModule(Module module, ModifiableRootModel model, ContentEntry entry) {
		LibraryUtil.addXtendLibrary(model)
		val srcGenFolder = VfsUtil.createDirectoryIfMissing(project.baseDir, "xtend-gen")
		entry.addSourceFolder(srcGenFolder, false)
		LightToolingTest.addFacetToModule(module, XtendLanguage.INSTANCE.ID)
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreSimpleDebug() {
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
		startDebugProcess('MyClass')
		file.assertCurrentLine('println("Hello")')
		stepOver
		file.assertCurrentLine('println("World")')
	}
	
	def void testSimpleStepInto() {
		val file = addFile("MyClass.xtend" -> '''
				class MyClass {
					def static void main(String[] args) {
						doFoo("Hello")
					}
					
					def static doFoo(String x) {
						println(x)
					}
				}
			''')
		compile
		file.addLineBreakpoint(2)
		startDebugProcess('MyClass')
		file.assertCurrentLine('doFoo("') 
		stepInto
		file.assertCurrentLine('println(x)')
		stepOut
		file.assertCurrentLine('doFoo("')
	}
	
	def void testXtendAndJavaBackAndForth() {
		val javaFile = addFile("MyJavaClass.java" -> '''
				public class MyJavaClass {
					public static void doFoo(String x) {
						System.out.println(x);
					}
				}
			''')
		val file = addFile("MyClass.xtend" -> '''
				class MyClass {
					def static void main(String[] args) {
						MyJavaClass.doFoo("Hello")
						System.out.println("done");
					}
				}
			''')
		compile
		file.addLineBreakpoint(2)
		startDebugProcess('MyClass')
		
		file.assertCurrentLine('MyJavaClass.doFoo("') 
		stepInto
		javaFile.assertCurrentLine(2)
		stepOut
		file.assertCurrentLine('System.out.println("done");')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreTemplateExpression_for() {
		val file = addFile("MyClass.xtend" -> "
				class MyClass {
					def static void main(String[] args) {
						println(foo)
					}

					def static foo() '''
						«FOR x : 1..3»
							Hello «x»,
							This is a second Line
						«ENDFOR»
					'''//END
				}
		")
		compile
		file.addLineBreakpoint(3)
		startDebugProcess('MyClass')
		stepInto
		stepOver(11)
		file.assertCurrentLine("'''//END")
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreTemplateExpression_if() {
		val file = addFile("MyClass.xtend" -> "
				class MyClass {
					def static void main(String[] args) {
						println(foo('xyz'))
					}
				
					def static foo(String text) '''
						«IF text.length>2»
							if «foo('xy')»,
						«ELSEIF text.length==2»
							elseif «foo('x')»,
						«ELSE»
							else «text»
						«ENDIF»
					'''//END
				}
		")
		compile
		file.addLineBreakpoint(3)
		startDebugProcess('MyClass')
		stepInto
		stepOver(2)
		stepInto
		stepOver(3)
		stepInto
		stepOver(4)
		file.assertCurrentLine("text»")
	}
	
	def void testSwitch() {
		val file = addFile("MyClass.xtend" -> '''
			class MyClass {
				def static void main(String[] args) {
					for (i : #['fii',3,'d']) {
						switch i {
							CharSequence case i.length == 1: {
								println('a')
							}
							Number case i.intValue == 3 : {
								println('b')
							}
							String : {
								println('c')
							}
						}
					}
				}
			}
		''')
		compile
		file.addLineBreakpoint(2)
		startDebugProcess('MyClass')
		stepOver(5)
		file.assertCurrentLine("println('c')")
		stepOver(2) // back to for
		stepOver(4)
		file.assertCurrentLine("println('b')")
		stepOver(3) // back to for
		stepOver(3)
		file.assertCurrentLine("println('a')")
		stepOver(4) // back to for
		file.assertCurrentLine("i : #['fii',3,'d']")
	}
	
	def void testTryCatchFinally() {
		val file = addFile("MyClass.xtend" -> '''
			class MyClass {
				def static void main(String[] args) {
					call(null)
					call(new NullPointerException())
					call(new java.io.IOException())
				}
			
				def static void call(Throwable t) {
					try {
						if (t != null)
							throw t
					} catch (NullPointerException e) {
						println('npe')
					} catch (Throwable e) {
						println('other')
					} finally {
						println('finally')
					}
				}
			}
		''')
		compile
		file.addLineBreakpoint(2)
		startDebugProcess('MyClass')
		stepInto
		file.assertCurrentLine("t != null")
		stepOver
		file.assertCurrentLine("println('finally')")
		stepOver(3) // back to main
		
		file.assertCurrentLine("call(new NullPointerException())")
		stepInto
		file.assertCurrentLine("t != null")
		stepOver(3)
		file.assertCurrentLine("println('npe')")
		stepOver(2)
		file.assertCurrentLine("println('finally')")
		stepOver(3) // back to main
		
		file.assertCurrentLine("call(new java.io.IOException())")
		stepInto
		file.assertCurrentLine("t != null")
		stepOver(4)
		file.assertCurrentLine("println('other')")
		stepOver(2)
		file.assertCurrentLine("println('finally')")
		stepOver(3) // back to main
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreLambda() {
		val file = addFile("MyClass.xtend" -> '''
			class MyClass {
				def static void main(String[] args) {
					val list = #[1,2,3,4]
					list.doForEach [
						println(it)
					]
				}
			
				def static void doForEach(java.util.List<Integer> list, (Integer)=>void consumer) {
			        for (i : list) {
			            consumer.apply(i)
			        }
			    }
			}
		''')
		compile
		file.addLineBreakpoint(2)
		startDebugProcess('MyClass')
		stepOver
		stepInto
		file.assertCurrentLine("for (i : list) {")
		stepOver
		stepInto
		file.assertCurrentLine("println(it)")
		stepOut
		stepOver(12)
		file.assertCurrentLine(6)
	}
}