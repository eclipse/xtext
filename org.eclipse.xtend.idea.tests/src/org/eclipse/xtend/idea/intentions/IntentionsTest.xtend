/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.intentions

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.psi.PsiDocumentManager
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtend.core.idea.intentions.XtendIntentionsProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class IntentionsTest extends LightXtendTest {
	
	def testImplementMethods_01() {
		assertIntentionApplication(XtendIntentionsProvider.InsertXtendMethodsIntentionAction.TEXT,'''
			class F<caret>oo implements Comparable<Foo> {
			}
		''','''
			class Foo implements Comparable<Foo> {
			
				override compareTo(Foo t) {
					throw new UnsupportedOperationException()
				}
			
			}
		''')
	}
	
	def testImplementMethods_02() {
		assertIntentionApplication(XtendIntentionsProvider.InsertXtendMethodsIntentionAction.TEXT,'''
			class Foo {
				def void myMethods() {
					val runnable = new Run<caret>nable() {
					}
					runnable.run()
				}
			}
		''','''
			class Foo {
				def void myMethods() {
					val runnable = new Runnable() {
			
						override run() {
							throw new UnsupportedOperationException()
						}
			
					}
					runnable.run()
				}
			}
		''')
	}
	
	def testSuperConstructors_01() {
		myFixture.addClass('''
			package mypackage;
			
			import java.io.FileNotFoundException;
			import java.io.File;
			import java.io.FileDescriptor;
			
			public class MyClass {
				public MyClass(String s) throws FileNotFoundException {}
				public MyClass(File file) throws FileNotFoundException {}
				public MyClass(FileDescriptor fileDescriptor) {}
			}
		''')
		assertIntentionApplication(XtendIntentionsProvider.InsertSuperConstructorsIntentionAction.TEXT,'''
			class F<caret>oo extends mypackage.MyClass {
			}
		''','''
			import java.io.FileNotFoundException
			import java.io.File
			import java.io.FileDescriptor
			
			class Foo extends mypackage.MyClass {
			
				new (String s) throws FileNotFoundException {
					super(s)
				}
			
				new (File file) throws FileNotFoundException {
					super(file)
				}
			
				new (FileDescriptor fileDescriptor) {
					super(fileDescriptor)
				}
			
			}
		''')
	}
	
	protected def void assertIntentionApplication(String intentionId, String source, String after) {
		val file = configureByText(source)
		val intention = myFixture.findSingleIntention(intentionId)
		CommandProcessor.getInstance().executeCommand(getProject(), [
			ApplicationManager.application.runWriteAction [
				intention.invoke(file.project, editor, file)
				PsiDocumentManager.getInstance(getProject()).commitAllDocuments()
			]
		], "", "")
		assertEquals(after,myFixture.editor.document.text)
	}
}
