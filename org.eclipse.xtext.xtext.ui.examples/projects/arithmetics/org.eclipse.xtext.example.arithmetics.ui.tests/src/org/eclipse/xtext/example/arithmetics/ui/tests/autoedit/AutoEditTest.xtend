/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.autoedit

import com.google.inject.Inject
import java.util.Collections
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.testing.AbstractAutoEditTest
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil
import org.eclipse.xtext.ui.util.JREContainerProvider
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class AutoEditTest extends AbstractAutoEditTest {

	@Test def void testCalculatorAutoEdit() {
		openEditor('''
			module MyModule
			
			1 + 2;|
		''') => [
			pressKey('\n')
			assertState('''
				module MyModule
				
				1 + 2;
				// = 3
				|
			''')
		]
		
	}

	@Inject FileExtensionProvider extensionProvider
	@Inject PluginProjectFactory projectFactory

	@Before def void doSetup() {
		createPluginProject("foo")
	}

	override protected getFileExtension() {
		extensionProvider.primaryFileExtension
	}

	override protected getEditorId() {
		ArithmeticsActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_ARITHMETICS_ARITHMETICS
	}

	def protected IProject createPluginProject(String name) throws CoreException {
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE) 
		projectFactory.setProjectName(name) 
		projectFactory.addFolders(Collections.singletonList("src")) 
		projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID) 
		projectFactory.addProjectNatures(XtextProjectHelper.NATURE_ID) 
		var IProject result=projectFactory.createProject(new NullProgressMonitor(), null)
		JavaProjectSetupUtil.setUnixLineEndings(result) 
		return result 
	}

}