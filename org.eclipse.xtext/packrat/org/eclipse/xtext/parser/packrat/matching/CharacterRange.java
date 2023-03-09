/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.matching;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CharacterRange implements ICharacterClass {

	private final char min;
	
	private final char max;
	
	public CharacterRange(char min, char max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean matches(char candidate) {
		return this.min <= candidate && this.max >= candidate;
	}

	@Override
	public String toString() {
		return "'" + min + "'..'" + max + "'";
	}
	
}
