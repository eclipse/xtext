/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.ui.texteditor.MarkerUtilities

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug452821Test extends AbstractXtendUITestCase {
	
	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Before @After def void cleanUp() {
		workbenchTestHelper.tearDown
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=452821
	 */
	@Test def void testCompileAnonymousClass() {
		val file = workbenchTestHelper.createFile('AnonymousClassTest.xtend', '''
			class AnonymousClassTest {
			  def test() {
			    new Exception("") {
			      var String field
			    }
			  }
			}
		''')
		waitForBuild()
		file.assertNoErrors
	}
	
	private def void assertNoErrors(IFile file) {
		val findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities.getMessage(iMarker), MarkerUtilities.getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
}