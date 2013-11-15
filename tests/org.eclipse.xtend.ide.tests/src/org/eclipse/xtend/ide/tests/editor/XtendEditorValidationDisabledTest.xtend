/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IStorage
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory
import org.junit.After
import org.junit.Test

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XtendEditorValidationDisabledTest extends AbstractXtendUITestCase {

	@Inject
	IResourceForEditorInputFactory resourceForEditorInputFactory

	@After
	override tearDown() throws Exception {
		cleanWorkspace
	}

	@Test def void testIsValidationEnabled() {
		'testProject'.createJavaProject => [
			addSourceFolder('filtered-src', null, #["**.xtend"])
		]
		val file = 'testProject/filtered-src/Foo.xtend'.createFile('class Foo {}')
		assertTrue(isValidationDisabled(file))
	}

	@Test def void testIsValidationDisabled() {
		'testProject'.createJavaProject => [
			addSourceFolder('filtered-src', null, null)
		]
		val file = 'testProject/filtered-src/Foo.xtend'.createFile('class Foo {}')
		assertFalse(isValidationDisabled(file))
	}

	def boolean isValidationDisabled(IStorage storage) {
		val method = resourceForEditorInputFactory.class.getDeclaredMethod("isValidationDisabled", typeof(IStorage))
		method.accessible = true
		return method.invoke(resourceForEditorInputFactory, storage) as Boolean
	}

}
