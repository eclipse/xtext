/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarAccessExtensionsTest {
	private GrammarAccessExtensions grammarAccessExtensions = new GrammarAccessExtensions();

	@Test
	public void testToJavaIdentifier() {
		Assert.assertEquals("FooBar", grammarAccessExtensions.toJavaIdentifier("foo Bar", true));
		Assert.assertEquals("Foo", grammarAccessExtensions.toJavaIdentifier("foo;", true));
		Assert.assertEquals("foo", grammarAccessExtensions.toJavaIdentifier("foo;", false));
		Assert.assertEquals("Colon", grammarAccessExtensions.toJavaIdentifier(":", true));
		Assert.assertEquals("Colon", grammarAccessExtensions.toJavaIdentifier(":", false));
		Assert.assertEquals("Semicolon", grammarAccessExtensions.toJavaIdentifier(";", false));
		Assert.assertEquals("CommercialAtApostrophe", grammarAccessExtensions.toJavaIdentifier("@\'", false));
		Assert.assertEquals("Grün", grammarAccessExtensions.toJavaIdentifier("Grün", true));
		Assert.assertEquals("DollarSign", grammarAccessExtensions.toJavaIdentifier("$", true));
		Assert.assertEquals("ColonExclamationMarkQuestionMark", grammarAccessExtensions.toJavaIdentifier(":!?", true));
		Assert.assertEquals("_", grammarAccessExtensions.toJavaIdentifier("_", true));
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298492
	 */
	@Test
	public void testBug() throws Exception {
		Assert.assertEquals("HiraganaLetterRu", grammarAccessExtensions.toJavaIdentifier("\u308b", true));
	}

	@Test
	public void testSmoke() throws Exception {
		for (int i = 0; i < 4000; i++) {
			String identifier = grammarAccessExtensions.toJavaIdentifier(String.valueOf((char) i), false);
			for (int j = 0; j < identifier.length(); j++) {
				char charAt = identifier.charAt(j);
				Assert.assertTrue(identifier + ":" + Character.valueOf(charAt),
						grammarAccessExtensions.isValidJavaLatinIdentifier(charAt, j == 0));
			}
		}
	}
}
