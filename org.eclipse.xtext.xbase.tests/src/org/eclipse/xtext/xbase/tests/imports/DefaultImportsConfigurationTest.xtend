/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.imports

import com.google.inject.Inject
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration
import org.eclipse.xtext.xbase.testlanguages.tests.XImportSectionTestLangInjectorProvider
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.assertEquals

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
		'''.toString.replaceAll("\r\n","\n").parse
		
		assertEquals(19, importsConfiguration.getImportSectionOffset(root.eResource as XtextResource))
	}
	
}
