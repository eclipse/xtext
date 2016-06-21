/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.imports

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.xbase.testlanguages.XImportSectionTestLangInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration
import org.eclipse.xtext.resource.XtextResource

import static org.junit.Assert.assertEquals;
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XImportSectionTestLangInjectorProvider)
class DefaultImportsConfigurationTest {
	
	@Inject extension ParseHelper<ImportSectionTestLanguageRoot>
	@Inject DefaultImportsConfiguration importsConfiguration 
	
	@Test
	def void testParseWithComments() {
		val root  ='''
			// hello
			some token
			import java.util.Set
		'''.parse
		
		assertEquals(19, importsConfiguration.getImportSectionOffset(root.eResource as XtextResource))
	}
	
}