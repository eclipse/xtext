/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.jface.text.ITextHoverExtension2
import org.eclipse.jface.text.ITextViewer
import org.eclipse.jface.text.Region
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.After
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendHoverInEditorTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper helper
	
	@Inject extension SyncUtil
	
	@Inject IEObjectHover hoverer
	
	@After override void tearDown() {
		helper.tearDown
	}
	
	@Test def void testHoverOfReferencedElement() {
		val contentFoo = '''
			/**
			 * Hello Foo
			 */
			class Foo {}
		'''
		val contentBar = '''
			class Bar extends Foo {}
		'''
		val fileFoo = createFile("Foo.xtend",contentFoo)
		val fileBar = createFile("Bar.xtend",contentBar)
		waitForBuild(null)
		
		val editor = openEditor(fileBar)
		val info = (hoverer as ITextHoverExtension2).getHoverInfo2(editor.internalSourceViewer as ITextViewer, new Region(19,1)) as XtextBrowserInformationControlInput
		assertTrue(info.html.contains("Hello Foo"))
		
		// check dirty State
		val fooEditor = openEditor(fileFoo)
		fooEditor.document.set('''
			/**
			 * Hello BAZ
			 */
			class Foo {}
		''')
		fooEditor.waitForReconciler
		editor.waitForDirtyStateUpdater
		editor.waitForReconciler
		val info2 = (hoverer as ITextHoverExtension2).getHoverInfo2(editor.internalSourceViewer as ITextViewer, new Region(19,1)) as XtextBrowserInformationControlInput
		assertFalse(info2.html.contains("Hello Foo"))
		assertTrue(info2.html.contains("Hello BAZ"))
	}
}