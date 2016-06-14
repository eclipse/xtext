/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction
import org.junit.After
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author Sven Efftinge
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=456868
 */
class Bug456868Test extends AbstractXtendUITestCase {
	
	@Inject 
	XtendLibClasspathAdder libAdder;
	
	@Inject
	ToggleXtextNatureAction natureAdder
	
	IJavaProject project

	@After override tearDown() throws Exception {
		super.tearDown()
		project.project.delete(true, null)
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=452821
	 */
	@Test def void testProjectWithWhitespaceInNameWorks() {
		// use names with whitespaces
		project = createJavaProject("my project")
		makeJava5Compliant(project)
		libAdder.addLibsToClasspath(project, new NullProgressMonitor());
		natureAdder.toggleNature(project.project)
		createFile("my project/src/MyClass.xtend", '''
			class MyClass {
				
			}
		''')
		
		waitForBuild()
		assertNoErrorsInWorkspace
		val generatedJava = file("my project/xtend-gen/MyClass.java")
		assertTrue(generatedJava.exists)
	}
	
	
}