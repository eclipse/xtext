/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.completion

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

abstract class AbstractXbaseCompletionTest extends LightToolingTest {

	def testMemberFeatureCall() {
		type('''"".toSt''')
		completeBasic
		assertLookupStrings("toString")
	}
	
	def testFeatureCall() {
		type('''printl''')
		completeBasic
		assertLookupStrings("println")
	}
	
	//TODO add tests here

	new() {
		super(XbaseFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXbaseLibrary
	}

	override protected setUp() throws Exception {
		super.setUp
		configureByText(prefix + "<caret>" + suffix)
	}

	protected def String getPrefix()

	protected def String getSuffix()
}

class CompletionInTryBlockTest extends AbstractXbaseCompletionTest {

	override protected getPrefix() '''
		try {
			
	'''

	override protected getSuffix() '''
		} finally {
			
		}
	'''
}

//TODO add other contexts here