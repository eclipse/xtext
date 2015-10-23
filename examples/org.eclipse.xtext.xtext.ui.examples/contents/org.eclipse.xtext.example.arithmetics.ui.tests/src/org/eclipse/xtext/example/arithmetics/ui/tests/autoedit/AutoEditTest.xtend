/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.autoedit

import com.google.inject.Inject
import org.eclipse.xtext.example.arithmetics.ui.internal.ArithmeticsActivator
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractAutoEditTest
import org.eclipse.xtext.resource.FileExtensionProvider
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class AutoEditTest extends AbstractAutoEditTest {
	
	@Inject FileExtensionProvider extensionProvider

	override protected getFileExtension() {
		extensionProvider.primaryFileExtension
	}
	
	override protected getEditorId() {
		ArithmeticsActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_ARITHMETICS_ARITHMETICS
	}
	
	
	@Test def void testCalculatorAutoEdit() {
		openEditor('''
			module MyModule
			
			1 + 2;|
		''') => [
			pressKey('\n');
			assertState('''
				module MyModule
				
				1 + 2;
				// = 3
				|
			''', it);
		]
		
		
	}
	
}