/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource

import java.io.IOException
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.util.StringInputStream
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class Bug451668Test extends AbstractXtextTests {
	
	static class TestResource extends DerivedStateAwareResource {
		int contentsCalls = 0 		
		
		@Override override synchronized EList<EObject> getContents() {
			contentsCalls++;
			return super.getContents()
		}
	}
	
	@Test def void testUnloadAndGetContents() throws IOException {
		with(OptionalEmptyTestLanguageStandaloneSetup)
		var r = get(TestResource)
		r.setURI(URI.createURI('foo.dummy'))
		r.load(new StringInputStream(''), null)
		assertTrue(r.isLoaded())
		val callsBeforeUnload = r.contentsCalls
		r.unload()
		assertEquals(callsBeforeUnload, r.contentsCalls)
		assertFalse(r.isLoaded)
		assertNull(r.parseResult)
	}
}