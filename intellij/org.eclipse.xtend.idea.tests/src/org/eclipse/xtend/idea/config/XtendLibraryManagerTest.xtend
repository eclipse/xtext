/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.config

import com.google.inject.Inject
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.psi.PsiDocumentManager
import org.eclipse.xtend.core.idea.config.XtendLibraryDescription
import org.eclipse.xtend.core.idea.config.XtendLibraryManager
import org.eclipse.xtend.core.idea.intentions.XtendIntentionsProvider
import org.eclipse.xtend.idea.LightXtendTest
import com.intellij.openapi.roots.ModuleRootModificationUtil

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendLibraryManagerTest extends LightXtendTest {
	@Inject XtendLibraryManager manager

	(Module)=>void libraryAdder

	override protected setUp() throws Exception {
		super.setUp()
		this.libraryAdder = [ module |
			ModuleRootModificationUtil.updateModel(module, [ rootModel |
				manager.ensureXtendLibAvailable(rootModel)
			])
		]
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
	}

	def void testNoLibErrors() {
		configureByText(
		'''
			<error descr="Couldn't find the mandatory library 'org.eclipse.xtext.xbase.lib' 2.8.0 or higher on the project's classpath.">class Foo {
				def static void main(String... args) {
					<error descr="The method println(String) is undefined">println</error>("Foo")
				}
			}</error>
		''')
		myFixture.checkHighlighting
	}

	def void testLibAdded() {
		libraryAdder.apply(myModule)
		configureByText('''
			class Foo {
				def static void main(String... args) {
					println("Foo")
				}
			}
		''')
		myFixture.checkHighlighting
	}

	def void testXtendLibMissingIntention() {
		assertIntentionApplication(XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction.TEXT, '''
			class Foo {
				def static void main(String... args) {
					println("Foo")
				}
			}
		''')
	}

	def assertIntentionApplication(String intentionId, String source) {
		val file = configureByText(source)
		val intention = myFixture.findSingleIntention(intentionId)
		CommandProcessor.getInstance().executeCommand(getProject(), [
			ApplicationManager.application.runWriteAction [
				intention.invoke(file.project, editor, file)
				PsiDocumentManager.getInstance(getProject()).commitAllDocuments()
			]
		], "", "")
		myFixture.checkHighlighting
	}

	def void testLibNotAddedTwice() {
		libraryAdder.apply(myModule)
		libraryAdder.apply(myModule)

		val xtendlibs = ModuleRootManager.getInstance(myModule).getOrderEntries.filter [
			presentableName.startsWith(XtendLibraryDescription.XTEND_LIBRARY_NAME)
		]

		assertEquals("Xtend libraries in module", 1, xtendlibs.size)
		configureByText('''
			class Foo {
				def static void main(String... args) {
					println("Foo")
				}
			}
		''')
		myFixture.checkHighlighting
	}
}