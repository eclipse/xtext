/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import com.ibm.icu.text.Transliterator;

/**
 * @author Moritz Eysholdt
 * @author Sven Efftinge
 */
public class UnicodeCharacterDatabaseNames {

	private static final Transliterator transliterator = Transliterator.getInstance("Any-Name");

	/**
	 * Returns the Unicode string name for a character.
	 * 
	 */
	public static String getCharacterName(char character) {
		String transliterated = transliterator.transliterate(String.valueOf(character));
		// returns strings in the for of SEMICOLON}
		return transliterated.substring("\\N{".length(),transliterated.length()-"}".length());
	}
	
}
