/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import static org.eclipse.xtext.generator.grammarAccess.GrammarAccessUtil.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class GrammarAccessUtilTest extends Assert {
	
	@Test public void testToJavaIdentifier() throws Exception {
		assertEquals("FooBar",toJavaIdentifier("foo Bar", true));
		assertEquals("Foo",toJavaIdentifier("foo;", true));
		assertEquals("foo",toJavaIdentifier("foo;", false));
		assertEquals("Colon",toJavaIdentifier(":", true));
		assertEquals("Colon",toJavaIdentifier(":", false));
		assertEquals("Semicolon",toJavaIdentifier(";", false));
		assertEquals("CommercialAtApostrophe",toJavaIdentifier("@'", false));
		assertEquals("Grün",toJavaIdentifier("Grün", true));
		assertEquals("DollarSign",toJavaIdentifier("$", true));
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298492
	 */
	@Test public void testBug() throws Exception {
		assertEquals("HiraganaLetterRu",toJavaIdentifier("\u308B",true));
	}
	
	@Test public void testSmoke() throws Exception {
		for (int i = 0; i < 4000; i++) {
			String identifier = toJavaIdentifier(String.valueOf((char)i), false);
			
			for (int j = 0; j < identifier.length(); j++) {
				char charAt = identifier.charAt(j);
				assertTrue(identifier+":"+charAt,isValidJavaLatinIdentifier(j==0, charAt));
			}
		}
	}
	
}
