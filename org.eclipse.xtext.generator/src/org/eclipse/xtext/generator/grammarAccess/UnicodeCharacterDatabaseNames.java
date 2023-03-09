/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

/**
 * @author Moritz Eysholdt
 * @author Sven Efftinge
 * 
 * @deprecated will be removed with Xtext 2.30
 */
@Deprecated(forRemoval=true)
public class UnicodeCharacterDatabaseNames {

	/**
	 * Returns the Unicode string name for a character.
	 *
	 */
	public static String getCharacterName(char character) {
		return Character.getName(character);
	}

}
