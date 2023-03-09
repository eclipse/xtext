/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;

import java.util.Arrays;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CharacterArray implements ICharacterClass {

	private char[] characters;

	public CharacterArray(char... characters) {
		this.characters = characters.clone();
		Arrays.sort(this.characters);
	}
	
	@Override
	public boolean matches(char candidate) {
		return candidate >= characters[0] && candidate <= characters[characters.length -1 ] &&
			Arrays.binarySearch(characters, candidate) >= 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(characters);
	}

}
