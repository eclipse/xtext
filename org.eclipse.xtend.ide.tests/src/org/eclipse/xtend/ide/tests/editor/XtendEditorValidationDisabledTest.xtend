/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IStorage
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory
import org.junit.After
import org.junit.Test

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*

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
