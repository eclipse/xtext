/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.junit.Test
import static org.junit.Assert.*
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class GrammarAccessExtensionsTest {
	
	extension GrammarAccessExtensions = new GrammarAccessExtensions  
	
	@Test def void testToJavaIdentifier() {
		assertEquals("FooBar", toJavaIdentifier("foo Bar", true));
		assertEquals("Foo", toJavaIdentifier("foo;", true));
		assertEquals("foo", toJavaIdentifier("foo;", false));
		assertEquals("Colon", toJavaIdentifier(":", true));
		assertEquals("Colon", toJavaIdentifier(":", false));
		assertEquals("Semicolon", toJavaIdentifier(";", false));
		assertEquals("CommercialAtApostrophe", toJavaIdentifier("@'", false));
		assertEquals("Grün", toJavaIdentifier("Grün", true));
		assertEquals("DollarSign", toJavaIdentifier("$", true));
		assertEquals("_", toJavaIdentifier("_", true));
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298492
	 */
	@Test def void testBug() throws Exception {
		assertEquals("HiraganaLetterRu", toJavaIdentifier("\u308B",true));
	}
	
	@Test def void testSmoke() throws Exception {
		for (var int i = 0; i < 4000; i++) {
			val identifier = toJavaIdentifier(String.valueOf(i as char), false)
			
			for (var int j = 0; j < identifier.length(); j++) {
				val char charAt = identifier.charAt(j)
				assertTrue(identifier+":"+charAt, charAt.isValidJavaLatinIdentifier(j==0))
			}
		}
	}
	
}
