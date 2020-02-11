/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import static org.eclipse.xtext.generator.grammarAccess.UnicodeCharacterDatabaseNames.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class UnicodeCharacterDatabaseNamesTest extends Assert {
	
	@Test public void testGetName() throws Exception {
		assertEquals("LATIN SMALL LETTER U WITH DIAERESIS",getCharacterName('ü'));
		assertEquals("LATIN SMALL LETTER A WITH DIAERESIS",getCharacterName('ä'));
		assertEquals("DIGIT NINE",getCharacterName('9'));
		assertEquals("CJK UNIFIED IDEOGRAPH-4711",getCharacterName('\u4711'));
	}
	
	@Test public void testSmoke() throws Exception {
		for (int i = 0; i < 8000; i++) {
			String characterName = getCharacterName((char)i);
			assertNotNull("Character : "+((char)i),characterName);
		}
	}
	
}
