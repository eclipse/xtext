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
public class SingleCharacter implements ICharacterClass {

	private char c;

	public SingleCharacter(char c) {
		this.c = c;
	}
	
	@Override
	public boolean matches(char candidate) {
		return candidate == c;
	}

	@Override
	public String toString() {
		return "'" + Character.toString(c) + "'";
	}
	
	

}
