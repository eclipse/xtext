/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser

import org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguageStandaloneSetup
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.smoketest.processors.PartialParsingProcessor
import org.eclipse.xtext.tests.AbstractXtextTests
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug410560Test extends AbstractXtextTests {
	
	override boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}
	
	override void setUp() throws Exception {
		super.setUp();
		with(SerializationErrorTestLanguageStandaloneSetup);
	}
	
	@Test def void testParsingWithoutIndent_01() {
		val model = getModel('''
			{}
		''') as Model
		assertNotNull(model)
		assertNull(model.test)
	}
	
	@Test def void testParsingWithoutIndent_02() {
		val model = getModel('''
			({})
		''') as Model
		assertNotNull(model)
		assertNull(model.test)
	}
	
	@Test def void testParsingWithIndent_01() {
		val model = getModel('''
			{tworequired a b}
		''') as Model
		assertNotNull(model)
		assertNotNull(model.test)
	}
	
	@Test def void testParsingWithIndent_02() {
		val model = getModel('''
			({tworequired a b})
		''') as Model
		assertNotNull(model)
		assertNotNull(model.test)
	}
	
	@Test def void testPartialParsingChangeIndent() {
		val modelAsString = '({tworequired a b})'
		val model = getModel(modelAsString) as Model
		
		val res = model.eResource as XtextResource
		res.update(modelAsString.indexOf('a'), 1, "b")
		assertSame(model, res.contents.head)
	}
	
	@Test def void testPartialParsingRemoveIndent() {
		val modelAsString = '({ tworequired a b })'
		val model = getModel(modelAsString) as Model
		
		val res = model.eResource as XtextResource
		res.update(modelAsString.indexOf('t'), 'tworequired a b'.length, " ")
		assertSame(model, res.contents.head)
	}
	
	@Test def void testPartialParsingRemoveNestedIndent() {
		val modelAsString = '({{ tworequired a b }})'
		val model = getModel(modelAsString) as Model
		
		val res = model.eResource as XtextResource
		res.update(modelAsString.indexOf('t'), 'tworequired a b'.length, " ")
		assertSame(model, res.contents.head)
	}
	
	@Test def void testPartialParsingRemoveNestedIndent_01() {
		val modelAsString = '({{ tworequired a b }})'
		get(PartialParsingProcessor).processFile(modelAsString, modelAsString, modelAsString.indexOf('t'), 'tworequired a b'.length, " ")
	}
}