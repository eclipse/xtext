/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout
import org.junit.runner.RunWith

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider)
class SerializerPerformanceTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ISerializer

	@Rule
	public val Timeout timeout = new Timeout(5000)
	static val numberOfElements = 1000
	static val editEvery = 100
	var Model model

	@Before
	def void setup() {
		model = '''
			entities
				«FOR i : 0 ..< numberOfElements»
					//comment before element
					Foo /* comment between elements*/ "Bar" //comment after element 
				«ENDFOR»
			end
		'''.parse
		val entities = model.domainModel.entities
		val removeUs = (0 ..< numberOfElements).filter[it % editEvery == 0].map[entities.get(it)]
		entities.removeAll(removeUs)
	}

	@Test
	def void test() {
		model.serialize
	}
}
